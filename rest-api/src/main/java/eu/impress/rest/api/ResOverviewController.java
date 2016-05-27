package eu.impress.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.impress.logevo.dao.ResOverviewDAO;
import eu.impress.logevo.model.ResOverview;


@RestController
public class ResOverviewController {
	
	@Autowired
	ResOverviewDAO resOverviewDAO;
	
	@RequestMapping(
			value="/resoverview", 
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<ResOverview> getWeatherInRectangle(
			@RequestParam("incidentId") String incidentId) {
		ResOverview resOverview = resOverviewDAO.getResOverview(incidentId);
		return new ResponseEntity<ResOverview>(resOverview, HttpStatus.OK);
	}
}
