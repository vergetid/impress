//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.01 at 06:02:17 PM EEST 
//


package oasis.names.tc.emergency.edxl.ciq._1_0.xpil;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonCategoryTypeList.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PersonCategoryTypeList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="ExistingCustomer"/>
 *     &lt;enumeration value="PotentialCustomer"/>
 *     &lt;enumeration value="Employee"/>
 *     &lt;enumeration value="Friend"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PersonCategoryTypeList")
@XmlEnum
public enum PersonCategoryTypeList {

    @XmlEnumValue("ExistingCustomer")
    EXISTING_CUSTOMER("ExistingCustomer"),
    @XmlEnumValue("PotentialCustomer")
    POTENTIAL_CUSTOMER("PotentialCustomer"),
    @XmlEnumValue("Employee")
    EMPLOYEE("Employee"),
    @XmlEnumValue("Friend")
    FRIEND("Friend");
    private final String value;

    PersonCategoryTypeList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PersonCategoryTypeList fromValue(String v) {
        for (PersonCategoryTypeList c: PersonCategoryTypeList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
