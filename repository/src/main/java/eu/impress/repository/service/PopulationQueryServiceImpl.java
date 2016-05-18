package eu.impress.repository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.impress.repository.dao.GeoPointsDAO;
import eu.impress.repository.dao.PopulationQueryService;
import eu.impress.repository.model.GeoCentroid;
import eu.impress.util.Point;
import eu.impress.util.Util;

@Service
public class PopulationQueryServiceImpl implements PopulationQueryService {

	@Autowired
	GeoPointsDAO geoPointsDAO;
	@Override
	public Integer getPopulation(List<Point> coords) {
		Integer populationTotal = 0;
		List<GeoCentroid> mapPoints = geoPointsDAO.getPointsAll();

		System.out.println("DEBUG: PopulationQueryServiceImpl");
		System.out.println("Points Constructed from query");
		for (Point p: coords) {
			System.out.println("x: " + p.getX() + " y: " + p.getY());
		}
		//check each for each centroid if it is contained in the polygon
		for (GeoCentroid mapPoint : mapPoints) {
			if (Util.pointContained(mapPoint, coords)) {
				populationTotal += mapPoint.getPopulation();
			}
		}
		return populationTotal;
	}

}
