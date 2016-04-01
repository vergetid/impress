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
 * <p>Java class for SkyConditionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SkyConditionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Sky Clear"/>
 *     &lt;enumeration value="Few"/>
 *     &lt;enumeration value="Scattered"/>
 *     &lt;enumeration value="Broken"/>
 *     &lt;enumeration value="Overcast"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SkyConditionType", namespace = "urn:oasis:names:tc:emergency:edxl:ct:1.0")
@XmlEnum
public enum SkyConditionType {

    @XmlEnumValue("Sky Clear")
    SKY_CLEAR("Sky Clear"),
    @XmlEnumValue("Few")
    FEW("Few"),
    @XmlEnumValue("Scattered")
    SCATTERED("Scattered"),
    @XmlEnumValue("Broken")
    BROKEN("Broken"),
    @XmlEnumValue("Overcast")
    OVERCAST("Overcast");
    private final String value;

    SkyConditionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SkyConditionType fromValue(String v) {
        for (SkyConditionType c: SkyConditionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}