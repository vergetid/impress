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
 * <p>Java class for AdministrativeAreaTypeList.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdministrativeAreaTypeList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="City"/>
 *     &lt;enumeration value="State"/>
 *     &lt;enumeration value="Territory"/>
 *     &lt;enumeration value="Province"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AdministrativeAreaTypeList")
@XmlEnum
public enum AdministrativeAreaTypeList {


    /**
     * 
     *                         Only name of the administrative area without its type, e.g. NSW, CA, Quebec
     *                     
     * 
     */
    @XmlEnumValue("City")
    CITY("City"),

    /**
     * 
     *                         The type of the area, e.g. state, district, province, etc.
     *                     
     * 
     */
    @XmlEnumValue("State")
    STATE("State"),
    @XmlEnumValue("Territory")
    TERRITORY("Territory"),
    @XmlEnumValue("Province")
    PROVINCE("Province");
    private final String value;

    AdministrativeAreaTypeList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AdministrativeAreaTypeList fromValue(String v) {
        for (AdministrativeAreaTypeList c: AdministrativeAreaTypeList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
