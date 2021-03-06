package eu.impress.repository.service;

import eu.impress.repository.dao.BeansTransformation;
import eu.impress.repository.model.BedStats;

import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import eu.impress.repository.model.incicrowd.PutObservation;
import net.opengis.gml._3.DirectPositionType;
import net.opengis.gml._3.PointType;
import oasis.names.tc.ciq.xnl._3.OrganisationNameType;
import oasis.names.tc.emergency.edxl.ciq._1_0.xnl.PersonNameType;
import oasis.names.tc.emergency.edxl.ciq._1_0.xnl.PersonNameType.NameElement;
import oasis.names.tc.emergency.edxl.ct._1.EDXLLocationType;
import oasis.names.tc.emergency.edxl.ct._1.PersonDetailsType;
import oasis.names.tc.emergency.edxl.ct._1.PersonTimePairType;
import oasis.names.tc.emergency.edxl.gsf._1.EDXLGeoLocationType;

import oasis.names.tc.emergency.edxl.have._1.Capacity;
import oasis.names.tc.emergency.edxl.have._1.HospitalBedCapacityStatus;
import oasis.names.tc.emergency.edxl.have._1.HospitalBedCapacityStatus.BedCapacity;
import oasis.names.tc.emergency.edxl.have._1.HospitalStatus;
import oasis.names.tc.emergency.edxl.have._1.Organization;
import oasis.names.tc.emergency.edxl.have._1.OrganizationInformation;
import oasis.names.tc.emergency.edxl.have._1.HospitalStatus.Hospital;
import oasis.names.tc.emergency.edxl.sitrep._1.FieldObservation;
import oasis.names.tc.emergency.edxl.sitrep._1.SitRep;
import org.apache.jena.sparql.function.library.e;
import org.springframework.stereotype.Component;

@Component
public class BeansTransformationImpl implements BeansTransformation {

	@Override
	public HospitalStatus BedStatstoHAVE(BedStats bedStats) {
		HospitalStatus hospitalStatus = new HospitalStatus();
		Hospital hospital = new Hospital();
		Organization organization = new Organization();
		OrganizationInformation organizationInformation = new OrganizationInformation();
		OrganisationNameType organisationNameType = new OrganisationNameType();		
		OrganisationNameType.NameElement nameElement = new OrganisationNameType.NameElement();
		nameElement.setValue(bedStats.getHospitalName());
		organisationNameType.getNameElement().add(nameElement);
		organizationInformation.getOrganisationName().add(organisationNameType);
		organization.setOrganizationInformation(organizationInformation);
		hospital.setOrganization(organization);	
		
		HospitalBedCapacityStatus hospitalBedCapacityStatus = new HospitalBedCapacityStatus();
		BedCapacity bedCapacity = new BedCapacity();
		Capacity capacity = new Capacity();
		capacity.setCapacityStatus("Vacant/Available");
		capacity.setAvailableCount(BigInteger.valueOf(bedStats.getAvailabeBeds() 
				+ bedStats.getSupplementaryBeds()));
		capacity.setBaselineCount(BigInteger.valueOf(
				bedStats.getAvailabeBeds() + bedStats.getDeployedBeds() + bedStats.getSupplementaryBeds()));
		bedCapacity.getCapacity().add(capacity);
		hospitalBedCapacityStatus.getBedCapacity().add(bedCapacity);
	
		hospital.setHospitalBedCapacityStatus(hospitalBedCapacityStatus);
		hospitalStatus.getHospital().add(hospital);
		return hospitalStatus;
	}

