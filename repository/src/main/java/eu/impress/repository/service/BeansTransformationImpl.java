package eu.impress.repository.service;

import eu.impress.repository.dao.BeansTransformation;
import eu.impress.repository.model.BedStats;
import java.math.BigInteger;

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

}
