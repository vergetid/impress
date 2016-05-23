package eu.impress.rest.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import eu.impress.repository.model.weather.current.WeatherCurrent;
import eu.impress.repository.model.weather.forecast.WeatherForecast;


@RestController
public class WeatherQueryController {
	@Value("${openweathermap.appkey}")
	private String appKey;
	@Value("${openweathermap.current.area.restendpoint}")
	private String currentAreaEndpoint;
	@Value("${openweathermap.current.circle.restendpoint}")
	private String currentCirlcleEndpoint;	
	@Value("${openweathermap.forecast.circle.restendpoint}")
	private String forecastCirlcleEndpoint;		
	
	//
	//1st version:
	//Just return the response from open weather map for cities in rectangle
	//	
	@RequestMapping(
			value="/weather/current/area", 
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<WeatherCurrent> getWeatherInRectangle(
			@RequestParam("lngLeft") String lngLeft,
			@RequestParam("latBottom") String latBottom,
			@RequestParam("lngRight") String lngRight,
			@RequestParam("latTop") String latTop) {
		RestTemplate restTemplate = new RestTemplate();
		String restEndpoint = currentAreaEndpoint+lngLeft+","+latBottom+","+lngRight+","+latTop+",100";
		restEndpoint += "&appid="+appKey;
		WeatherCurrent weatherCurrent = 
				restTemplate.getForObject(restEndpoint, WeatherCurrent.class);			
		return new ResponseEntity<WeatherCurrent>(weatherCurrent, HttpStatus.OK);
	}
	@RequestMapping(
			value="/weather/current/circle", 
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<WeatherCurrent> getWeatherInCircle(
			@RequestParam("lat") String lat,
			@RequestParam("long") String lng,
			@RequestParam("cnt") String cnt) {
		RestTemplate restTemplate = new RestTemplate();
		String restEndpoint = currentCirlcleEndpoint+lat+","+lat+"&lon="+lng+","+lng+"&cnt="+cnt;
		restEndpoint += "&appid="+appKey;
		WeatherCurrent weatherCurrent = 
				restTemplate.getForObject(restEndpoint, WeatherCurrent.class);			
		return new ResponseEntity<WeatherCurrent>(weatherCurrent, HttpStatus.OK);
	}	
	@RequestMapping(
			value="/weather/forecast/area", 
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<String> getForecastInRectangle() {
		return new ResponseEntity<String>("Not Currently Supported", HttpStatus.OK);
	}
	@RequestMapping(
			value="/weather/forecast/circle", 
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<WeatherForecast> getForecastInCircle(
			@RequestParam("lat") String lat,
			@RequestParam("long") String lng,
			@RequestParam(value = "cnt", required=false) String cnt) {
		RestTemplate restTemplate = new RestTemplate();
		String restEndpoint = forecastCirlcleEndpoint +
				"lat=" + lat +
				"&lon="+lng+
				"&cnt="+cnt+
				"&appid="+appKey;
		WeatherForecast weatherForecast = 
				restTemplate.getForObject(restEndpoint, WeatherForecast.class);		
		return new ResponseEntity<WeatherForecast>(weatherForecast, HttpStatus.OK);
	}

}