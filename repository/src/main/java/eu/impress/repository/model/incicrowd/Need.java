package eu.impress.repository.model.incicrowd;

import java.io.Serializable;

/**
 * Created by jim on 4/12/2016.
 */
public class Need implements Serializable {
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
