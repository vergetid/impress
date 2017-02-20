package eu.impress.repository.dao;

import eu.impress.repository.model.incicrowd.GetNeedsForRegion;
import eu.impress.repository.model.incicrowd.GetNeedsForRegionResponseBody;
import eu.impress.repository.model.incicrowd.PutNeed;

import java.sql.SQLException;

/**
 * Created by jim on 19/2/2017.
 */
public interface NeedDAO {
    public void saveNeed(PutNeed need) throws SQLException;
    public GetNeedsForRegionResponseBody getNeedList(GetNeedsForRegion getNeedsForRegion) throws SQLException;
}
