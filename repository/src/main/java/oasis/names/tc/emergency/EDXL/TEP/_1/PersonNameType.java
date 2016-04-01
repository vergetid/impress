//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.01 at 06:03:54 PM EEST 
//


package oasis.names.tc.emergency.EDXL.TEP._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 *                 Reusable complex type
 *             
 * 
 * <p>Java class for PersonNameType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonNameType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NameElement" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;urn:oasis:names:tc:emergency:edxl:ciq:1.0:ct>String">
 *                 &lt;attribute name="ElementType" type="{urn:oasis:names:tc:emergency:edxl:ciq:1.0:xnl}PersonNameElementList" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonNameType", namespace = "urn:oasis:names:tc:emergency:edxl:ciq:1.0:xnl", propOrder = {
    "nameElement"
})
@XmlSeeAlso({
    oasis.names.tc.emergency.EDXL.TEP._1.PartyNameType.PersonName.class
})
public class PersonNameType {

    @XmlElement(name = "NameElement")
    protected List<PersonNameType.NameElement> nameElement;

    /**
     * Gets the value of the nameElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nameElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNameElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonNameType.NameElement }
     * 
     * 
     */
    public List<PersonNameType.NameElement> getNameElement() {
        if (nameElement == null) {
            nameElement = new ArrayList<PersonNameType.NameElement>();
        }
        return this.nameElement;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;urn:oasis:names:tc:emergency:edxl:ciq:1.0:ct>String">
     *       &lt;attribute name="ElementType" type="{urn:oasis:names:tc:emergency:edxl:ciq:1.0:xnl}PersonNameElementList" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class NameElement {

        @XmlValue
        @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
        protected String value;
        @XmlAttribute(name = "ElementType", namespace = "urn:oasis:names:tc:emergency:edxl:ciq:1.0:xnl")
        protected PersonNameElementList elementType;

        /**
         * 
         *                 Normalized and Collapsed String
         *             
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

        /**
         * Gets the value of the elementType property.
         * 
         * @return
         *     possible object is
         *     {@link PersonNameElementList }
         *     
         */
        public PersonNameElementList getElementType() {
            return elementType;
        }

        /**
         * Sets the value of the elementType property.
         * 
         * @param value
         *     allowed object is
         *     {@link PersonNameElementList }
         *     
         */
        public void setElementType(PersonNameElementList value) {
            this.elementType = value;
        }

    }

}
