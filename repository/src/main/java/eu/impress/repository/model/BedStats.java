package eu.impress.repository.model;

import java.util.Date;

import eu.impress.util.Pair;

public class BedStats {
	private String hospitalName;
	@Deprecated
	private Integer clinicId;
	private Integer availabeBeds;
	private Integer supplementaryBeds;
	private Integer deployedBeds;
    private String clinicType;        
	private Date lastDate;
	private Pair<String, Integer> typesPerClinic;

        public String getClinicType() {
            return clinicType;
        }

        public void setClinicType(String clinicType) {
            this.clinicType = clinicType;
        }
                
	public Integer getSupplementaryBeds() {
		return supplementaryBeds;
	}
	public void setSupplementaryBeds(Integer supplementaryBeds) {
		this.supplementaryBeds = supplementaryBeds;
	}
	public Integer getDeployedBeds() {
		return deployedBeds;
	}
	public void setDeployedBeds(Integer deployedBeds) {
		this.deployedBeds = deployedBeds;
	}
	
	public Integer getClinicId() {
		return clinicId;
	}
	public void setClinicId(Integer clinicId) {
		this.clinicId = clinicId;
	}
	public Integer getAvailabeBeds() {
		return availabeBeds;
	}
	public void setAvailabeBeds(Integer availabeBeds) {
		this.availabeBeds = availabeBeds;
	}
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public Pair<String, Integer> getTypesPerClinic() {
		return typesPerClinic;
	}

	public void setTypesPerClinic(Pair<String, Integer> typesPerClinic) {
		this.typesPerClinic = typesPerClinic;
	}	
}
