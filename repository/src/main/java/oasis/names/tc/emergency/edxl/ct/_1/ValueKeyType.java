//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.01 at 06:02:17 PM EEST 
//


package oasis.names.tc.emergency.edxl.ct._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ValueKeyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValueKeyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:tc:emergency:edxl:ct:1.0}ValueListURI"/>
 *         &lt;element ref="{urn:oasis:names:tc:emergency:edxl:ct:1.0}Value"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValueKeyType", propOrder = {
    "valueListURI",
    "value"
})
public class ValueKeyType {

    @XmlElement(name = "ValueListURI", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String valueListURI;
    @XmlElement(name = "Value", required = true)
    protected String value;

    /**
     * Gets the value of the valueListURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValueListURI() {
        return valueListURI;
    }

    /**
     * Sets the value of the valueListURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValueListURI(String value) {
        this.valueListURI = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

}
