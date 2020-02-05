/**
 * Copyright French Prime minister Office/SGMAP/DINSIC/Vitam Program (2019-2020)
 * and the signatories of the "VITAM - Accord du Contributeur" agreement.
 *
 * contact@programmevitam.fr
 *
 * This software is a computer program whose purpose is to implement
 * implement a digital archiving front-office system for the secure and
 * efficient high volumetry VITAM solution.
 *
 * This software is governed by the CeCILL-C license under French law and
 * abiding by the rules of distribution of free software.  You can  use,
 * modify and/ or redistribute the software under the terms of the CeCILL-C
 * license as circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info".
 *
 * As a counterpart to the access to the source code and  rights to copy,
 * modify and redistribute granted by the license, users are provided only
 * with a limited warranty  and the software's author,  the holder of the
 * economic rights,  and the successive licensors  have only  limited
 * liability.
 *
 * In this respect, the user's attention is drawn to the risks associated
 * with loading,  using,  modifying and/or developing or reproducing the
 * software by the user in light of its specific status of free software,
 * that may mean  that it is complicated to manipulate,  and  that  also
 * therefore means  that it is reserved for developers  and  experienced
 * professionals having in-depth computer knowledge. Users are therefore
 * encouraged to load and test the software's suitability as regards their
 * requirements in conditions enabling the security of their systems and/or
 * data to be ensured and,  more generally, to use and operate it in the
 * same conditions as regards security.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL-C license and that you accept its terms.
 */
package fr.gouv.vitamui.iam.internal.server.tenant.service;

import java.io.IOException;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.gouv.vitam.access.external.common.exception.AccessExternalClientException;
import fr.gouv.vitam.common.client.VitamContext;
import fr.gouv.vitam.common.database.builder.request.single.Select;
import fr.gouv.vitam.common.exception.InvalidParseOperationException;
import fr.gouv.vitam.common.exception.VitamClientException;
import fr.gouv.vitam.common.model.RequestResponse;
import fr.gouv.vitam.common.model.administration.AccessContractModel;
import fr.gouv.vitam.common.model.administration.IngestContractModel;
import fr.gouv.vitamui.commons.api.domain.AccessContractModelDto;
import fr.gouv.vitamui.commons.api.domain.IngestContractDto;
import fr.gouv.vitamui.commons.api.domain.TenantDto;
import fr.gouv.vitamui.commons.api.exception.ApplicationServerException;
import fr.gouv.vitamui.commons.api.logger.VitamUILogger;
import fr.gouv.vitamui.commons.api.logger.VitamUILoggerFactory;
import fr.gouv.vitamui.commons.vitam.api.administration.AccessContractService;
import fr.gouv.vitamui.commons.vitam.api.administration.IngestContractService;
import fr.gouv.vitamui.commons.vitam.api.dto.AccessContractResponseDto;
import fr.gouv.vitamui.commons.vitam.api.dto.IngestContractResponseDto;
import fr.gouv.vitamui.commons.vitam.api.util.VitamRestUtils;
import fr.gouv.vitamui.iam.internal.server.tenant.converter.TenantConverter;
import fr.gouv.vitamui.iam.internal.server.tenant.domain.Tenant;
import fr.gouv.vitamui.iam.security.service.InternalSecurityService;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * Class responsible of init vitam tenant with accessContract and ingestContract for the proper functioning of VITAMUI
 *
 *
 */
@Getter
@Setter
public class InitVitamTenantService {

    private final AccessContractService accessContractService;

    private final IngestContractService ingestContractService;

    private final InternalSecurityService internalSecurityService;

    private final TenantConverter tenantConverter;

    private ObjectMapper objectMapper;

    @Value("classpath:data/tenant/ingest-contract/holding.json")
    private Resource holdingIngestContract;

    @Value("classpath:data/tenant/access-contract/full-access.json")
    private Resource fullAccessAccessContract;

    @Value("classpath:data/tenant/access-contract/logbook.json")
    private Resource logbookAccessContract;

    @Value("classpath:data/tenant/access-contract/holding.json")
    private Resource holdingAccessContract;

