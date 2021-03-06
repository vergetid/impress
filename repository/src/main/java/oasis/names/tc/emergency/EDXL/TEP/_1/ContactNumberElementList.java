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
 * <p>Java class for ContactNumberElementList.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ContactNumberElementList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="CountryCode"/>
 *     &lt;enumeration value="AreaCode"/>
 *     &lt;enumeration value="LocalNumber"/>
 *     &lt;enumeration value="Extension"/>
 *     &lt;enumeration value="Pin"/>
 *     &lt;enumeration value="Separator"/>
 *     &lt;enumeration value="NationalNumber"/>
 *     &lt;enumeration value="InternationalNumber"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ContactNumberElementList", namespace = "urn:oasis:names:tc:emergency:edxl:ciq:1.0:xpil")
@XmlEnum
public enum ContactNumberElementList {


    /**
     * 
     *                         Code to dial to a country. E.g. 1 for US, 44 for UK
     *                     
     * 
     */
    @XmlEnumValue("CountryCode")
    COUNTRY_CODE("CountryCode"),

    /**
     * 
     *                         Code to dial an area within a country. For example:
     *                         "02" for Sydney, "03" for Melbourne
     *                     
     * 
     */
    @XmlEnumValue("AreaCode")
    AREA_CODE("AreaCode"),

    /**
     * 
     *                         Local number as would be used by others within the same dialing area.
     *                     
     * 
     */
    @XmlEnumValue("LocalNumber")
    LOCAL_NUMBER("LocalNumber"),

    /**
     * 
     *                         An extension to the number that is usually handled by some PABX
     *                     
     * 
     */
    @XmlEnumValue("Extension")
    EXTENSION("Extension"),

    /**
     * 
     *                         E.g. special access code
     *                     
     * 
     */
    @XmlEnumValue("Pin")
    PIN("Pin"),

    /**
     * 
     *                         Any text that is not part of the phone number, but has some
     *                         informational content, e.g. Ext.
     *                     
     * 
     */
    @XmlEnumValue("Separator")
    SEPARATOR("Separator"),

    /**
     * 
     *                         Area code with local number if one line. May include national access numbers.
     *                     
     * 
     */
    @XmlEnumValue("NationalNumber")
    NATIONAL_NUMBER("NationalNumber"),

    /**
     * 
     *                         Full international number in one line. May include international access numbers.
     *                     
     * 
     */
    @XmlEnumValue("InternationalNumber")
    INTERNATIONAL_NUMBER("InternationalNumber");
    private final String value;

    ContactNumberElementList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ContactNumberElementList fromValue(String v) {
        for (ContactNumberElementList c: ContactNumberElementList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
