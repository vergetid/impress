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
 * <p>Java class for OrganisationNameElementList.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OrganisationNameElementList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="NameOnly"/>
 *     &lt;enumeration value="TypeOnly"/>
 *     &lt;enumeration value="FullName"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OrganisationNameElementList", namespace = "urn:oasis:names:tc:emergency:edxl:ciq:1.0:xnl")
@XmlEnum
public enum OrganisationNameElementList {


    /**
     * 
     *                         "Sakthisoft" in "Sakthisoft Pty. Ltd". "Pty.Ltd" is the legal
     *                         entity for the organisation name "Sakthisoft"
     *                     
     * 
     */
    @XmlEnumValue("NameOnly")
    NAME_ONLY("NameOnly"),

    /**
     * 
     *                         "Pty. Ltd" in Sakthisoft Pty.Ltd, where "Sakthisoft" is the name
     *                         of the organisation. "Inc" in ABC Inc, where "ABC" is organisation name
     *                     
     * 
     */
    @XmlEnumValue("TypeOnly")
    TYPE_ONLY("TypeOnly"),

    /**
     * 
     *                         Full Name of the organisation. e.g. Sakthisoft Pty. Ltd
     *                     
     * 
     */
    @XmlEnumValue("FullName")
    FULL_NAME("FullName");
    private final String value;

    OrganisationNameElementList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OrganisationNameElementList fromValue(String v) {
        for (OrganisationNameElementList c: OrganisationNameElementList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
