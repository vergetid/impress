package eu.impress.rest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.impress.repository.dao.PopulationQueryService;
import eu.impress.util.Point;
import eu.impress.util.Util;

@RestController
public class PopulationQueryController {
	@Autowired
	PopulationQueryService populationQueryservice;
	@RequestMapping(
			value="/population/polygon", 
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE
			//produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
			//produces=MediaType.TEXT_PLAIN_VALUE
		)
	public ResponseEntity<PopulationResponse> getCityPopulation(
			@RequestParam("x[]") String x,
			@RequestParam("y[]") String y
		) {	

		if (x.split(",").length != y.split(",").length) {
			return new ResponseEntity<PopulationResponse>(HttpStatus.BAD_REQUEST);
		}
		List<Point> coords = Util.convertStringArraysToPoints(x.split(","), y.split(","));
		Integer population = populationQueryservice.getPopulation(coords);
		return new ResponseEntity<PopulationResponse>(new PopulationResponse(population.toString())
				, HttpStatus.OK);
	}
	private class PopulationResponse { 
	    private String population;
	    //public PopulationResponse(){}
	    public PopulationResponse(String s) { 
	       this.population = s;
	    }
	    public String getPopulation() {return population;}
	}	
}
