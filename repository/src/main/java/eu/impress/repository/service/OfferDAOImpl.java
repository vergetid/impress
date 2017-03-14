package eu.impress.repository.service;

import eu.impress.repository.dao.OfferDAO;
import eu.impress.repository.model.incicrowd.GetOffersForRegion;
import eu.impress.repository.model.incicrowd.GetOffersForRegionResponseBody;
import eu.impress.repository.model.incicrowd.PutOffer;
import eu.impress.repository.util.incicrowd.DistanceUtil;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jim on 17/1/2017.
 */
@Component
public class OfferDAOImpl implements OfferDAO {
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
    public void saveOffer(PutOffer offer) throws SQLException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Connection connection = DriverManager
                .getConnection(url,user, password);

        String sql = "INSERT INTO Offer " +
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
            ps.setString(1, offer.getOfferNeedID());
            ps.setString(2, offer.getAccessKey());
            ps.setLong(3, offer.getTime());
            ps.setDouble(4, offer.getLatitude());
            ps.setDouble(5, offer.getLongitude());
            ps.setString(6, offer.getDescription());
            ps.setString(7, offer.getCategory());
            ps.setString(8, offer.getImage());
            ps.setString(9, offer.getLocationDescription());

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
    public GetOffersForRegionResponseBody getOfferList(GetOffersForRegion getOffersForRegion) throws SQLException {
        GetOffersForRegionResponseBody getOffersForRegionResponseBody = new GetOffersForRegionResponseBody();
        List<PutOffer> getOffersForRegionList = new ArrayList<PutOffer>();
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
                PutOffer offer = new PutOffer();
                if (DistanceUtil.distance(getOffersForRegion.getLatitude(),rs.getDouble("latitude"),
                        getOffersForRegion.getLatitude(), rs.getDouble("longitude")) <= getOffersForRegion.getRadius()) {
                    offer.setAccessKey(rs.getString("accessKey"));
                    offer.setCategory(rs.getString("category"));
                    offer.setDescription(rs.getString("description"));
                    offer.setImage(rs.getString("image"));
                    offer.setLatitude(rs.getDouble("latitude"));
                    offer.setLongitude(rs.getDouble("longitude"));
                    offer.setOfferNeedID(rs.getString("offerNeedID"));
                    offer.setTime(rs.getLong("time"));
                    offer.setLocationDescription(rs.getString("locationDescription"));
                    getOffersForRegionList.add(offer);
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
        getOffersForRegionResponseBody.setResponse("SUCCESS");
        getOffersForRegionResponseBody.setOffers(getOffersForRegionList);
        return getOffersForRegionResponseBody;
    }
}
