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
 * <p>Java class for OrganisationNameType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganisationNameType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NameElement" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;urn:oasis:names:tc:emergency:edxl:ciq:1.0:ct>String">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SubDivisionName" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;urn:oasis:names:tc:emergency:edxl:ciq:1.0:ct>String">
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="OrganisationID" type="{urn:oasis:names:tc:emergency:edxl:ciq:1.0:ct}String" />
 *       &lt;attribute name="OrganisationIDType" type="{urn:oasis:names:tc:emergency:edxl:ciq:1.0:xnl}OrganisationIDTypeList" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganisationNameType", namespace = "urn:oasis:names:tc:emergency:edxl:ciq:1.0:xnl", propOrder = {
    "nameElement",
    "subDivisionName"
})
@XmlSeeAlso({
    oasis.names.tc.emergency.EDXL.TEP._1.PartyNameType.OrganisationName.class
})
public class OrganisationNameType {

    @XmlElement(name = "NameElement")
    protected List<OrganisationNameType.NameElement> nameElement;
    @XmlElement(name = "SubDivisionName")
    protected List<OrganisationNameType.SubDivisionName> subDivisionName;
    @XmlAttribute(name = "OrganisationID", namespace = "urn:oasis:names:tc:emergency:edxl:ciq:1.0:xnl")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String organisationID;
    @XmlAttribute(name = "OrganisationIDType", namespace = "urn:oasis:names:tc:emergency:edxl:ciq:1.0:xnl")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String organisationIDType;

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
     * {@link OrganisationNameType.NameElement }
     * 
     * 
     */
    public List<OrganisationNameType.NameElement> getNameElement() {
        if (nameElement == null) {
            nameElement = new ArrayList<OrganisationNameType.NameElement>();
        }
        return this.nameElement;
    }

    /**
     * Gets the value of the subDivisionName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subDivisionName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubDivisionName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrganisationNameType.SubDivisionName }
     * 
     * 
     */
    public List<OrganisationNameType.SubDivisionName> getSubDivisionName() {
        if (subDivisionName == null) {
            subDivisionName = new ArrayList<OrganisationNameType.SubDivisionName>();
        }
        return this.subDivisionName;
    }

    /**
     * Gets the value of the organisationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganisationID() {
        return organisationID;
    }

    /**
     * Sets the value of the organisationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganisationID(String value) {
        this.organisationID = value;
    }

    /**
     * Gets the value of the organisationIDType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganisationIDType() {
        return organisationIDType;
    }

    /**
     * Sets the value of the organisationIDType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganisationIDType(String value) {
        this.organisationIDType = value;
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
    public static class SubDivisionName {

        @XmlValue
        @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
        protected String value;

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

    }

}
