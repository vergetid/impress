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
 * <p>Java class for FeatureTypeList.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FeatureTypeList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="Weight"/>
 *     &lt;enumeration value="Height"/>
 *     &lt;enumeration value="HairColour"/>
 *     &lt;enumeration value="EyeColour"/>
 *     &lt;enumeration value="SkinColour"/>
 *     &lt;enumeration value="Waist"/>
 *     &lt;enumeration value="Breast"/>
 *     &lt;enumeration value="Hip"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FeatureTypeList", namespace = "urn:oasis:names:tc:emergency:edxl:ciq:1.0:xpil")
@XmlEnum
public enum FeatureTypeList {

    @XmlEnumValue("Weight")
    WEIGHT("Weight"),
    @XmlEnumValue("Height")
    HEIGHT("Height"),
    @XmlEnumValue("HairColour")
    HAIR_COLOUR("HairColour"),
    @XmlEnumValue("EyeColour")
    EYE_COLOUR("EyeColour"),
    @XmlEnumValue("SkinColour")
    SKIN_COLOUR("SkinColour"),
    @XmlEnumValue("Waist")
    WAIST("Waist"),
    @XmlEnumValue("Breast")
    BREAST("Breast"),
    @XmlEnumValue("Hip")
    HIP("Hip");
    private final String value;

    FeatureTypeList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FeatureTypeList fromValue(String v) {
        for (FeatureTypeList c: FeatureTypeList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
