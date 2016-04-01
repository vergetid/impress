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
 * <p>Java class for BirthInfoElementList.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BirthInfoElementList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="BirthStar"/>
 *     &lt;enumeration value="BirthPlace"/>
 *     &lt;enumeration value="BirthSign"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BirthInfoElementList", namespace = "urn:oasis:names:tc:emergency:edxl:ciq:1.0:xpil")
@XmlEnum
public enum BirthInfoElementList {


    /**
     * 
     *                         Commonly used in some oriental cultures
     *                     
     * 
     */
    @XmlEnumValue("BirthStar")
    BIRTH_STAR("BirthStar"),

    /**
     * 
     *                         A free text descriprion of the birth place, e.g. country name, region, etc.
     *                     
     * 
     */
    @XmlEnumValue("BirthPlace")
    BIRTH_PLACE("BirthPlace"),

    /**
     * 
     *                         Specific to some cultures
     *                     
     * 
     */
    @XmlEnumValue("BirthSign")
    BIRTH_SIGN("BirthSign");
    private final String value;

    BirthInfoElementList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BirthInfoElementList fromValue(String v) {
        for (BirthInfoElementList c: BirthInfoElementList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
