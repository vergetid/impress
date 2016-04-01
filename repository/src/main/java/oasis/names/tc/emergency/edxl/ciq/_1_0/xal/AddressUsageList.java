//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.01 at 06:02:17 PM EEST 
//


package oasis.names.tc.emergency.edxl.ciq._1_0.xal;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddressUsageList.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AddressUsageList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="Business"/>
 *     &lt;enumeration value="Billing"/>
 *     &lt;enumeration value="Communication"/>
 *     &lt;enumeration value="Contact"/>
 *     &lt;enumeration value="Mailing"/>
 *     &lt;enumeration value="Personal"/>
 *     &lt;enumeration value="Postal"/>
 *     &lt;enumeration value="Residential"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AddressUsageList")
@XmlEnum
public enum AddressUsageList {

    @XmlEnumValue("Business")
    BUSINESS("Business"),
    @XmlEnumValue("Billing")
    BILLING("Billing"),
    @XmlEnumValue("Communication")
    COMMUNICATION("Communication"),
    @XmlEnumValue("Contact")
    CONTACT("Contact"),
    @XmlEnumValue("Mailing")
    MAILING("Mailing"),
    @XmlEnumValue("Personal")
    PERSONAL("Personal"),
    @XmlEnumValue("Postal")
    POSTAL("Postal"),
    @XmlEnumValue("Residential")
    RESIDENTIAL("Residential");
    private final String value;

    AddressUsageList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AddressUsageList fromValue(String v) {
        for (AddressUsageList c: AddressUsageList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}