package eu.impress.repository.service;

import eu.impress.repository.dao.BedsQueryEngineService;
import eu.impress.repository.model.BedStats;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BedsQueryEngineImpl implements BedsQueryEngineService{
	private String queryTemplate;
	@Value("${d2r.endpoint}")
	private String endpoint;	
	public BedStats findHospitalAvailableBedsAllClinics(String hospital) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext();
		org.springframework.core.io.Resource resource = appContext.getResource(
				"classpath:sparqlQueries/BedsAvailabilityQuery");
		try {
			  InputStream is = resource.getInputStream();
	          BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        	
	          String line;
	          queryTemplate="";
	          while ((line = br.readLine()) != null) {
	             queryTemplate+=line+"\n";
	       	  } 
	          br.close();			
		} catch (IOException e1) {			
			e1.printStackTrace();
			return null;
		}

		List<String> params = new ArrayList<String>();
		params.add(hospital);params.add(hospital);
		String sparqlQuery = prepareQuery(queryTemplate, params);
		System.out.println(sparqlQuery);
		Query query = QueryFactory.create(sparqlQuery);
		QueryExecution qexec = QueryExecutionFactory.sparqlService(endpoint, query);		
		ResultSet results = qexec.execSelect() ;
		if (results.hasNext() )
		{
		  QuerySolution soln = results.next();

		  Literal available = soln.getLiteral("available") ;   // Get a result variable - must be a literal
		  Literal deployed = soln.getLiteral("deployed");
		  Literal supplementary = soln.getLiteral("supplementary");
		  //Literal lastDate = soln.getLiteral("maxDate");
		  BedStats bedStats = new BedStats();
		  bedStats.setHospitalName(params.get(0));
		  bedStats.setAvailabeBeds(available.getInt());
		  bedStats.setDeployedBeds(deployed.getInt());
		  bedStats.setSupplementaryBeds(supplementary.getInt());
		  //bedStats.setLastDate(lastDate.getShort());
		  return bedStats;
		} else {
			return null;
		}			
	}
	public BedStats findAvailableBedsByClinic(Integer clinicId) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("sparqlQueries/BedsAvailabilityQuery").getFile());
		try {
			queryTemplate = FileUtils.readFileToString(file);
			List<String> params = new ArrayList<String>();
			params.add(clinicId.toString());
			String sparqlQuery = prepareQuery(queryTemplate, params);
			Query query = QueryFactory.create(sparqlQuery);
			QueryExecution qexec = QueryExecutionFactory.sparqlService(endpoint, query);
			System.out.println(sparqlQuery);
		    ResultSet results = qexec.execSelect() ;
		    if (results.hasNext() )
		    {
		      QuerySolution soln = results.nextSolution();
		      
		      Literal l = soln.getLiteral("bedsAvailable") ;   // Get a result variable - must be a literal
		      BedStats bedStats = new BedStats();
		      bedStats.setClinicId(clinicId);
		      bedStats.setAvailabeBeds(l.getInt());
		      return bedStats;
		    } else {
		    	return null;
		    }
			
		
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}		
	}
	private String prepareQuery(String query, List<String> params) {
		Pattern pattern = Pattern.compile("\\[(.+?)\\]");
		Matcher matcher = pattern.matcher(query);
		StringBuffer buffer = new StringBuffer();
		int pos=0;
		while (matcher.find()) {
			String replacement = params.get(pos);
			if (replacement != null) {

				matcher.appendReplacement(buffer, "");
				buffer.append(replacement);
			}
			pos++;
		}
		matcher.appendTail(buffer);
		return buffer.toString();		
	}	
}
