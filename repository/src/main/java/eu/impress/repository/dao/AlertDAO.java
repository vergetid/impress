package eu.impress.repository.dao;

import eu.impress.repository.model.incicrowd.Alert;
import eu.impress.repository.model.incicrowd.GetAlertResponseBody;
import eu.impress.repository.model.incicrowd.GetAlertsForRegion;
import eu.impress.repository.model.incicrowd.GetAlertsForRegionResponseBody;

import java.sql.SQLException;

/**
 * Created by jim on 24/1/2017.
 */
public interface AlertDAO {
    public void storeAlert(Alert alert) throws SQLException;
    public GetAlertResponseBody getAlert(String alertID)  throws SQLException;
    public void deleteAlert(String alertID) throws SQLException;
    GetAlertsForRegionResponseBody getAlertsForRegion(GetAlertsForRegion getAlertsForRegion) throws SQLException;
}
