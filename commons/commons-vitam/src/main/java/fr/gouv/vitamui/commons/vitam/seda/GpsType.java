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

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GpsType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GpsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GpsVersionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GpsAltitude" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="GpsAltitudeRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GpsLatitude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GpsLatitudeRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GpsLongitude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GpsLongitudeRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GpsDateStamp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GpsType", propOrder = {
    "gpsVersionID",
    "gpsAltitude",
    "gpsAltitudeRef",
    "gpsLatitude",
    "gpsLatitudeRef",
    "gpsLongitude",
    "gpsLongitudeRef",
    "gpsDateStamp"
})
public class GpsType {

    @XmlElement(name = "GpsVersionID")
    protected String gpsVersionID;
    @XmlElement(name = "GpsAltitude")
    protected BigInteger gpsAltitude;
    @XmlElement(name = "GpsAltitudeRef")
    protected String gpsAltitudeRef;
    @XmlElement(name = "GpsLatitude")
    protected String gpsLatitude;
    @XmlElement(name = "GpsLatitudeRef")
    protected String gpsLatitudeRef;
    @XmlElement(name = "GpsLongitude")
    protected String gpsLongitude;
    @XmlElement(name = "GpsLongitudeRef")
    protected String gpsLongitudeRef;
    @XmlElement(name = "GpsDateStamp")
    protected String gpsDateStamp;

    /**
     * Gets the value of the gpsVersionID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGpsVersionID() {
        return gpsVersionID;
    }

    /**
     * Sets the value of the gpsVersionID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGpsVersionID(String value) {
        this.gpsVersionID = value;
    }

    /**
     * Gets the value of the gpsAltitude property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getGpsAltitude() {
        return gpsAltitude;
    }

    /**
     * Sets the value of the gpsAltitude property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setGpsAltitude(BigInteger value) {
        this.gpsAltitude = value;
    }

    /**
     * Gets the value of the gpsAltitudeRef property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGpsAltitudeRef() {
        return gpsAltitudeRef;
    }

    /**
     * Sets the value of the gpsAltitudeRef property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGpsAltitudeRef(String value) {
        this.gpsAltitudeRef = value;
    }

    /**
     * Gets the value of the gpsLatitude property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGpsLatitude() {
        return gpsLatitude;
    }

    /**
     * Sets the value of the gpsLatitude property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGpsLatitude(String value) {
        this.gpsLatitude = value;
    }

    /**
     * Gets the value of the gpsLatitudeRef property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGpsLatitudeRef() {
        return gpsLatitudeRef;
    }

    /**
     * Sets the value of the gpsLatitudeRef property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGpsLatitudeRef(String value) {
        this.gpsLatitudeRef = value;
    }

    /**
     * Gets the value of the gpsLongitude property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGpsLongitude() {
        return gpsLongitude;
    }

    /**
     * Sets the value of the gpsLongitude property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGpsLongitude(String value) {
        this.gpsLongitude = value;
    }

    /**
     * Gets the value of the gpsLongitudeRef property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGpsLongitudeRef() {
        return gpsLongitudeRef;
    }

    /**
     * Sets the value of the gpsLongitudeRef property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGpsLongitudeRef(String value) {
        this.gpsLongitudeRef = value;
    }

    /**
     * Gets the value of the gpsDateStamp property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGpsDateStamp() {
        return gpsDateStamp;
    }

    /**
     * Sets the value of the gpsDateStamp property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGpsDateStamp(String value) {
        this.gpsDateStamp = value;
    }

}