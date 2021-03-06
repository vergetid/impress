package eu.impress.repository.service;

import eu.impress.repository.dao.AlertDAO;
import eu.impress.repository.model.incicrowd.Alert;
import eu.impress.repository.model.incicrowd.GetAlertResponseBody;
import eu.impress.repository.model.incicrowd.GetAlertsForRegion;
import eu.impress.repository.model.incicrowd.GetAlertsForRegionResponseBody;
import eu.impress.repository.util.incicrowd.DistanceUtil;
import eu.impress.util.Point;
import eu.impress.util.Util;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

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
            //ps.setString(6, alert.getArea());
            Point centroid = Util.calculateCentroidFromCircleString(alert.getArea());
            ps.setDouble(7, centroid.getX());
            ps.setDouble(8, centroid.getY());
            Point topLeft = new Point();
            Point topRight = new Point();
            Point bottomRight = new Point();
            Point bottomLeft = new Point();
            topLeft.setX(centroid.getX() - 1.0);
            topLeft.setY(centroid.getY() + 1.0);
            topRight.setX(centroid.getX() + 1.0);
            topRight.setY(centroid.getY() + 1.0);
            bottomRight.setX(centroid.getX() + 1.0);
            bottomRight.setY(centroid.getY() - 1.0);
            bottomLeft.setX(centroid.getX() - 1.0);
            bottomLeft.setY(centroid.getY() - 1.0);
            String area = Double.toString(topLeft.getY()) + " " + Double.toString(topLeft.getX());
            area += "," + Double.toString(topRight.getY()) + " " + Double.toString(topRight.getX());
            area += "," + Double.toString(bottomRight.getY()) + " " + Double.toString(bottomRight.getX());
            area += "," + Double.toString(bottomLeft.getY()) + " " + Double.toString(bottomLeft.getX());
            ps.setString(6, "POLYGON (("+area+"))");
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
                getAlertResponseBody.setResponse("SUCCESS");
                return getAlertResponseBody;
            } else {
                return null;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public GetAlertsForRegionResponseBody getAlertsForRegion(GetAlertsForRegion getAlertsForRegion) throws SQLException {
        GetAlertsForRegionResponseBody getAlertsForRegionResponseBody = new GetAlertsForRegionResponseBody();
        List<Alert> getAlertsForRegionList = new ArrayList<Alert>();
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Connection connection = DriverManager
                .getConnection(url,user, password);

        String sql = "SELECT * FROM Alert";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alert alert = new Alert();
                if (DistanceUtil.distance(getAlertsForRegion.getLatitude(),rs.getDouble("centroid_lat"),
                        getAlertsForRegion.getLatitude(), rs.getDouble("centroid_long")) <= getAlertsForRegion.getRadius()) {
                    alert.setAlertID(rs.getString("alertID"));
                    alert.setTime(rs.getLong("time"));
                    alert.setArea(rs.getString("area"));
                    alert.setDescription(rs.getString("description"));
                    alert.setHeadline(rs.getString("headline"));
                    alert.setSender(rs.getString("sender"));

                    getAlertsForRegionList.add(alert);
                }
            }
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
        getAlertsForRegionResponseBody.setResponse("SUCCESS");
        getAlertsForRegionResponseBody.setAlerts(getAlertsForRegionList);
        return getAlertsForRegionResponseBody;
    }

    @Override
    public void deleteAlert(String alertID) throws SQLException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Connection connection = DriverManager
                .getConnection(url,user, password);

        String sql = "DELETE FROM Alert where alertID = ?";
                
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, alertID);
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
}
