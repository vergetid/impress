//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.01 at 06:03:54 PM EEST 
//


package oasis.names.tc.emergency.EDXL.TEP._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Group of elements used for identifying and describing a certified care provider (typically  Emergency Medical Services personnel).
 * 
 * <p>Java class for HealthCareProviderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HealthCareProviderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="providerNumber" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}ValueKeyType"/>
 *         &lt;element name="providerName" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}EDXLStringType"/>
 *         &lt;element name="providerJurisdiction" type="{urn:oasis:names:tc:emergency:edxl:ciq:1.0:xal}AddressType"/>
 *         &lt;element name="providerCountry" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}ValueKeyType"/>
 *         &lt;element name="providerKind" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}ValueListType"/>
 *         &lt;element name="providerDomainName" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}EDXLStringType" minOccurs="0"/>
 *         &lt;element name="personnelIDNumber" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}EDXLStringType" minOccurs="0"/>
 *         &lt;element name="personnelJurisdiction" type="{urn:oasis:names:tc:emergency:edxl:ciq:1.0:xal}AddressType" minOccurs="0"/>
 *         &lt;element name="personnelCertificationLevel" type="{urn:oasis:names:tc:emergency:edxl:ct:1.0}ValueListType" minOccurs="0"/>
 *         &lt;element name="transport" type="{urn:oasis:names:tc:emergency:EDXL:TEP:1.0}TransportType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HealthCareProviderType", namespace = "urn:oasis:names:tc:emergency:EDXL:TEP:1.0", propOrder = {
    "providerNumber",
    "providerName",
    "providerJurisdiction",
    "providerCountry",
    "providerKind",
    "providerDomainName",
    "personnelIDNumber",
    "personnelJurisdiction",
    "personnelCertificationLevel",
    "transport"
})
public class HealthCareProviderType {

    @XmlElement(required = true)
    protected ValueKeyType providerNumber;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String providerName;
    @XmlElement(required = true)
    protected AddressType providerJurisdiction;
    @XmlElement(required = true)
    protected ValueKeyType providerCountry;
    @XmlElement(required = true)
    protected ValueListType providerKind;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String providerDomainName;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String personnelIDNumber;
    protected AddressType personnelJurisdiction;
    protected ValueListType personnelCertificationLevel;
    protected TransportType transport;

    /**
     * Gets the value of the providerNumber property.
     * 
     * @return
     *     possible object is
     *     {@link ValueKeyType }
     *     
     */
    public ValueKeyType getProviderNumber() {
        return providerNumber;
    }

    /**
     * Sets the value of the providerNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueKeyType }
     *     
     */
    public void setProviderNumber(ValueKeyType value) {
        this.providerNumber = value;
    }

    /**
     * Gets the value of the providerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Sets the value of the providerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProviderName(String value) {
        this.providerName = value;
    }

    /**
     * Gets the value of the providerJurisdiction property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getProviderJurisdiction() {
        return providerJurisdiction;
    }

    /**
     * Sets the value of the providerJurisdiction property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setProviderJurisdiction(AddressType value) {
        this.providerJurisdiction = value;
    }

    /**
     * Gets the value of the providerCountry property.
     * 
     * @return
     *     possible object is
     *     {@link ValueKeyType }
     *     
     */
    public ValueKeyType getProviderCountry() {
        return providerCountry;
    }

    /**
     * Sets the value of the providerCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueKeyType }
     *     
     */
    public void setProviderCountry(ValueKeyType value) {
        this.providerCountry = value;
    }

    /**
     * Gets the value of the providerKind property.
     * 
     * @return
     *     possible object is
     *     {@link ValueListType }
     *     
     */
    public ValueListType getProviderKind() {
        return providerKind;
    }

    /**
     * Sets the value of the providerKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueListType }
     *     
     */
    public void setProviderKind(ValueListType value) {
        this.providerKind = value;
    }

    /**
     * Gets the value of the providerDomainName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProviderDomainName() {
        return providerDomainName;
    }

    /**
     * Sets the value of the providerDomainName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProviderDomainName(String value) {
        this.providerDomainName = value;
    }

    /**
     * Gets the value of the personnelIDNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonnelIDNumber() {
        return personnelIDNumber;
    }

    /**
     * Sets the value of the personnelIDNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonnelIDNumber(String value) {
        this.personnelIDNumber = value;
    }

    /**
     * Gets the value of the personnelJurisdiction property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getPersonnelJurisdiction() {
        return personnelJurisdiction;
    }

    /**
     * Sets the value of the personnelJurisdiction property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setPersonnelJurisdiction(AddressType value) {
        this.personnelJurisdiction = value;
    }

    /**
     * Gets the value of the personnelCertificationLevel property.
     * 
     * @return
     *     possible object is
     *     {@link ValueListType }
     *     
     */
    public ValueListType getPersonnelCertificationLevel() {
        return personnelCertificationLevel;
    }

    /**
     * Sets the value of the personnelCertificationLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueListType }
     *     
     */
    public void setPersonnelCertificationLevel(ValueListType value) {
        this.personnelCertificationLevel = value;
    }

    /**
     * Gets the value of the transport property.
     * 
     * @return
     *     possible object is
     *     {@link TransportType }
     *     
     */
    public TransportType getTransport() {
        return transport;
    }

    /**
     * Sets the value of the transport property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportType }
     *     
     */
    public void setTransport(TransportType value) {
        this.transport = value;
    }

}
