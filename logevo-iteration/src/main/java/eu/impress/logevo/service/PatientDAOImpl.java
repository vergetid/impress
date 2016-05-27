package eu.impress.logevo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public List<String> getNuggetsPerIncidentId(String incidentId) throws SQLException {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = DriverManager
				.getConnection(url,user, password);
		
		String sql = "SELECT nugget FROM Patient " +
				"WHERE incidentId = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, incidentId);
			ResultSet rs = ps.executeQuery();
			List<String> nuggets = new ArrayList<String>();
			while (rs.next()) {
				String nugget = rs.getString("nugget");
				nuggets.add(nugget);

			} 
			return nuggets;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}			
	}
	
	@Override
	public Patient findPatientbyID(String pseudoId) throws SQLException {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = DriverManager
				.getConnection(url,user, password);
		
		String sql = "SELECT * FROM Patient " +
				"WHERE pseudoID = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, pseudoId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Patient patient = new Patient();
				patient.setId(rs.getInt("id"));
				patient.setPseudoID(rs.getString("pseudoID"));
				patient.setAsset_id(rs.getString("asset"));
				patient.setNugget(rs.getString("nugget"));
				patient.setLastUpdateTime(rs.getString("lastUpdatedTime"));
				return patient;
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}	
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
				+ "nugget = ?, "
				+ "lastUpdatedTime=?,"
				+ "incidentId = ? ";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, patient.getPseudoID());
			ps.setString(2, patient.getAsset_id());
			ps.setString(3, patient.getNugget());
			ps.setString(4, patient.getLastUpdateTime());
			ps.setString(5, patient.getIncidentId());
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
	@Override
	public void updatePatient(Patient patient) throws SQLException {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = DriverManager
				.getConnection(url,user, password);
		
		String sql = "UPDATE Patient " +
				"SET pseudoID = ?, "
				+ "asset = ?, "
				+ "nugget = ?, "
				+ "lastUpdatedTime=? "
				+ "WHERE id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, patient.getPseudoID());
			ps.setString(2, patient.getAsset_id());
			ps.setString(3, patient.getNugget());
			ps.setString(4, patient.getLastUpdateTime());
			ps.setInt(5, patient.getId());
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
