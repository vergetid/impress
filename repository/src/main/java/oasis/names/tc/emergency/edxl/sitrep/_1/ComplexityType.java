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
import javax.xml.bind.annotation.XmlType;
import oasis.names.tc.emergency.edxl.ct._1.ComplexityDefaultType;
import oasis.names.tc.emergency.edxl.ct._1.ValueListType;


/**
 * <p>Java class for ComplexityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComplexityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Complexity" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}ValueListType"/>
 *         &lt;element name="ComplexityDefault" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}ComplexityDefaultType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComplexityType", propOrder = {
    "complexity",
    "complexityDefault"
})
public class ComplexityType {

    @XmlElement(name = "Complexity")
    protected ValueListType complexity;
    @XmlElement(name = "ComplexityDefault")
    protected ComplexityDefaultType complexityDefault;

    /**
     * Gets the value of the complexity property.
     * 
     * @return
     *     possible object is
     *     {@link ValueListType }
     *     
     */
    public ValueListType getComplexity() {
        return complexity;
    }

    /**
     * Sets the value of the complexity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueListType }
     *     
     */
    public void setComplexity(ValueListType value) {
        this.complexity = value;
    }

    /**
     * Gets the value of the complexityDefault property.
     * 
     * @return
     *     possible object is
     *     {@link ComplexityDefaultType }
     *     
     */
    public ComplexityDefaultType getComplexityDefault() {
        return complexityDefault;
    }

    /**
     * Sets the value of the complexityDefault property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComplexityDefaultType }
     *     
     */
    public void setComplexityDefault(ComplexityDefaultType value) {
        this.complexityDefault = value;
    }

}
