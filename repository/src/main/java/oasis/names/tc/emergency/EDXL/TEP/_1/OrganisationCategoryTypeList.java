//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.01 at 06:03:54 PM EEST 
//


package oasis.names.tc.emergency.EDXL.TEP._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrganisationCategoryTypeList.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OrganisationCategoryTypeList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="Vendor"/>
 *     &lt;enumeration value="GovernmentAgency"/>
 *     &lt;enumeration value="University"/>
 *     &lt;enumeration value="College"/>
 *     &lt;enumeration value="School"/>
 *     &lt;enumeration value="Club"/>
 *     &lt;enumeration value="Association"/>
 *     &lt;enumeration value="Consortium"/>
 *     &lt;enumeration value="Company"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OrganisationCategoryTypeList", namespace = "urn:oasis:names:tc:emergency:edxl:ciq:1.0:xpil")
@XmlEnum
public enum OrganisationCategoryTypeList {

    @XmlEnumValue("Vendor")
    VENDOR("Vendor"),
    @XmlEnumValue("GovernmentAgency")
    GOVERNMENT_AGENCY("GovernmentAgency"),
    @XmlEnumValue("University")
    UNIVERSITY("University"),
    @XmlEnumValue("College")
    COLLEGE("College"),
    @XmlEnumValue("School")
    SCHOOL("School"),
    @XmlEnumValue("Club")
    CLUB("Club"),
    @XmlEnumValue("Association")
    ASSOCIATION("Association"),
    @XmlEnumValue("Consortium")
    CONSORTIUM("Consortium"),
    @XmlEnumValue("Company")
    COMPANY("Company");
    private final String value;

    OrganisationCategoryTypeList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OrganisationCategoryTypeList fromValue(String v) {
        for (OrganisationCategoryTypeList c: OrganisationCategoryTypeList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
