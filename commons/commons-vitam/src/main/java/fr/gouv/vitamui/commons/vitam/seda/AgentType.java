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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.02.12 at 11:35:36 AM CET
//


package fr.gouv.vitamui.commons.vitam.seda;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Informations décrivant une personne physique ou morale.
 *
 * <p>Java class for AgentType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AgentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;group ref="{fr:gouv:culture:archivesdefrance:seda:v2.1}PersonOrEntityGroup"/&gt;
 *         &lt;group ref="{fr:gouv:culture:archivesdefrance:seda:v2.1}BusinessGroup"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AgentType", propOrder = {
    "content"
})
public class AgentType {

    @XmlElementRefs({
        @XmlElementRef(name = "FirstName", namespace = "fr:gouv:culture:archivesdefrance:seda:v2.1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BirthPlace", namespace = "fr:gouv:culture:archivesdefrance:seda:v2.1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Corpname", namespace = "fr:gouv:culture:archivesdefrance:seda:v2.1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Mandate", namespace = "fr:gouv:culture:archivesdefrance:seda:v2.1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BirthDate", namespace = "fr:gouv:culture:archivesdefrance:seda:v2.1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BirthName", namespace = "fr:gouv:culture:archivesdefrance:seda:v2.1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DeathPlace", namespace = "fr:gouv:culture:archivesdefrance:seda:v2.1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Activity", namespace = "fr:gouv:culture:archivesdefrance:seda:v2.1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Nationality", namespace = "fr:gouv:culture:archivesdefrance:seda:v2.1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Function", namespace = "fr:gouv:culture:archivesdefrance:seda:v2.1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DeathDate", namespace = "fr:gouv:culture:archivesdefrance:seda:v2.1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Identifier", namespace = "fr:gouv:culture:archivesdefrance:seda:v2.1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Position", namespace = "fr:gouv:culture:archivesdefrance:seda:v2.1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "GivenName", namespace = "fr:gouv:culture:archivesdefrance:seda:v2.1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Gender", namespace = "fr:gouv:culture:archivesdefrance:seda:v2.1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Role", namespace = "fr:gouv:culture:archivesdefrance:seda:v2.1", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "FullName", namespace = "fr:gouv:culture:archivesdefrance:seda:v2.1", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> content;

    /**
     * Gets the rest of the content model.
     *
     * <p>
     * You are getting this "catch-all" property because of the following reason:
     * The field name "Identifier" is used by two different parts of a schema. See:
     * line 884 of seda/seda-2.1-ontology.xsd
     * line 872 of seda/seda-2.1-ontology.xsd
     * <p>
     * To get rid of this property, apply a property customization to one
     * of both of the following declarations to change their names:
     * Gets the value of the content property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link fr.gouv.vitamui.commons.vitam.seda.DescriptiveMetadataContentType.Signature.Validator.BirthPlace }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link fr.gouv.vitamui.commons.vitam.seda.DescriptiveMetadataContentType.Signature.Validator.DeathPlace }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     *
     */
    public List<JAXBElement<?>> getContent() {
        if (content == null) {
            content = new ArrayList<JAXBElement<?>>();
        }
        return this.content;
    }

}