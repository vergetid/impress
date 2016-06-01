package eu.impress.logevo.dao;

import java.util.List;

import eu.impress.logevo.model.GaugerSymptom;
import eu.impress.logevo.model.Patient;

public interface NuggetDAO {
	public void initiatePatient(Patient patient, String eventId, String timeDiff);
	public void updatePatient(Patient patient, String TEPTime, String sickevoAsset);		
	public void updatePatientWithSymptoms(Patient patient, List<GaugerSymptom> symptoms);
	public void updatePatientStatScoring(Patient patient);
}
