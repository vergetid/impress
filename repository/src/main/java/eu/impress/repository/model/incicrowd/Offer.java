package eu.impress.repository.model.incicrowd;

/**
 * Created by jim on 4/12/2016.
 */
public class Offer {
    String offerNeedID;
    String accessKey;
    Long time;
    Double latitude;
    Double longitude;
    String category;
    String descritption;
    //TODO: String in schema. But may need to convert to byte array
    String image;
    String locationDescription;
}
