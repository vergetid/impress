package eu.impress.repository.model.incicrowd;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jim on 4/12/2016.
 */

//TODO: May not be needed; list of Alert objects used instead.
public class AlertsOperation implements Serializable {
    String response;
    List<Alert> alerts;
}
