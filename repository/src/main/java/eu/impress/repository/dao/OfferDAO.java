package eu.impress.repository.dao;

import eu.impress.repository.model.incicrowd.GetOffersForRegion;
import eu.impress.repository.model.incicrowd.GetOffersForRegionResponseBody;
import eu.impress.repository.model.incicrowd.PutOffer;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Created by jim on 17/1/2017.
 */
public interface OfferDAO {
    public void saveOffer(PutOffer offer) throws SQLException;
    public GetOffersForRegionResponseBody getOfferList(GetOffersForRegion getOffersForRegion) throws SQLException;
    //public void deleteObservation(DeleteOffer observation) throws SQLException;
}