    @Override
    public HospitalStatus BedTypesStatstoHAVE(List<BedStats> bedstatslist) {
		HospitalStatus hospitalStatus = new HospitalStatus();
		Hospital hospital = new Hospital();
		Organization organization = new Organization();
		OrganizationInformation organizationInformation = new OrganizationInformation();
		OrganisationNameType organisationNameType = new OrganisationNameType();		
		OrganisationNameType.NameElement nameElement = new OrganisationNameType.NameElement();
		String hospitalName = null;
		if (bedstatslist != null && bedstatslist.size() > 0) {
			hospitalName = bedstatslist.get(0).getHospitalName();
			if (hospitalName.equalsIgnoreCase("Civico")) {
				hospitalName = "Ospedale Civico";
			} 
		} else {
			return hospitalStatus;
		}
		//nameElement.setValue("ΕΥΑΓΓΕΛΙΣΜΟΣ");
                nameElement.setValue(hospitalName);
		organisationNameType.getNameElement().add(nameElement);
		organizationInformation.getOrganisationName().add(organisationNameType);
		organization.setOrganizationInformation(organizationInformation);
		hospital.setOrganization(organization);	
		
		HospitalBedCapacityStatus hospitalBedCapacityStatus = new HospitalBedCapacityStatus();

                String[] a = {"PediatricICU", "AdultICU", "NeonatalICU"};
                int i = 0;
                
                for(BedStats bedStats : bedstatslist)
                {
                    BedCapacity bedCapacity = new BedCapacity();
                    //bedCapacity.getBedType().add(bedStats.getClinicType());
                    bedCapacity.getBedType().add(bedStats.getClinicType());
                    //if (i == 2) {
                    //	break;
                    //}
                    Capacity capacity = new Capacity();
                    capacity.setCapacityStatus("Vacant/Available");
                    //capacity.setAvailableCount(BigInteger.valueOf(bedStats.getAvailabeBeds()));
                    //capacity.setAvailableCount(BigInteger.valueOf(152));
                    capacity.setAvailableCount(BigInteger.valueOf(bedStats.getAvailabeBeds()));
                    capacity.setBaselineCount(BigInteger.valueOf(bedStats.getBaselineBeds()));
                    bedCapacity.getCapacity().add(capacity);
                    hospitalBedCapacityStatus.getBedCapacity().add(bedCapacity);
                }

            try {
                hospital.setLastUpdateTime(getXMLGregorianCalendar());
            } catch (DatatypeConfigurationException ex) {
                Logger.getLogger(BeansTransformationImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            hospital.setHospitalBedCapacityStatus(hospitalBedCapacityStatus);
            hospitalStatus.getHospital().add(hospital);

            return hospitalStatus;        
    }

	   @Override
    public SitRep ObservationToEDLXL(PutObservation putObservation) {
        SitRep sitRep = new SitRep();
        sitRep.setMessageID(putObservation.getObservationID());

        //set time
        Date date = new Date((long) putObservation.getTime());
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        XMLGregorianCalendar date2 = null;
        try {
             date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(BeansTransformationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PersonTimePairType timeValue = new PersonTimePairType();
        timeValue.setTimeValue(date2);
        
        
        PersonNameType personName = new PersonNameType();
        PersonNameType.NameElement name = new PersonNameType.NameElement();
        name.setValue("INCICROWD");      
        personName.getNameElement().add(name);
        PersonDetailsType personDetails = new PersonDetailsType();
        personDetails.getPersonName().add(personName);        
        timeValue.setPersonDetails(personDetails);
        
        sitRep.setPreparedBy(timeValue);

        FieldObservation report = new FieldObservation();

        DirectPositionType pos = new DirectPositionType();
        pos.getValue().add(putObservation.getLatitude());
        pos.getValue().add(putObservation.getLongitude());

        PointType point = new PointType();
        point.setPos(pos);

        EDXLGeoLocationType geolocation = new EDXLGeoLocationType();
        geolocation.setPoint(point);

        EDXLLocationType observationLocation = new EDXLLocationType();
        observationLocation.setEDXLGeoLocation(geolocation);

        report.setObservationLocation(observationLocation);
        report.setObservationText(putObservation.getText());
        sitRep.setReport(report);

        return sitRep;
    }

	public static XMLGregorianCalendar getXMLGregorianCalendar() throws DatatypeConfigurationException
    {
            try {
                Date now = new Date();
                GregorianCalendar c = new GregorianCalendar();
                c.setTime(now);
                XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
                return date2;
            }
            catch (DatatypeConfigurationException c) 
            {
                return null;
            }
    }           
        
}
