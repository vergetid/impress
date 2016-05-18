package eu.impress.repository.dao;

import java.util.List;

import eu.impress.repository.model.GeoCentroid;

public interface GeoPointsDAO {
	List<GeoCentroid> getPointsAll();
}
