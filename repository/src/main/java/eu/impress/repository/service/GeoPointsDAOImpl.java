package eu.impress.repository.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import eu.impress.logevo.model.Patient;
import eu.impress.repository.dao.GeoPointsDAO;
import eu.impress.repository.model.GeoCentroid;


@Service
public class GeoPointsDAOImpl implements GeoPointsDAO {
	//@Value("${spring.datasource.url}")
	private String url = "jdbc:mysql://localhost/ImpressIntegration";
	//@Value("${spring.datasource.username}")
	private String user = "root";
	//@Value("${spring.datasource.password}")
	private String password = "merootme";
    //    private String password = "1q2w3e";
	//@Value("${spring.datasource.driver-class-name}")
	private String driver = "com.mysql.jdbc.Driver";	
	
	@Override
	public List<GeoCentroid> getPointsAll() {
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
			e1.printStackTrace();
			return null;
		}
		
		String sql = "SELECT * FROM PopulationBlocks";
		
		List<GeoCentroid> points = new ArrayList<GeoCentroid>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				GeoCentroid p = new GeoCentroid();
				p.setCentroidLng(rs.getDouble("lng"));
				p.setCentroidLat(rs.getDouble("lat"));
				p.setPopulation(rs.getInt("population"));
				points.add(p);
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
		return points;
	}

}
