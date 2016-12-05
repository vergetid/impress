package eu.impress.repository.model.incicrowd;

import java.io.Serializable;

/**
 * Created by jim on 4/12/2016.
 */
public class Observation implements Serializable{
    String observationID;
    String accesskey;
    Long time;
    Double latitude;
    Double longitude;
    String text;
    //TODO: String in schema. But may need to convert to byte array
    String image;
}
