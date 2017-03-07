package eu.impress.repository.service;

import eu.impress.repository.dao.AlertDAO;
import eu.impress.repository.model.incicrowd.Alert;
import eu.impress.repository.model.incicrowd.GetAlertResponseBody;
import eu.impress.util.Point;
import eu.impress.util.Util;
import org.springframework.stereotype.Component;

import java.sql.*;

/**
 * Created by jim on 24/1/2017.
 */
@Component
public class AlertDAOImpl implements AlertDAO{
    //@Value("${spring.datasource.url}")
    private String url = "jdbc:mysql://localhost/ImpressIntegration";
    //@Value("${spring.datasource.username}")
    private String user = "root";
    //@Value("${spring.datasource.password}")
    private String password = "merootme";
    //private String password = "1q2w3e";
    //@Value("${spring.datasource.driver-class-name}")
    private String driver = "com.mysql.jdbc.Driver";
    @Override
    public void storeAlert(Alert alert) throws SQLException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Connection connection = DriverManager
                .getConnection(url,user, password);

        String sql = "INSERT INTO Alert " +
                "SET alertID = ?, "
                + "time = ?, "
                + "sender = ?, "
                + "headline=?,"
                + "description = ?," +
                "area = ?," +
                "centroid_lat = ?," +
                "centroid_long = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, alert.getAlertID());
            ps.setLong(2, alert.getTime());
            ps.setString(3, alert.getSender());
            ps.setString(4, alert.getHeadline());
            ps.setString(5, alert.getDescription());
            ps.setString(6, alert.getArea());
            Point centroid = Util.calculateCentroidFromCircleString(alert.getArea());
            ps.setDouble(7, centroid.getX());
            ps.setDouble(8, centroid.getY());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
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
    public GetAlertResponseBody getAlert(String alertID)  throws SQLException {
        GetAlertResponseBody getAlertResponseBody = new GetAlertResponseBody();
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Connection connection = DriverManager
                .getConnection(url,user, password);

        String sql = "SELECT * FROM Alert WHERE alertID=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, alertID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                getAlertResponseBody.setTime(rs.getLong("time"));
                getAlertResponseBody.setAlertID(rs.getString("alertID"));
                getAlertResponseBody.setArea(rs.getString("area"));
                getAlertResponseBody.setDescription(rs.getString("description"));
                getAlertResponseBody.setHeadline(rs.getString("headline"));
                getAlertResponseBody.setSender(rs.getString("sender"));
                return getAlertResponseBody;
            } else {
                return null;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
}
