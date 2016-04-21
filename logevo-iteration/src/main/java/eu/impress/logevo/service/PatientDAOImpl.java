package eu.impress.logevo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import eu.impress.logevo.dao.PatientDAO;
import eu.impress.logevo.model.Patient;


@Component
public class PatientDAOImpl implements PatientDAO {

	//@Value("${spring.datasource.url}")
	private String url = "jdbc:mysql://localhost/ImpressIntegration";
	//@Value("${spring.datasource.username}")
	private String user = "root";
	//@Value("${spring.datasource.password}")
	private String password = "merootme";
	//@Value("${spring.datasource.driver-class-name}")
	private String driver = "com.mysql.jdbc.Driver";	
	
	
	@Override
	public Patient findPatientbyID(String id) {
		// Test data
		// TODO: insert Patient to database
		Patient patient = new Patient();
		patient.setPseudoID("0");
		return patient;
	}

	@Override
	public void addPatient(Patient patient) throws SQLException {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = DriverManager
				.getConnection(url,user, password);
		
		String sql = "INSERT INTO Patient " +
				"SET pseudoID = ?, "
				+ "asset = ?, "
				+ "nugget = ? ";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, patient.getPseudoID());
			ps.setString(2, patient.getAsset_id());
			ps.setString(3, patient.getNugget());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}	
		return;
	}

}
