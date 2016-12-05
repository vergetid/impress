package eu.impress.repository.model.incicrowd;

import java.io.Serializable;

/**
 * Created by jim on 4/12/2016.
 */
public class Alert implements Serializable {
    String response;
    Integer alertID;
    Long time;
    String sender;
    String headline;
    String description;
    //TODO: check the time for area. String in response string but internal representation may be list of points
    String area;
}
