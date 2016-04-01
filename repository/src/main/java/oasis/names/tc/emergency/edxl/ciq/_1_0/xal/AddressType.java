//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.01 at 06:02:17 PM EEST 
//


package oasis.names.tc.emergency.edxl.ciq._1_0.xal;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 *                 Complex type that defines the structure of an address with geocode details for reuse
 *             
 * 
 * <p>Java class for AddressType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddressType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FreeTextAddress" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="AddressLine" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;urn:oasis:names:tc:emergency:edxl:ciq:1.0:ct>String">
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Country" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{urn:oasis:names:tc:emergency:edxl:ciq:1.0:xal}CountryType">
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AdministrativeArea" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NameElement" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;urn:oasis:names:tc:emergency:edxl:ciq:1.0:ct>String">
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="SubAdministrativeArea" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="NameElement" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;urn:oasis:names:tc:emergency:edxl:ciq:1.0:ct>String">
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Locality" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NameElement" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;urn:oasis:names:tc:emergency:edxl:ciq:1.0:ct>String">
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="SubLocality" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="NameElement" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;urn:oasis:names:tc:emergency:edxl:ciq:1.0:ct>String">
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Thoroughfare" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{urn:oasis:names:tc:emergency:edxl:ciq:1.0:xal}ThoroughfareType">
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PostCode" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Identifier" type="{urn:oasis:names:tc:emergency:edxl:ciq:1.0:xal}IdentifierType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
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
@XmlType(name = "AddressType", propOrder = {
    "freeTextAddress",
    "country",
    "administrativeArea",
    "locality",
    "thoroughfare",
    "postCode"
})
@XmlSeeAlso({
    oasis.names.tc.emergency.edxl.ciq._1_0.xpil.Addresses.Address.class
})
public class AddressType {

    @XmlElement(name = "FreeTextAddress")
    protected AddressType.FreeTextAddress freeTextAddress;
    @XmlElement(name = "Country")
    protected AddressType.Country country;
    @XmlElement(name = "AdministrativeArea")
    protected AddressType.AdministrativeArea administrativeArea;
    @XmlElement(name = "Locality")
    protected AddressType.Locality locality;
    @XmlElement(name = "Thoroughfare")
    protected AddressType.Thoroughfare thoroughfare;
    @XmlElement(name = "PostCode")
    protected AddressType.PostCode postCode;

    /**
     * Gets the value of the freeTextAddress property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType.FreeTextAddress }
     *     
     */
    public AddressType.FreeTextAddress getFreeTextAddress() {
        return freeTextAddress;
    }

