package eu.impress.repository.service;

import eu.impress.logevo.dao.PatientDAO;
import eu.impress.logevo.model.Patient;
import eu.impress.logevo.util.DateUtils;
import eu.impress.repository.dao.NuggetService;
import eu.impress.repository.model.NuggetDescription;
import eu.impress.util.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.sparql.modify.UpdateProcessRemote;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class NuggetServiceImpl implements NuggetService
{
    private static final Logger log = LoggerFactory.getLogger(eu.impress.repository.service.NuggetServiceImpl.class);
    private String queryTemplate;
    
    //@Value("${sparql.endpoint}")
    //private String sparqlEndpoint;
    
    @Autowired
    PatientDAO patientDAO;
    
	@Override
	public void updatePatientDirect(Patient patient) {
		patient.setLastUpdateTime(DateUtils.XmlGregorianDateStringtoEpoch("now"));
		try {
			patientDAO.updatePatient(patient);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    @Override 
    public Patient getPatientStateByPatientID(String patientID) {
    	try {
			return patientDAO.findPatientbyID(patientID);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
    @Override
    public NuggetDescription retrieveNuggetByPatientPseudoID(String patientPseudoID)
    {
	/*ApplicationContext appContext = new ClassPathXmlApplicationContext();
	org.springframework.core.io.Resource resource = appContext.getResource(
                "classpath:sparqlQueries/RetrieveLatestNuggetLink");
        
	try {
                InputStream is = resource.getInputStream();
	        BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        	
                String line;
	        queryTemplate="";
	        while ((line = br.readLine()) != null) {
	           queryTemplate+=line+"\n";
	       	} 
       	        br.close();			
		}
                catch (IOException e1) {			
                    e1.printStackTrace();
                    return null;
         }

        List<String> params = new ArrayList<String>();
	params.add(patientPseudoID);
	String sparqlQuery = Util.prepareQuery(queryTemplate, params);
	log.info(sparqlQuery);        
        
        Query query = QueryFactory.create(sparqlQuery);
        QueryExecution qexec = QueryExecutionFactory.sparqlService(sparqlEndpoint, query);		
        ResultSet results = qexec.execSelect() ;
        if (results.hasNext() )
        {
            QuerySolution soln = results.next();
            Literal nuggetlink = soln.getLiteral("nuggetlink"); 
            Literal time = soln.getLiteral("time");             
            NuggetDescription nugget = new NuggetDescription();
            nugget.setPatientPseudoID(patientPseudoID);
            nugget.setNugget(nuggetlink.getString());
            //nugget.setTimeStamp(time.getString());
            return nugget;
        } else {
        ret*/
	    return null;
    }

    @Override
    public void insertNewNugget(NuggetDescription nugget)
    {
        NuggetDescription newRecordNugget = this.retrieveNuggetByPatientPseudoID(nugget.getPatientPseudoID());
        
        log.info("newRecordNugget:" + newRecordNugget);
        
        if(newRecordNugget==null)
            this.createNewRecord(nugget);
        else
            this.appendNewRecord(nugget);        
    }

    private void createNewRecord(NuggetDescription nugget)
    {
        /*
            ApplicationContext appContext = new ClassPathXmlApplicationContext();
            org.springframework.core.io.Resource resource = appContext.getResource(
                    "classpath:sparqlQueries/InsertNewNuggetRecord");

            try {
                    InputStream is = resource.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));

                    String line;
                    queryTemplate="";
                    while ((line = br.readLine()) != null) {
                       queryTemplate+=line+"\n";
                    } 
                    br.close();			
                    }
                    catch (IOException e1) {			
                        e1.printStackTrace();
                        return;
            }

            List<String> params = new ArrayList<String>();
            params.add(nugget.getPatientPseudoID());
            params.add(nugget.getPatientPseudoID());
            params.add(nugget.getPatientPseudoID());        
            params.add(nugget.getNugget());
            params.add(nugget.getEpoch());
            String sparulQuery = Util.prepareQuery(queryTemplate, params);
            log.info(sparulQuery);        

            UpdateRequest update = UpdateFactory.create(sparulQuery);
            UpdateProcessRemote riStore = (UpdateProcessRemote) 
            UpdateExecutionFactory.createRemote(update, sparqlEndpoint);
            riStore.execute();*/
    }

    private void appendNewRecord(NuggetDescription nugget)
    {
            /*ApplicationContext appContext = new ClassPathXmlApplicationContext();
            org.springframework.core.io.Resource resource = appContext.getResource(
                    "classpath:sparqlQueries/InsertNuggetIntoExistingRecord");

            try {
                    InputStream is = resource.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));

                    String line;
                    queryTemplate="";
                    while ((line = br.readLine()) != null) {
                       queryTemplate+=line+"\n";
                    } 
                    br.close();			
                    }
                    catch (IOException e1) {			
                        e1.printStackTrace();
                        return;
             }

            List<String> params = new ArrayList<String>();
            params.add(nugget.getPatientPseudoID());
            params.add(nugget.getNugget());
            params.add(nugget.getEpoch());
            String sparulQuery = Util.prepareQuery(queryTemplate, params);
            log.info(sparulQuery);        

            UpdateRequest update = UpdateFactory.create(sparulQuery);
            UpdateProcessRemote riStore = (UpdateProcessRemote) 
            UpdateExecutionFactory.createRemote(update, sparqlEndpoint);
            riStore.execute();*/
    }
}
