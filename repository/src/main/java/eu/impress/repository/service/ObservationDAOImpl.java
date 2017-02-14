package eu.impress.repository.service;

import eu.impress.repository.dao.ObservationDAO;
import eu.impress.repository.model.incicrowd.DeleteObservation;
import eu.impress.repository.model.incicrowd.PutObservation;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by jim on 21/12/2016.
 */
@Component
public class ObservationDAOImpl implements ObservationDAO{
    //@Value("${spring.datasource.url}")
    private String url = "jdbc:mysql://localhost/ImpressIntegration";
    //@Value("${spring.datasource.username}")
    private String user = "root";
    //@Value("${spring.datasource.password}")
    private String password = "merootme";
    //@Value("${spring.datasource.driver-class-name}")
    private String driver = "com.mysql.jdbc.Driver";

    @Override
    public void saveObservation(PutObservation observation) throws SQLException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Connection connection = DriverManager
                .getConnection(url,user, password);

        String sql = "INSERT INTO Observation " +
                "SET observationID = ?, "
                + "accessKey = ?, "
                + "time = ?, "
                + "latitude=?,"
                + "longitude = ?," +
                "text = ?," +
                "image = ? ";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, observation.getObservationID());
            ps.setString(2, observation.getAccessKey());
            ps.setLong(3, observation.getTime());
            ps.setDouble(4, observation.getLatitude());
            ps.setDouble(5, observation.getLongitude());
            ps.setString(6, observation.getText());
            ps.setString(7, observation.getImage());
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
    public void deleteObservation(String observationID) throws SQLException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Connection connection = DriverManager
                .getConnection(url,user, password);

        String sql = "DELETE FROM Observation " +
                "WHERE observationID = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, observationID);
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
