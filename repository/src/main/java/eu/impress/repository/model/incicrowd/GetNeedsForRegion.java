package eu.impress.repository.model.incicrowd;

import java.io.Serializable;

/**
 * Created by jim on 19/2/2017.
 */
public class GetNeedsForRegion implements Serializable{
    Double latitude;
    Double longitude;
    Integer radius;

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public GetNeedsForRegion() {

    }
}
