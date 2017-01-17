package eu.impress.repository.model.incicrowd;

import java.io.Serializable;

/**
 * Created by jim on 4/12/2016.
 */
public class PutOffer implements Serializable{
    String offerNeedID;
    String accessKey;
    Long time;
    Double latitude;
    Double longitude;
    String category;
    String description;
    //TODO: String in schema. But may need to convert to byte array
    String image;
    String locationDescription;

    public String getOfferNeedID() {
        return offerNeedID;
    }

    public void setOfferNeedID(String offerNeedID) {
        this.offerNeedID = offerNeedID;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public PutOffer() {

    }
}