    /**
     * Sets the value of the freeTextAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType.FreeTextAddress }
     *     
     */
    public void setFreeTextAddress(AddressType.FreeTextAddress value) {
        this.freeTextAddress = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType.Country }
     *     
     */
    public AddressType.Country getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType.Country }
     *     
     */
    public void setCountry(AddressType.Country value) {
        this.country = value;
    }

    /**
     * Gets the value of the administrativeArea property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType.AdministrativeArea }
     *     
     */
    public AddressType.AdministrativeArea getAdministrativeArea() {
        return administrativeArea;
    }

    /**
     * Sets the value of the administrativeArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType.AdministrativeArea }
     *     
     */
    public void setAdministrativeArea(AddressType.AdministrativeArea value) {
        this.administrativeArea = value;
    }

    /**
     * Gets the value of the locality property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType.Locality }
     *     
     */
    public AddressType.Locality getLocality() {
        return locality;
    }

    /**
     * Sets the value of the locality property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType.Locality }
     *     
     */
    public void setLocality(AddressType.Locality value) {
        this.locality = value;
    }

    /**
     * Gets the value of the thoroughfare property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType.Thoroughfare }
     *     
     */
    public AddressType.Thoroughfare getThoroughfare() {
        return thoroughfare;
    }

    /**
     * Sets the value of the thoroughfare property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType.Thoroughfare }
     *     
     */
    public void setThoroughfare(AddressType.Thoroughfare value) {
        this.thoroughfare = value;
    }

    /**
     * Gets the value of the postCode property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType.PostCode }
     *     
     */
    public AddressType.PostCode getPostCode() {
        return postCode;
    }

    /**
     * Sets the value of the postCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType.PostCode }
     *     
     */
    public void setPostCode(AddressType.PostCode value) {
        this.postCode = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="NameElement" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;urn:oasis:names:tc:emergency:edxl:ciq:1.0:ct>String">
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="SubAdministrativeArea" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="NameElement" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;urn:oasis:names:tc:emergency:edxl:ciq:1.0:ct>String">
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
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
    @XmlType(name = "", propOrder = {
        "nameElement",
        "subAdministrativeArea"
    })
    public static class AdministrativeArea {

        @XmlElement(name = "NameElement", required = true)
        protected List<AddressType.AdministrativeArea.NameElement> nameElement;
        @XmlElement(name = "SubAdministrativeArea")
        protected AddressType.AdministrativeArea.SubAdministrativeArea subAdministrativeArea;

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
         * {@link AddressType.AdministrativeArea.NameElement }
         * 
         * 
         */
        public List<AddressType.AdministrativeArea.NameElement> getNameElement() {
            if (nameElement == null) {
                nameElement = new ArrayList<AddressType.AdministrativeArea.NameElement>();
            }
            return this.nameElement;
        }

        /**
         * Gets the value of the subAdministrativeArea property.
         * 
         * @return
         *     possible object is
         *     {@link AddressType.AdministrativeArea.SubAdministrativeArea }
         *     
         */
        public AddressType.AdministrativeArea.SubAdministrativeArea getSubAdministrativeArea() {
            return subAdministrativeArea;
        }

        /**
         * Sets the value of the subAdministrativeArea property.
         * 
         * @param value
         *     allowed object is
         *     {@link AddressType.AdministrativeArea.SubAdministrativeArea }
         *     
         */
        public void setSubAdministrativeArea(AddressType.AdministrativeArea.SubAdministrativeArea value) {
            this.subAdministrativeArea = value;
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
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="NameElement" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;urn:oasis:names:tc:emergency:edxl:ciq:1.0:ct>String">
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
        @XmlType(name = "", propOrder = {
            "nameElement"
        })
        public static class SubAdministrativeArea {

            @XmlElement(name = "NameElement", required = true)
            protected List<AddressType.AdministrativeArea.SubAdministrativeArea.NameElement> nameElement;

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
             * {@link AddressType.AdministrativeArea.SubAdministrativeArea.NameElement }
             * 
             * 
             */
            public List<AddressType.AdministrativeArea.SubAdministrativeArea.NameElement> getNameElement() {
                if (nameElement == null) {
                    nameElement = new ArrayList<AddressType.AdministrativeArea.SubAdministrativeArea.NameElement>();
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

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{urn:oasis:names:tc:emergency:edxl:ciq:1.0:xal}CountryType">
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Country
        extends CountryType
    {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="AddressLine" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;urn:oasis:names:tc:emergency:edxl:ciq:1.0:ct>String">
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
    @XmlType(name = "", propOrder = {
        "addressLine"
    })
    public static class FreeTextAddress {

        @XmlElement(name = "AddressLine", required = true)
        protected List<AddressType.FreeTextAddress.AddressLine> addressLine;

        /**
         * Gets the value of the addressLine property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the addressLine property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAddressLine().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AddressType.FreeTextAddress.AddressLine }
         * 
         * 
         */
        public List<AddressType.FreeTextAddress.AddressLine> getAddressLine() {
            if (addressLine == null) {
                addressLine = new ArrayList<AddressType.FreeTextAddress.AddressLine>();
            }
            return this.addressLine;
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
        public static class AddressLine {

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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="NameElement" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;urn:oasis:names:tc:emergency:edxl:ciq:1.0:ct>String">
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="SubLocality" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="NameElement" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;urn:oasis:names:tc:emergency:edxl:ciq:1.0:ct>String">
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
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
    @XmlType(name = "", propOrder = {
        "nameElement",
        "subLocality"
    })
    public static class Locality {

        @XmlElement(name = "NameElement", required = true)
        protected List<AddressType.Locality.NameElement> nameElement;
        @XmlElement(name = "SubLocality")
        protected AddressType.Locality.SubLocality subLocality;

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
         * {@link AddressType.Locality.NameElement }
         * 
         * 
         */
        public List<AddressType.Locality.NameElement> getNameElement() {
            if (nameElement == null) {
                nameElement = new ArrayList<AddressType.Locality.NameElement>();
            }
            return this.nameElement;
        }

        /**
         * Gets the value of the subLocality property.
         * 
         * @return
         *     possible object is
         *     {@link AddressType.Locality.SubLocality }
         *     
         */
        public AddressType.Locality.SubLocality getSubLocality() {
            return subLocality;
        }

        /**
         * Sets the value of the subLocality property.
         * 
         * @param value
         *     allowed object is
         *     {@link AddressType.Locality.SubLocality }
         *     
         */
        public void setSubLocality(AddressType.Locality.SubLocality value) {
            this.subLocality = value;
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
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="NameElement" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;urn:oasis:names:tc:emergency:edxl:ciq:1.0:ct>String">
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
        @XmlType(name = "", propOrder = {
            "nameElement"
        })
        public static class SubLocality {

            @XmlElement(name = "NameElement", required = true)
            protected List<AddressType.Locality.SubLocality.NameElement> nameElement;

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
             * {@link AddressType.Locality.SubLocality.NameElement }
             * 
             * 
             */
            public List<AddressType.Locality.SubLocality.NameElement> getNameElement() {
                if (nameElement == null) {
                    nameElement = new ArrayList<AddressType.Locality.SubLocality.NameElement>();
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

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Identifier" type="{urn:oasis:names:tc:emergency:edxl:ciq:1.0:xal}IdentifierType" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "identifier"
    })
    public static class PostCode {

        @XmlElement(name = "Identifier", required = true)
        protected List<IdentifierType> identifier;

        /**
         * Gets the value of the identifier property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the identifier property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIdentifier().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link IdentifierType }
         * 
         * 
         */
        public List<IdentifierType> getIdentifier() {
            if (identifier == null) {
                identifier = new ArrayList<IdentifierType>();
            }
            return this.identifier;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{urn:oasis:names:tc:emergency:edxl:ciq:1.0:xal}ThoroughfareType">
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Thoroughfare
        extends ThoroughfareType
    {


    }

}