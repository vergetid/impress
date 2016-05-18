package eu.impress.repository.dao;

import java.util.List;

import eu.impress.util.Point;

public interface PopulationQueryService {
	public Integer getPopulation(List<Point> coords);
}
