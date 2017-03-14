package eu.impress.repository.service;

import eu.impress.repository.dao.NeedDAO;
import eu.impress.repository.model.incicrowd.GetNeedsForRegion;
import eu.impress.repository.model.incicrowd.GetNeedsForRegionResponseBody;
import eu.impress.repository.model.incicrowd.PutNeed;
import eu.impress.repository.util.incicrowd.DistanceUtil;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jim on 19/2/2017.
 */
@Component
public class NeedDAOImpl implements NeedDAO {
    //@Value("${spring.datasource.url}")
    private String url = "jdbc:mysql://localhost/ImpressIntegration";
    //@Value("${spring.datasource.username}")
    private String user = "root";
    //@Value("${spring.datasource.password}")
    //private String password = "merootme";
    private String password = "1q2w3e";
    //@Value("${spring.datasource.driver-class-name}")
    private String driver = "com.mysql.jdbc.Driver";
    @Override
    public void saveNeed(PutNeed need) throws SQLException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Connection connection = DriverManager
                .getConnection(url,user, password);

        String sql = "INSERT INTO Need " +
                "SET offerNeedID = ?, "
                + "accessKey = ?, "
                + "time = ?, "
                + "latitude=?,"
                + "longitude = ?," +
                "description = ?,"+
                "category = ?," +
                "image = ?," +
                "locationDescription =?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, need.getOfferNeedID());
            ps.setString(2, need.getAccessKey());
            ps.setLong(3, need.getTime());
            ps.setDouble(4, need.getLatitude());
            ps.setDouble(5, need.getLongitude());
            ps.setString(6, need.getDescription());
            ps.setString(7, need.getCategory());
            ps.setString(8, need.getImage());
            ps.setString(9, need.getLocationDescription());

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
    public GetNeedsForRegionResponseBody getNeedList(GetNeedsForRegion getNeedsForRegion) throws SQLException {
        GetNeedsForRegionResponseBody getNeedsForRegionResponseBody = new GetNeedsForRegionResponseBody();
        List<PutNeed> getNeedsForRegionList = new ArrayList<>();
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Connection connection = DriverManager
                .getConnection(url,user, password);

        String sql = "SELECT * FROM Offer";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PutNeed need = new PutNeed();
                if (DistanceUtil.distance(getNeedsForRegion.getLatitude(),rs.getDouble("latitude"),
                        getNeedsForRegion.getLatitude(), rs.getDouble("longitude")) <= getNeedsForRegion.getRadius()) {
                    need.setAccessKey(rs.getString("accessKey"));
                    need.setCategory(rs.getString("category"));
                    need.setDescription(rs.getString("description"));
                    need.setImage(rs.getString("image"));
                    need.setLatitude(rs.getDouble("latitude"));
                    need.setLongitude(rs.getDouble("longitude"));
                    need.setOfferNeedID(rs.getString("offerNeedID"));
                    need.setTime(rs.getLong("time"));
                    need.setLocationDescription(rs.getString("locationDescription"));
                    getNeedsForRegionList.add(need);
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
        getNeedsForRegionResponseBody.setResponse("SUCCESS");
        getNeedsForRegionResponseBody.setNeeds(getNeedsForRegionList);
        return getNeedsForRegionResponseBody;
    }
}
