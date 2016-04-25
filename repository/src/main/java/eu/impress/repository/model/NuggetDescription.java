package eu.impress.repository.model;

import javax.xml.datatype.XMLGregorianCalendar;

public class NuggetDescription
{
    private String nugget;
    private String patientPseudoID;
    private String epoch;
    private String assetId;
	public String getNugget() {
		return nugget;
	}
	public void setNugget(String nugget) {
		this.nugget = nugget;
	}
	public String getPatientPseudoID() {
		return patientPseudoID;
	}
	public void setPatientPseudoID(String patientPseudoID) {
		this.patientPseudoID = patientPseudoID;
	}
	public String getEpoch() {
		return epoch;
	}
	public void setEpoch(String epoch) {
		this.epoch = epoch;
	}
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
    

  
}
