package eu.impress.repository.dao;

import eu.impress.repository.model.incicrowd.DeleteObservation;
import eu.impress.repository.model.incicrowd.PutObservation;

import java.sql.SQLException;

/**
 * Created by jim on 21/12/2016.
 */
public interface ObservationDAO {
    public void saveObservation(PutObservation observation) throws SQLException;
    public void deleteObservation(DeleteObservation observation) throws SQLException;
}
