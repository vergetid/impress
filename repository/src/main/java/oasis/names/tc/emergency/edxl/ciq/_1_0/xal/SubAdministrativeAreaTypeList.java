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
 * <p>Java class for SubAdministrativeAreaTypeList.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SubAdministrativeAreaTypeList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="County"/>
 *     &lt;enumeration value="District"/>
 *     &lt;enumeration value="Province"/>
 *     &lt;enumeration value="Region"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SubAdministrativeAreaTypeList")
@XmlEnum
public enum SubAdministrativeAreaTypeList {

    @XmlEnumValue("County")
    COUNTY("County"),
    @XmlEnumValue("District")
    DISTRICT("District"),
    @XmlEnumValue("Province")
    PROVINCE("Province"),
    @XmlEnumValue("Region")
    REGION("Region");
    private final String value;

    SubAdministrativeAreaTypeList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SubAdministrativeAreaTypeList fromValue(String v) {
        for (SubAdministrativeAreaTypeList c: SubAdministrativeAreaTypeList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}