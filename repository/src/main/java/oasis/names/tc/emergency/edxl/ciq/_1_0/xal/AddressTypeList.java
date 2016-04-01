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
 * <p>Java class for AddressTypeList.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AddressTypeList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="Airport"/>
 *     &lt;enumeration value="Business"/>
 *     &lt;enumeration value="CaravanPark"/>
 *     &lt;enumeration value="CommercialPark"/>
 *     &lt;enumeration value="CommunityDevelopment"/>
 *     &lt;enumeration value="EducationalInstitution"/>
 *     &lt;enumeration value="Entertainment"/>
 *     &lt;enumeration value="Hospital"/>
 *     &lt;enumeration value="Location"/>
 *     &lt;enumeration value="Marina"/>
 *     &lt;enumeration value="MilitaryBase"/>
 *     &lt;enumeration value="OverseasMilitary"/>
 *     &lt;enumeration value="Port"/>
 *     &lt;enumeration value="Primary"/>
 *     &lt;enumeration value="RecreationalPark"/>
 *     &lt;enumeration value="Resort"/>
 *     &lt;enumeration value="RetirementVillage"/>
 *     &lt;enumeration value="Rural"/>
 *     &lt;enumeration value="Secondary"/>
 *     &lt;enumeration value="ShoppingCentre"/>
 *     &lt;enumeration value="SportingCentre"/>
 *     &lt;enumeration value="Urban"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AddressTypeList")
@XmlEnum
public enum AddressTypeList {

    @XmlEnumValue("Airport")
    AIRPORT("Airport"),
    @XmlEnumValue("Business")
    BUSINESS("Business"),
    @XmlEnumValue("CaravanPark")
    CARAVAN_PARK("CaravanPark"),
    @XmlEnumValue("CommercialPark")
    COMMERCIAL_PARK("CommercialPark"),
    @XmlEnumValue("CommunityDevelopment")
    COMMUNITY_DEVELOPMENT("CommunityDevelopment"),
    @XmlEnumValue("EducationalInstitution")
    EDUCATIONAL_INSTITUTION("EducationalInstitution"),
    @XmlEnumValue("Entertainment")
    ENTERTAINMENT("Entertainment"),
    @XmlEnumValue("Hospital")
    HOSPITAL("Hospital"),
    @XmlEnumValue("Location")
    LOCATION("Location"),
    @XmlEnumValue("Marina")
    MARINA("Marina"),
    @XmlEnumValue("MilitaryBase")
    MILITARY_BASE("MilitaryBase"),
    @XmlEnumValue("OverseasMilitary")
    OVERSEAS_MILITARY("OverseasMilitary"),
    @XmlEnumValue("Port")
    PORT("Port"),
    @XmlEnumValue("Primary")
    PRIMARY("Primary"),
    @XmlEnumValue("RecreationalPark")
    RECREATIONAL_PARK("RecreationalPark"),
    @XmlEnumValue("Resort")
    RESORT("Resort"),
    @XmlEnumValue("RetirementVillage")
    RETIREMENT_VILLAGE("RetirementVillage"),
    @XmlEnumValue("Rural")
    RURAL("Rural"),
    @XmlEnumValue("Secondary")
    SECONDARY("Secondary"),
    @XmlEnumValue("ShoppingCentre")
    SHOPPING_CENTRE("ShoppingCentre"),
    @XmlEnumValue("SportingCentre")
    SPORTING_CENTRE("SportingCentre"),
    @XmlEnumValue("Urban")
    URBAN("Urban");
    private final String value;

    AddressTypeList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AddressTypeList fromValue(String v) {
        for (AddressTypeList c: AddressTypeList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
