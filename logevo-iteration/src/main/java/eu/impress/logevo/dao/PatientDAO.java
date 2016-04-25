package eu.impress.logevo.dao;

import java.sql.SQLException;

import eu.impress.logevo.model.Patient;

public interface PatientDAO {
	public Patient findPatientbyID(String id) throws SQLException;
	public void addPatient(Patient patient) throws SQLException;
	public void updatePatient(Patient patient) throws SQLException;
}