    @Value("${vitam.tenant.init.mandatory:true}")
    private Boolean mandatory;

    public static final String HOLDING_ACCESS_CONTRACT_NAME = "Contrat Acces Arbre";

    public static final String INGEST_CONTRACT_NAME = "Contrat Entree Arbre";

    public static final String LOGBOOK_ACCESS_CONTRACT_NAME = "Contrat Acces Logbook";

    public static final String FULL_ACCESS_CONTRACT_NAME = "Contrat Acces Full";

    private static final String STATUS = "ACTIVE";

    private static final VitamUILogger LOGGER = VitamUILoggerFactory.getInstance(InitVitamTenantService.class);

    public InitVitamTenantService(final AccessContractService accessContractService,
            final IngestContractService ingestContractService, final InternalSecurityService internalSecurityService,
            final TenantConverter tenantConverter) {
        this.accessContractService = accessContractService;
        this.ingestContractService = ingestContractService;
        this.internalSecurityService = internalSecurityService;
        this.tenantConverter = tenantConverter;
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public Tenant init(final Tenant tenant) {
        final TenantDto tenantDto = tenantConverter.convertEntityToDto(tenant);
        this.init(tenantDto);
        return tenantConverter.convertDtoToEntity(tenantDto);
    }

    @PostConstruct
    public void postConstruct() {
        LOGGER.info("init vitam tenant is mandatory : {}", mandatory);
    }

    public void init(final TenantDto tenantDto) {
        if (!mandatory) {
            return;
        }
        final VitamContext vitamContext = new VitamContext(tenantDto.getIdentifier())
                .setApplicationSessionId(internalSecurityService.getApplicationId());
        try {
            initAccessContract(tenantDto, vitamContext);
            initIngestContract(tenantDto, vitamContext);

        }
        catch (IOException | InvalidParseOperationException | AccessExternalClientException e) {
            LOGGER.error("Exception during initialization of tenant {}", tenantDto.getIdentifier(), e);
            throw new ApplicationServerException("Unable to init vitam tenant", e);
        }
    }

    private void initIngestContract(final TenantDto tenantDto, final VitamContext vitamContext)
            throws InvalidParseOperationException, AccessExternalClientException, IOException {

        try {
            Optional<IngestContractDto> optIngestContract = retrieveIngestContractByName(vitamContext,
                    INGEST_CONTRACT_NAME);

            // If no ingestContract already exist so we create an ingest contract
            if (!optIngestContract.isPresent() || !StringUtils.equals(optIngestContract.get().getStatus(), STATUS)) {
                final RequestResponse<?> responseIngestContract = ingestContractService
                        .createIngestContracts(vitamContext, holdingIngestContract.getInputStream());
                VitamRestUtils.checkResponse(responseIngestContract, HttpServletResponse.SC_OK);
                optIngestContract = retrieveIngestContractByName(vitamContext, INGEST_CONTRACT_NAME);
            }

            checkOptionalIsPresent(optIngestContract,
                    "Unable to find ingest contract with name " + INGEST_CONTRACT_NAME);
            tenantDto.setIngestContractHoldingIdentifier(optIngestContract.get().getIdentifier());

        }
        catch (final VitamClientException e) {
            LOGGER.error("Exception during ingest contracts initialization for tenant {}", tenantDto.getIdentifier(),
                    e);
            throw new ApplicationServerException(e);
        }

    }

    private Optional<IngestContractDto> retrieveIngestContractByName(final VitamContext vitamContext, final String Name)
            throws VitamClientException, JsonProcessingException {
        final RequestResponse<IngestContractModel> requestResponse = ingestContractService
                .findIngestContracts(vitamContext, new Select().getFinalSelect());
        final IngestContractResponseDto ingestContractResponseDto = objectMapper
                .treeToValue(requestResponse.toJsonNode(), IngestContractResponseDto.class);
        return ingestContractResponseDto.getResults().stream()
                .filter(i -> StringUtils.equals(i.getName(), Name) && StringUtils.equals(i.getStatus(), STATUS))
                .findFirst();
    }

    private void initAccessContract(final TenantDto tenantDto, final VitamContext vitamContext)
            throws InvalidParseOperationException, AccessExternalClientException, IOException {

        try {
            Optional<AccessContractModelDto> optHoldingAccessContract = retrieveAccessContractByName(vitamContext,
                    HOLDING_ACCESS_CONTRACT_NAME);

            if (!optHoldingAccessContract.isPresent()
                    || !StringUtils.equals(optHoldingAccessContract.get().getStatus(), STATUS)) {
                final RequestResponse<?> responseAccessContract = accessContractService
                        .createAccessContracts(vitamContext, holdingAccessContract.getInputStream());
                VitamRestUtils.checkResponse(responseAccessContract, HttpServletResponse.SC_OK);
                optHoldingAccessContract = retrieveAccessContractByName(vitamContext, HOLDING_ACCESS_CONTRACT_NAME);
            }

            checkOptionalIsPresent(optHoldingAccessContract,
                    "Unable to find access contract with name " + HOLDING_ACCESS_CONTRACT_NAME);
            tenantDto.setAccessContractHoldingIdentifier(optHoldingAccessContract.get().getIdentifier());

            Optional<AccessContractModelDto> optFullAccessAccessContract = retrieveAccessContractByName(vitamContext,
                    FULL_ACCESS_CONTRACT_NAME);
            if (!optFullAccessAccessContract.isPresent()
                    || !StringUtils.equals(optFullAccessAccessContract.get().getStatus(), STATUS)) {
                final RequestResponse<?> responseAccessContract = accessContractService
                        .createAccessContracts(vitamContext, fullAccessAccessContract.getInputStream());
                VitamRestUtils.checkResponse(responseAccessContract, HttpServletResponse.SC_OK);
                optFullAccessAccessContract = retrieveAccessContractByName(vitamContext, FULL_ACCESS_CONTRACT_NAME);
            }

            checkOptionalIsPresent(optFullAccessAccessContract,
                    "Unable to find access contract with name " + FULL_ACCESS_CONTRACT_NAME);

            if (tenantDto.isProof()) {
                Optional<AccessContractModelDto> optLogbookAccessContract = retrieveAccessContractByName(vitamContext,
                        LOGBOOK_ACCESS_CONTRACT_NAME);

                if (!optLogbookAccessContract.isPresent()
                        || !StringUtils.equals(optLogbookAccessContract.get().getStatus(), STATUS)) {
                    final RequestResponse<?> responseAccessContract = accessContractService
                            .createAccessContracts(vitamContext, logbookAccessContract.getInputStream());
                    VitamRestUtils.checkResponse(responseAccessContract, HttpServletResponse.SC_OK);
                    optLogbookAccessContract = retrieveAccessContractByName(vitamContext, LOGBOOK_ACCESS_CONTRACT_NAME);
                }

                checkOptionalIsPresent(optLogbookAccessContract,
                        "Unable to find access contract with name " + LOGBOOK_ACCESS_CONTRACT_NAME);
                tenantDto.setAccessContractLogbookIdentifier(optLogbookAccessContract.get().getIdentifier());
            }

        }
        catch (final VitamClientException e) {
            LOGGER.error("Exception during access contracts initialization for tenant {}", tenantDto.getIdentifier(),
                    e);
            throw new ApplicationServerException(e);
        }

    }

    private Optional<AccessContractModelDto> retrieveAccessContractByName(final VitamContext vitamContext,
            final String Name) throws VitamClientException, JsonProcessingException {
        final RequestResponse<AccessContractModel> requestResponse = accessContractService
                .findAccessContracts(vitamContext, new Select().getFinalSelect());
        final AccessContractResponseDto accessContractResponseDto = objectMapper
                .treeToValue(requestResponse.toJsonNode(), AccessContractResponseDto.class);
        return accessContractResponseDto.getResults().stream()
                .filter(a -> StringUtils.equals(a.getName(), Name) && StringUtils.equals(a.getStatus(), STATUS))
                .findFirst();
    }

    private void checkOptionalIsPresent(final Optional<?> optional, final String msg) {
        optional.orElseThrow(() -> new ApplicationServerException(msg));

    }

}
