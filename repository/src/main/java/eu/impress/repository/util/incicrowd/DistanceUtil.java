package eu.impress.repository.util.incicrowd;

/**
 * Created by jim on 17/1/2017.
 */
public class DistanceUtil {
    public static Double distance(Double lat1, Double lat2, Double long1, Double long2) {
        Double earth_radius = 6371000.0;
        Double dLat = Math.toRadians(lat2 - lat1);
        Double dLon = Math.toRadians(long2 - long1);
        Double a =
                Math.sin(dLat/2.0)*Math.sin(dLat/2.0)
                + Math.cos(Math.toRadians(lat1))*Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon/2.0)*Math.sin(dLon/2.0);
        Double c = 2.0 * Math.asin(Math.sqrt(a));
        Double d = earth_radius * c;
        return d;
    }
}
