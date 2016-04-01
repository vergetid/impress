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
 * <p>Java class for PremisesTypeList.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PremisesTypeList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="Airport"/>
 *     &lt;enumeration value="Area"/>
 *     &lt;enumeration value="Building"/>
 *     &lt;enumeration value="Farm"/>
 *     &lt;enumeration value="Hospital"/>
 *     &lt;enumeration value="House"/>
 *     &lt;enumeration value="LandMark"/>
 *     &lt;enumeration value="LargeMailUser"/>
 *     &lt;enumeration value="Lot"/>
 *     &lt;enumeration value="RailwayStation"/>
 *     &lt;enumeration value="ShoppingComplex"/>
 *     &lt;enumeration value="University"/>
 *     &lt;enumeration value="Unit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PremisesTypeList", namespace = "urn:oasis:names:tc:emergency:edxl:ciq:1.0:xal")
@XmlEnum
public enum PremisesTypeList {

    @XmlEnumValue("Airport")
    AIRPORT("Airport"),
    @XmlEnumValue("Area")
    AREA("Area"),
    @XmlEnumValue("Building")
    BUILDING("Building"),
    @XmlEnumValue("Farm")
    FARM("Farm"),
    @XmlEnumValue("Hospital")
    HOSPITAL("Hospital"),
    @XmlEnumValue("House")
    HOUSE("House"),
    @XmlEnumValue("LandMark")
    LAND_MARK("LandMark"),
    @XmlEnumValue("LargeMailUser")
    LARGE_MAIL_USER("LargeMailUser"),
    @XmlEnumValue("Lot")
    LOT("Lot"),
    @XmlEnumValue("RailwayStation")
    RAILWAY_STATION("RailwayStation"),
    @XmlEnumValue("ShoppingComplex")
    SHOPPING_COMPLEX("ShoppingComplex"),
    @XmlEnumValue("University")
    UNIVERSITY("University"),
    @XmlEnumValue("Unit")
    UNIT("Unit");
    private final String value;

    PremisesTypeList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PremisesTypeList fromValue(String v) {
        for (PremisesTypeList c: PremisesTypeList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
