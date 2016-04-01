//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.01 at 06:02:17 PM EEST 
//


package oasis.names.tc.emergency.edxl.tep._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import oasis.names.tc.emergency.edxl.ct._1.EDXLLocationType;


/**
 * 
 * 				Group of elements used to describe and track physical movement or transport of a patient.
 * 			
 * 
 * <p>Java class for PatientTransferType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PatientTransferType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="destinationETA" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}EDXLDateTimeType" minOccurs="0"/>
 *         &lt;element name="destination" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}EDXLLocationType"/>
 *         &lt;element name="actualArrivalDateTime" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}EDXLDateTimeType" minOccurs="0"/>
 *         &lt;element name="actualDepartureTime" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}EDXLDateTimeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PatientTransferType", propOrder = {
    "destinationETA",
    "destination",
    "actualArrivalDateTime",
    "actualDepartureTime"
})
public class PatientTransferType {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar destinationETA;
    @XmlElement(required = true)
    protected EDXLLocationType destination;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar actualArrivalDateTime;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar actualDepartureTime;

    /**
     * Gets the value of the destinationETA property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDestinationETA() {
        return destinationETA;
    }

    /**
     * Sets the value of the destinationETA property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDestinationETA(XMLGregorianCalendar value) {
        this.destinationETA = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link EDXLLocationType }
     *     
     */
    public EDXLLocationType getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link EDXLLocationType }
     *     
     */
    public void setDestination(EDXLLocationType value) {
        this.destination = value;
    }

    /**
     * Gets the value of the actualArrivalDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActualArrivalDateTime() {
        return actualArrivalDateTime;
    }

    /**
     * Sets the value of the actualArrivalDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActualArrivalDateTime(XMLGregorianCalendar value) {
        this.actualArrivalDateTime = value;
    }

    /**
     * Gets the value of the actualDepartureTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActualDepartureTime() {
        return actualDepartureTime;
    }

    /**
     * Sets the value of the actualDepartureTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActualDepartureTime(XMLGregorianCalendar value) {
        this.actualDepartureTime = value;
    }

}