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
 * <p>Java class for VisaElementList.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VisaElementList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="Type"/>
 *     &lt;enumeration value="Number"/>
 *     &lt;enumeration value="Code"/>
 *     &lt;enumeration value="Country"/>
 *     &lt;enumeration value="IssuePlace"/>
 *     &lt;enumeration value="MaximumStay"/>
 *     &lt;enumeration value="Restriction"/>
 *     &lt;enumeration value="Privilege"/>
 *     &lt;enumeration value="SpecialCondition"/>
 *     &lt;enumeration value="EntryType"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VisaElementList")
@XmlEnum
public enum VisaElementList {


    /**
     * 
     *                         Type of visa. e.g. Tourist, Visitor, Student
     *                     
     * 
     */
    @XmlEnumValue("Type")
    TYPE("Type"),
    @XmlEnumValue("Number")
    NUMBER("Number"),

    /**
     * 
     *                         Some visas are known by its code number.
     *                         e.g. B1, E3, H-1, Class X1
     *                     
     * 
     */
    @XmlEnumValue("Code")
    CODE("Code"),

    /**
     * 
     *                         Name of the country for which the visa is issued to.
     *                     
     * 
     */
    @XmlEnumValue("Country")
    COUNTRY("Country"),

    /**
     * 
     *                         Free text description of the issuing place, e.g. country name
     *                         and office name or country name and the city.
     * 			For example US Embassy, Prague, Australia, Sydney
     *                     
     * 
     */
    @XmlEnumValue("IssuePlace")
    ISSUE_PLACE("IssuePlace"),

    /**
     * 
     *                         Free text description of the length of maximum stay.
     *                         E.g. 1 week, 2 months, etc.
     *                     
     * 
     */
    @XmlEnumValue("MaximumStay")
    MAXIMUM_STAY("MaximumStay"),

    /**
     * 
     *                         Any restrictions imposed on the visa holder,
     *                         e.g. not for employment, cannot work for more than 20 hours
     *                     
     * 
     */
    @XmlEnumValue("Restriction")
    RESTRICTION("Restriction"),

    /**
     * 
     *                         Any privileges granted to the visa holder, e.g. departure fee waived, etc.
     *                     
     * 
     */
    @XmlEnumValue("Privilege")
    PRIVILEGE("Privilege"),

    /**
     * 
     *                         Any special conditions imposed on the visa holder.
     *                         e.g. Not allowed to work for more than 10 hours a week
     *                     
     * 
     */
    @XmlEnumValue("SpecialCondition")
    SPECIAL_CONDITION("SpecialCondition"),

    /**
     * 
     *                         Single Entry, Multiple Entry, Double Entry, etc
     *                     
     * 
     */
    @XmlEnumValue("EntryType")
    ENTRY_TYPE("EntryType");
    private final String value;

    VisaElementList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VisaElementList fromValue(String v) {
        for (VisaElementList c: VisaElementList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
