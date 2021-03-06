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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Permet d'exprimer les mesures de dimensions basiques.
 *
 * <p>Java class for DimensionsType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DimensionsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{fr:gouv:culture:archivesdefrance:seda:v2.1}BaseDimensionsType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Width" type="{fr:gouv:culture:archivesdefrance:seda:v2.1}MeasurementType" minOccurs="0"/&gt;
 *         &lt;element name="Height" type="{fr:gouv:culture:archivesdefrance:seda:v2.1}MeasurementType" minOccurs="0"/&gt;
 *         &lt;element name="Depth" type="{fr:gouv:culture:archivesdefrance:seda:v2.1}MeasurementType" minOccurs="0"/&gt;
 *         &lt;element name="Shape" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Diameter" type="{fr:gouv:culture:archivesdefrance:seda:v2.1}MeasurementType" minOccurs="0"/&gt;
 *         &lt;element name="Length" type="{fr:gouv:culture:archivesdefrance:seda:v2.1}MeasurementType" minOccurs="0"/&gt;
 *         &lt;element name="Thickness" type="{fr:gouv:culture:archivesdefrance:seda:v2.1}MeasurementType" minOccurs="0"/&gt;
 *         &lt;element name="Weight" type="{fr:gouv:culture:archivesdefrance:seda:v2.1}MeasurementWeightType" minOccurs="0"/&gt;
 *         &lt;element name="NumberOfPage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DimensionsType", propOrder = {
    "width",
    "height",
    "depth",
    "shape",
    "diameter",
    "length",
    "thickness",
    "weight",
    "numberOfPage"
})
public class DimensionsType
    extends BaseDimensionsType
{

    @XmlElement(name = "Width")
    protected MeasurementType width;
    @XmlElement(name = "Height")
    protected MeasurementType height;
    @XmlElement(name = "Depth")
    protected MeasurementType depth;
    @XmlElement(name = "Shape")
    protected String shape;
    @XmlElement(name = "Diameter")
    protected MeasurementType diameter;
    @XmlElement(name = "Length")
    protected MeasurementType length;
    @XmlElement(name = "Thickness")
    protected MeasurementType thickness;
    @XmlElement(name = "Weight")
    protected MeasurementWeightType weight;
    @XmlElement(name = "NumberOfPage")
    protected Integer numberOfPage;

    /**
     * Gets the value of the width property.
     *
     * @return
     *     possible object is
     *     {@link MeasurementType }
     *
     */
    public MeasurementType getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     *
     * @param value
     *     allowed object is
     *     {@link MeasurementType }
     *
     */
    public void setWidth(MeasurementType value) {
        this.width = value;
    }

    /**
     * Gets the value of the height property.
     *
     * @return
     *     possible object is
     *     {@link MeasurementType }
     *
     */
    public MeasurementType getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     *
     * @param value
     *     allowed object is
     *     {@link MeasurementType }
     *
     */
    public void setHeight(MeasurementType value) {
        this.height = value;
    }

    /**
     * Gets the value of the depth property.
     *
     * @return
     *     possible object is
     *     {@link MeasurementType }
     *
     */
    public MeasurementType getDepth() {
        return depth;
    }

    /**
     * Sets the value of the depth property.
     *
     * @param value
     *     allowed object is
     *     {@link MeasurementType }
     *
     */
    public void setDepth(MeasurementType value) {
        this.depth = value;
    }

    /**
     * Gets the value of the shape property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getShape() {
        return shape;
    }

    /**
     * Sets the value of the shape property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setShape(String value) {
        this.shape = value;
    }

    /**
     * Gets the value of the diameter property.
     *
     * @return
     *     possible object is
     *     {@link MeasurementType }
     *
     */
    public MeasurementType getDiameter() {
        return diameter;
    }

    /**
     * Sets the value of the diameter property.
     *
     * @param value
     *     allowed object is
     *     {@link MeasurementType }
     *
     */
    public void setDiameter(MeasurementType value) {
        this.diameter = value;
    }

    /**
     * Gets the value of the length property.
     *
     * @return
     *     possible object is
     *     {@link MeasurementType }
     *
     */
    public MeasurementType getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     *
     * @param value
     *     allowed object is
     *     {@link MeasurementType }
     *
     */
    public void setLength(MeasurementType value) {
        this.length = value;
    }

    /**
     * Gets the value of the thickness property.
     *
     * @return
     *     possible object is
     *     {@link MeasurementType }
     *
     */
    public MeasurementType getThickness() {
        return thickness;
    }

    /**
     * Sets the value of the thickness property.
     *
     * @param value
     *     allowed object is
     *     {@link MeasurementType }
     *
     */
    public void setThickness(MeasurementType value) {
        this.thickness = value;
    }

    /**
     * Gets the value of the weight property.
     *
     * @return
     *     possible object is
     *     {@link MeasurementWeightType }
     *
     */
    public MeasurementWeightType getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     *
     * @param value
     *     allowed object is
     *     {@link MeasurementWeightType }
     *
     */
    public void setWeight(MeasurementWeightType value) {
        this.weight = value;
    }

    /**
     * Gets the value of the numberOfPage property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getNumberOfPage() {
        return numberOfPage;
    }

    /**
     * Sets the value of the numberOfPage property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setNumberOfPage(Integer value) {
        this.numberOfPage = value;
    }

}
