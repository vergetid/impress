//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.15 at 12:31:13 PM EET 
//


package oasis.names.tc.emergency.edxl.sitrep._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DisasterInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DisasterInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DisasterName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DisasterDeclarationAuthority" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DisasterDeclarationDateTime" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}EDXLDateTimeType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DisasterInformation", propOrder = {
    "disasterName",
    "disasterDeclarationAuthority",
    "disasterDeclarationDateTime"
})
public class DisasterInformation {

    @XmlElement(name = "DisasterName", required = true)
    protected String disasterName;
    @XmlElement(name = "DisasterDeclarationAuthority", required = true)
    protected String disasterDeclarationAuthority;
    @XmlElement(name = "DisasterDeclarationDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar disasterDeclarationDateTime;

    /**
     * Gets the value of the disasterName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisasterName() {
        return disasterName;
    }

    /**
     * Sets the value of the disasterName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisasterName(String value) {
        this.disasterName = value;
    }

    /**
     * Gets the value of the disasterDeclarationAuthority property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisasterDeclarationAuthority() {
        return disasterDeclarationAuthority;
    }

    /**
     * Sets the value of the disasterDeclarationAuthority property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisasterDeclarationAuthority(String value) {
        this.disasterDeclarationAuthority = value;
    }

    /**
     * Gets the value of the disasterDeclarationDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDisasterDeclarationDateTime() {
        return disasterDeclarationDateTime;
    }

    /**
     * Sets the value of the disasterDeclarationDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDisasterDeclarationDateTime(XMLGregorianCalendar value) {
        this.disasterDeclarationDateTime = value;
    }

}
