package eu.impress.repository.service;

import eu.impress.logevo.model.Patient;
import eu.impress.repository.dao.BedsQueryEngineService;
import eu.impress.repository.model.BedStats;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	@Value("${sql.endpoint}")
	private String sqlendpoint;
	@Value("${sql.user}")
	private String user;
	@Value("${sql.password}")
	private String password;
	@Value("${sql.database}")
	private String database;	
	public BedStats findHospitalAvailableBedsAllClinics(String hospital) {
		/*ApplicationContext appContext = new ClassPathXmlApplicationContext();
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
		}	*/
		return null;
	}
	public BedStats findAvailableBedsByClinic(Integer clinicId) {
		/*ClassLoader classLoader = getClass().getClassLoader();
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
		      
		      Literal l = soln.getLiteral("AdultICU") ;   // Get a result variable - must be a literal
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
		}	*/
		return null;
	}

	/*public List<BedStats> findHospitalAvailableBedsTypes(String hospital) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext();
		org.springframework.core.io.Resource resource = appContext.getResource(
				"classpath:sparqlQueries/BedsTypesAvailabilityQuery");
                
                List<BedStats> bedStatsList = new ArrayList<BedStats>();
                
		try 
                {
                  InputStream is = resource.getInputStream();
	          BufferedReader br = new BufferedReader(new InputStreamReader(is));
                          
	          String line;
	          queryTemplate="";
                  
	          while ((line = br.readLine()) != null)
                  {
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
		ResultSet results = qexec.execSelect();
                
		if(results.hasNext())
		{
		  QuerySolution soln = results.next();

		  String clinics[] = {"AdultICU", "PediatricICU", "NeonatalICU", "EmergencyDepartment",
				  "NurseryBeds", "MedicalSurgical", "RehabLongTermCare", "Burn", "Pediatrics",
				  "AdultPsychiatric", "PediatricPsychiatric", "NegativeFlowIsolation",
				  "OtherIsolation", "OperatingRooms"};
		  for (int i = 0; i < clinics.length; i++) {
			  Literal clinicBeds = soln.getLiteral(clinics[i]);
			  BedStats bedStats = new BedStats();
			  bedStats.setClinicType(clinics[i]);
			  bedStats.setAvailabeBeds(clinicBeds.getInt());
	                  
	          bedStatsList.add(bedStats);			  
		  }

        }                  
                  
		return bedStatsList;
	}		*/	
    public List<BedStats> findHospitalAllAvailableBedsTypes() {
		String connectionString =
				sqlendpoint+";"
						+ "database="+database+";"
						+ "user="+user+";"
						+ "password="+password+";"
						+ "loginTimeout=30;";
		// Declare the JDBC objects.
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(connectionString);
			String sql = "SELECT a.HospitalName as HospitalName,"
					+ "			a.AdultICU as AdultICU, b.AdultICU as AdultICUbaseline,"
					+ "			 a.PediatricICU as PediatricICU, b.PediatricICU as  PediatricICUbaseline,"
					+ "			 a.NeonatalICU as NeonatalICU, b.NeonatalICU as NeonatalICUbaseline,"
					+ "			a.EmergencyDepartment as EmergencyDepartment, b.EmergencyDepartment as EmergencyDepartmentbaseline,"
					+ "			a.NurseryBeds as NurseryBeds, b.NurseryBeds as NurseryBedsbaseline,"
					+ "			a.MedicalSurgical as MedicalSurgical, b.MedicalSurgical as MedicalSurgicalbaseline,"
					+ "			a.RehabLongTermCare as RehabLongTermCare, b.RehabLongTermCare as RehabLongTermCarebaseline,"
					+ "			a.Burn as Burn, b.Burn as Burnbaseline,"
					+ "			a.Pediatrics as Pediatrics, b.Pediatrics as Pediatricsbaseline,"
					+ "			a.AdultPsychiatric as AdultPsychiatric, b.AdultPsychiatric as AdultPsychiatricbaseline,"
					+ "			a.PediatricPsychiatric as PediatricPsychiatric, b.PediatricPsychiatric as PediatricPsychiatricbaseline,"
					+ "			a.NegativeFlowIsolation as NegativeFlowIsolation, b.NegativeFlowIsolation as NegativeFlowIsolationbaseline,"
					+ "			a.OtherIsolation as OtherIsolation, b.OtherIsolation as OtherIsolationbaseline,"
					+ "			a.OperatingRooms as OperatingRooms, b.OperatingRooms as OperatingRoomsbaseline\n"
					+ "FROM "
					+ "	HIS_RES_Hospital_Clinics_Availability_Beds_LastUpdate as a,"
					+ "	HIS_RES_Hospital_Clinics_Capability as b"
					+ "	WHERE"
					+ "	a.HospitalID = b.HospitalID\n"
					+ "";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				List<BedStats> bedStatsList = new ArrayList<BedStats>();
				String clinics[] = {"AdultICU", "PediatricICU", "NeonatalICU", "EmergencyDepartment",
						"NurseryBeds", "MedicalSurgical", "RehabLongTermCare", "Burn", "Pediatrics",
						"AdultPsychiatric", "PediatricPsychiatric", "NegativeFlowIsolation",
						"OtherIsolation", "OperatingRooms"};
				for (String clinic : clinics) {
					BedStats bedStats = new BedStats();
					bedStats.setHospitalName(rs.getString("HospitalName"));
					bedStats.setClinicType(clinic);
					bedStats.setAvailabeBeds(rs.getInt(clinic));
					bedStats.setBaselineBeds(rs.getInt(clinic+"baseline"));
					bedStatsList.add(bedStats);
				}
				return bedStatsList;

			} else {
				return null;
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}



		finally {
			if (connection != null) try { connection.close(); } catch(Exception e) {}
		}
		return null;
	}
	public List<BedStats> findHospitalAvailableBedsTypes(String hospital) {
        String connectionString =
                sqlendpoint+";"
                + "database="+database+";"
                + "user="+user+";"
                + "password="+password+";"
                + "loginTimeout=30;";
        // Declare the JDBC objects.
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
        Connection connection = null;
                    
        try {
            connection = DriverManager.getConnection(connectionString);
    		String sql = "SELECT a.HospitalName as HospitalName,"
    				+ "			a.AdultICU as AdultICU, b.AdultICU as AdultICUbaseline,"
    				+ "			 a.PediatricICU as PediatricICU, b.PediatricICU as  PediatricICUbaseline,"
    				+ "			 a.NeonatalICU as NeonatalICU, b.NeonatalICU as NeonatalICUbaseline,"
    				+ "			a.EmergencyDepartment as EmergencyDepartment, b.EmergencyDepartment as EmergencyDepartmentbaseline,"
    				+ "			a.NurseryBeds as NurseryBeds, b.NurseryBeds as NurseryBedsbaseline,"
    				+ "			a.MedicalSurgical as MedicalSurgical, b.MedicalSurgical as MedicalSurgicalbaseline,"
    				+ "			a.RehabLongTermCare as RehabLongTermCare, b.RehabLongTermCare as RehabLongTermCarebaseline,"
    				+ "			a.Burn as Burn, b.Burn as Burnbaseline,"
    				+ "			a.Pediatrics as Pediatrics, b.Pediatrics as Pediatricsbaseline,"
    				+ "			a.AdultPsychiatric as AdultPsychiatric, b.AdultPsychiatric as AdultPsychiatricbaseline,"
    				+ "			a.PediatricPsychiatric as PediatricPsychiatric, b.PediatricPsychiatric as PediatricPsychiatricbaseline,"
    				+ "			a.NegativeFlowIsolation as NegativeFlowIsolation, b.NegativeFlowIsolation as NegativeFlowIsolationbaseline,"
    				+ "			a.OtherIsolation as OtherIsolation, b.OtherIsolation as OtherIsolationbaseline,"
    				+ "			a.OperatingRooms as OperatingRooms, b.OperatingRooms as OperatingRoomsbaseline\n"
    				+ "FROM "
    				+ "	HIS_RES_Hospital_Clinics_Availability_Beds_LastUpdate as a,"
    				+ "	HIS_RES_Hospital_Clinics_Capability as b"
    				+ "	WHERE"
    				+ "	a.HospitalID = b.HospitalID AND\n"
    				+ " a.HospitalName LIKE ?\n"
    				+ "";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, "%"+hospital+"%");
			ResultSet rs = ps.executeQuery();
			System.out.println("GENERATED QUERY: ");
			System.out.println(sql);
			if (rs.next()) {
				  List<BedStats> bedStatsList = new ArrayList<BedStats>();
				  String clinics[] = {"AdultICU", "PediatricICU", "NeonatalICU", "EmergencyDepartment",
						  "NurseryBeds", "MedicalSurgical", "RehabLongTermCare", "Burn", "Pediatrics",
						  "AdultPsychiatric", "PediatricPsychiatric", "NegativeFlowIsolation",
						  "OtherIsolation", "OperatingRooms"};	
				  for (String clinic : clinics) {
					  BedStats bedStats = new BedStats();
					  bedStats.setHospitalName(rs.getString("HospitalName"));
					  bedStats.setClinicType(clinic);
					  bedStats.setAvailabeBeds(rs.getInt(clinic));
					  bedStats.setBaselineBeds(rs.getInt(clinic+"baseline"));
					  bedStatsList.add(bedStats);
				  }
				  return bedStatsList;

			} else {
				return null;
			}    		

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        finally {
            if (connection != null) try { connection.close(); } catch(Exception e) {}
        }        
		return null;
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
