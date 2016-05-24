package eu.impress.logevo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import eu.impress.logevo.dao.GaugerSymptomDAO;
import eu.impress.logevo.model.Patient;

@Component
public class GaugerSymptomDAOImpl implements GaugerSymptomDAO {
	//@Value("${spring.datasource.url}")
	private String url = "jdbc:mysql://localhost/ImpressIntegration";
	//@Value("${spring.datasource.username}")
	private String user = "root";
	//@Value("${spring.datasource.password}")
	private String password = "merootme";
	//@Value("${spring.datasource.driver-class-name}")
	private String driver = "com.mysql.jdbc.Driver";
	@Override
	public int getSymptomIdbySymtomDescription(String location, String symptomType) {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = null;
		try {
			connection = DriverManager
					.getConnection(url,user, password);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String sql = "SELECT SymptomId FROM GaugerSymptoms " +
				"WHERE Location LIKE ? AND Replace(Replace(SymptomType, \"/\", \"\"), \" \", \"\") LIKE ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, location);
			ps.setString(2, symptomType);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("SymptomId");
			} else {
				return -1;
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

}
