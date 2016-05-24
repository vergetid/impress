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

import oasis.names.tc.ciq.xnl._3.OrganisationNameType;
import oasis.names.tc.emergency.edxl.have._1.Capacity;
import oasis.names.tc.emergency.edxl.have._1.HospitalBedCapacityStatus;
import oasis.names.tc.emergency.edxl.have._1.HospitalBedCapacityStatus.BedCapacity;
import oasis.names.tc.emergency.edxl.have._1.HospitalStatus;
import oasis.names.tc.emergency.edxl.have._1.Organization;
import oasis.names.tc.emergency.edxl.have._1.OrganizationInformation;
import oasis.names.tc.emergency.edxl.have._1.HospitalStatus.Hospital;
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
		//nameElement.setValue("ΕΥΑΓΓΕΛΙΣΜΟΣ");
                nameElement.setValue("Ospedale Civico");
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
