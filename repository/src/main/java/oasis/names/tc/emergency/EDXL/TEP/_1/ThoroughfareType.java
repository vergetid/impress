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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 *                 Complex type for internal reuse
 *             
 * 
 * <p>Java class for ThoroughfareType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ThoroughfareType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="NameElement">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;urn:oasis:names:tc:emergency:edxl:ciq:1.0:ct>String">
 *                 &lt;attGroup ref="{urn:oasis:names:tc:emergency:edxl:ciq:1.0:ct}grAbbreviation"/>
 *                 &lt;attribute name="NameType" type="{urn:oasis:names:tc:emergency:edxl:ciq:1.0:xal}ThoroughfareNameTypeList" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Number" type="{urn:oasis:names:tc:emergency:edxl:ciq:1.0:xal}IdentifierType"/>
 *       &lt;/choice>
 *       &lt;attribute name="Type" type="{urn:oasis:names:tc:emergency:edxl:ciq:1.0:xal}ThoroughfareTypeList" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ThoroughfareType", namespace = "urn:oasis:names:tc:emergency:edxl:ciq:1.0:xal", propOrder = {
    "nameElementOrNumber"
})
@XmlSeeAlso({
    oasis.names.tc.emergency.EDXL.TEP._1.AddressType.Thoroughfare.class
})
public class ThoroughfareType {

    @XmlElements({
        @XmlElement(name = "NameElement", type = ThoroughfareType.NameElement.class),
        @XmlElement(name = "Number", type = IdentifierType.class)
    })
    protected List<Object> nameElementOrNumber;
    @XmlAttribute(name = "Type", namespace = "urn:oasis:names:tc:emergency:edxl:ciq:1.0:xal")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String type;

    /**
     * Gets the value of the nameElementOrNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nameElementOrNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNameElementOrNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ThoroughfareType.NameElement }
     * {@link IdentifierType }
     * 
     * 
     */
    public List<Object> getNameElementOrNumber() {
        if (nameElementOrNumber == null) {
            nameElementOrNumber = new ArrayList<Object>();
        }
        return this.nameElementOrNumber;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
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
     *       &lt;attGroup ref="{urn:oasis:names:tc:emergency:edxl:ciq:1.0:ct}grAbbreviation"/>
     *       &lt;attribute name="NameType" type="{urn:oasis:names:tc:emergency:edxl:ciq:1.0:xal}ThoroughfareNameTypeList" />
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
        @XmlAttribute(name = "NameType", namespace = "urn:oasis:names:tc:emergency:edxl:ciq:1.0:xal")
        protected ThoroughfareNameTypeList nameType;
        @XmlAttribute(name = "Abbreviation", namespace = "urn:oasis:names:tc:emergency:edxl:ciq:1.0:ct")
        protected Boolean abbreviation;

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
         * Gets the value of the nameType property.
         * 
         * @return
         *     possible object is
         *     {@link ThoroughfareNameTypeList }
         *     
         */
        public ThoroughfareNameTypeList getNameType() {
            return nameType;
        }

        /**
         * Sets the value of the nameType property.
         * 
         * @param value
         *     allowed object is
         *     {@link ThoroughfareNameTypeList }
         *     
         */
        public void setNameType(ThoroughfareNameTypeList value) {
            this.nameType = value;
        }

        /**
         * Gets the value of the abbreviation property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isAbbreviation() {
            return abbreviation;
        }

        /**
         * Sets the value of the abbreviation property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setAbbreviation(Boolean value) {
            this.abbreviation = value;
        }

    }

}
