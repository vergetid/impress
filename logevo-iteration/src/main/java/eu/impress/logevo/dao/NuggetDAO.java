package eu.impress.logevo.dao;

import eu.impress.logevo.model.Patient;

public interface NuggetDAO {
	public void initiatePatient(Patient patient, String eventId, String timeDiff);
}
