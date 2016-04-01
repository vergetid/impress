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
 * <p>Java class for CountryNameTypeList.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CountryNameTypeList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="Name"/>
 *     &lt;enumeration value="Type"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CountryNameTypeList", namespace = "urn:oasis:names:tc:emergency:edxl:ciq:1.0:xal")
@XmlEnum
public enum CountryNameTypeList {


    /**
     * 
     *                         Name of the country  e.g. AUSTRALIA
     *                     
     * 
     */
    @XmlEnumValue("Name")
    NAME("Name"),

    /**
     * 
     *                         Although a Country, could be classified as a territory of a country.
     *                         For example, "NOUVELLE CALEDONIE" is a territory of "FRANCE".
     *                     
     * 
     */
    @XmlEnumValue("Type")
    TYPE("Type");
    private final String value;

    CountryNameTypeList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CountryNameTypeList fromValue(String v) {
        for (CountryNameTypeList c: CountryNameTypeList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
