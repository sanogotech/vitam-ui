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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * La liste d'identifiants de règles à appliquer et à ignorer qui doit être appliquée à partir de cet ArchiveUnit.
 *
 * <p>Java class for ClassificationRuleType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ClassificationRuleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element name="Rule" type="{fr:gouv:culture:archivesdefrance:seda:v2.1}RuleIdType"/&gt;
 *           &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;element name="ClassificationAudience" type="{fr:gouv:culture:archivesdefrance:seda:v2.1}NonEmptyTokenType" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;group ref="{fr:gouv:culture:archivesdefrance:seda:v2.1}PreventInheritanceGroup"/&gt;
 *           &lt;element name="RefNonRuleId" type="{fr:gouv:culture:archivesdefrance:seda:v2.1}RuleIdType" maxOccurs="unbounded"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="ClassificationLevel" type="{fr:gouv:culture:archivesdefrance:seda:v2.1}NonEmptyTokenType"/&gt;
 *         &lt;element name="ClassificationOwner" type="{fr:gouv:culture:archivesdefrance:seda:v2.1}NonEmptyTokenType"/&gt;
 *         &lt;element name="ClassificationReassessingDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="NeedReassessingAuthorization" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassificationRuleType", propOrder = {
    "ruleAndStartDate",
    "classificationAudience",
    "preventInheritance",
    "refNonRuleId",
    "classificationLevel",
    "classificationOwner",
    "classificationReassessingDate",
    "needReassessingAuthorization"
})
public class ClassificationRuleType {

    @XmlElements({
        @XmlElement(name = "Rule", type = RuleIdType.class),
        @XmlElement(name = "StartDate", type = XMLGregorianCalendar.class, nillable = true)
    })
    protected List<Object> ruleAndStartDate;
    @XmlElement(name = "ClassificationAudience")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String classificationAudience;
    @XmlElement(name = "PreventInheritance", defaultValue = "false")
    protected Boolean preventInheritance;
    @XmlElement(name = "RefNonRuleId")
    protected List<RuleIdType> refNonRuleId;
    @XmlElement(name = "ClassificationLevel", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String classificationLevel;
    @XmlElement(name = "ClassificationOwner", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String classificationOwner;
    @XmlElement(name = "ClassificationReassessingDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar classificationReassessingDate;
    @XmlElement(name = "NeedReassessingAuthorization")
    protected Boolean needReassessingAuthorization;

    /**
     * Gets the value of the ruleAndStartDate property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ruleAndStartDate property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRuleAndStartDate().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RuleIdType }
     * {@link XMLGregorianCalendar }
     *
     *
     */
    public List<Object> getRuleAndStartDate() {
        if (ruleAndStartDate == null) {
            ruleAndStartDate = new ArrayList<Object>();
        }
        return this.ruleAndStartDate;
    }

    /**
     * Gets the value of the classificationAudience property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getClassificationAudience() {
        return classificationAudience;
    }

    /**
     * Sets the value of the classificationAudience property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setClassificationAudience(String value) {
        this.classificationAudience = value;
    }

    /**
     * Gets the value of the preventInheritance property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isPreventInheritance() {
        return preventInheritance;
    }

    /**
     * Sets the value of the preventInheritance property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setPreventInheritance(Boolean value) {
        this.preventInheritance = value;
    }

    /**
     * Gets the value of the refNonRuleId property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the refNonRuleId property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefNonRuleId().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RuleIdType }
     *
     *
     */
    public List<RuleIdType> getRefNonRuleId() {
        if (refNonRuleId == null) {
            refNonRuleId = new ArrayList<RuleIdType>();
        }
        return this.refNonRuleId;
    }

    /**
     * Gets the value of the classificationLevel property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getClassificationLevel() {
        return classificationLevel;
    }

    /**
     * Sets the value of the classificationLevel property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setClassificationLevel(String value) {
        this.classificationLevel = value;
    }

    /**
     * Gets the value of the classificationOwner property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getClassificationOwner() {
        return classificationOwner;
    }

    /**
     * Sets the value of the classificationOwner property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setClassificationOwner(String value) {
        this.classificationOwner = value;
    }

    /**
     * Gets the value of the classificationReassessingDate property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getClassificationReassessingDate() {
        return classificationReassessingDate;
    }

    /**
     * Sets the value of the classificationReassessingDate property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setClassificationReassessingDate(XMLGregorianCalendar value) {
        this.classificationReassessingDate = value;
    }

    /**
     * Gets the value of the needReassessingAuthorization property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public Boolean isNeedReassessingAuthorization() {
        return needReassessingAuthorization;
    }

    /**
     * Sets the value of the needReassessingAuthorization property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setNeedReassessingAuthorization(Boolean value) {
        this.needReassessingAuthorization = value;
    }

}
