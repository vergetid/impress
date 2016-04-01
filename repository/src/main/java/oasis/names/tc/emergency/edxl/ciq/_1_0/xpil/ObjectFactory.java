//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.01 at 06:02:17 PM EEST 
//


package oasis.names.tc.emergency.edxl.ciq._1_0.xpil;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oasis.names.tc.emergency.edxl.ciq._1_0.xpil package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _OrganisationDetails_QNAME = new QName("urn:oasis:names:tc:emergency:edxl:ciq:1.0:xpil", "OrganisationDetails");
    private final static QName _Party_QNAME = new QName("urn:oasis:names:tc:emergency:edxl:ciq:1.0:xpil", "Party");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oasis.names.tc.emergency.edxl.ciq._1_0.xpil
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Addresses }
     * 
     */
    public Addresses createAddresses() {
        return new Addresses();
    }

    /**
     * Create an instance of {@link ContactNumbers }
     * 
     */
    public ContactNumbers createContactNumbers() {
        return new ContactNumbers();
    }

    /**
     * Create an instance of {@link ElectronicAddressIdentifiers }
     * 
     */
    public ElectronicAddressIdentifiers createElectronicAddressIdentifiers() {
        return new ElectronicAddressIdentifiers();
    }

    /**
     * Create an instance of {@link Identifiers }
     * 
     */
    public Identifiers createIdentifiers() {
        return new Identifiers();
    }

    /**
     * Create an instance of {@link Identifiers.Identifier }
     * 
     */
    public Identifiers.Identifier createIdentifiersIdentifier() {
        return new Identifiers.Identifier();
    }

    /**
     * Create an instance of {@link ContactNumbers.ContactNumber }
     * 
     */
    public ContactNumbers.ContactNumber createContactNumbersContactNumber() {
        return new ContactNumbers.ContactNumber();
    }

    /**
     * Create an instance of {@link Addresses.Address }
     * 
     */
    public Addresses.Address createAddressesAddress() {
        return new Addresses.Address();
    }

    /**
     * Create an instance of {@link PersonDetails }
     * 
     */
    public PersonDetails createPersonDetails() {
        return new PersonDetails();
    }

    /**
     * Create an instance of {@link PersonDetailsType }
     * 
     */
    public PersonDetailsType createPersonDetailsType() {
        return new PersonDetailsType();
    }

    /**
     * Create an instance of {@link ElectronicAddressIdentifiers.ElectronicAddressIdentifier }
     * 
     */
    public ElectronicAddressIdentifiers.ElectronicAddressIdentifier createElectronicAddressIdentifiersElectronicAddressIdentifier() {
        return new ElectronicAddressIdentifiers.ElectronicAddressIdentifier();
    }

    /**
     * Create an instance of {@link OrganisationInfo }
     * 
     */
    public OrganisationInfo createOrganisationInfo() {
        return new OrganisationInfo();
    }

    /**
     * Create an instance of {@link PartyType }
     * 
     */
    public PartyType createPartyType() {
        return new PartyType();
    }

    /**
     * Create an instance of {@link OrganisationDetailsType }
     * 
     */
    public OrganisationDetailsType createOrganisationDetailsType() {
        return new OrganisationDetailsType();
    }

    /**
     * Create an instance of {@link Identifiers.Identifier.IdentifierElement }
     * 
     */
    public Identifiers.Identifier.IdentifierElement createIdentifiersIdentifierIdentifierElement() {
        return new Identifiers.Identifier.IdentifierElement();
    }

    /**
     * Create an instance of {@link ContactNumbers.ContactNumber.ContactNumberElement }
     * 
     */
    public ContactNumbers.ContactNumber.ContactNumberElement createContactNumbersContactNumberContactNumberElement() {
        return new ContactNumbers.ContactNumber.ContactNumberElement();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganisationDetailsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:emergency:edxl:ciq:1.0:xpil", name = "OrganisationDetails")
    public JAXBElement<OrganisationDetailsType> createOrganisationDetails(OrganisationDetailsType value) {
        return new JAXBElement<OrganisationDetailsType>(_OrganisationDetails_QNAME, OrganisationDetailsType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PartyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:emergency:edxl:ciq:1.0:xpil", name = "Party")
    public JAXBElement<PartyType> createParty(PartyType value) {
        return new JAXBElement<PartyType>(_Party_QNAME, PartyType.class, null, value);
    }

}
