package eu.impress.repository.service;

import eu.impress.repository.dao.BedsService;
import eu.impress.repository.model.BedStats;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BedsServiceImpl implements BedsService {

	@Autowired
	private BedsQueryEngineImpl bedsQueryEngine;
	
	@Override
	public BedStats getClinicAvailableBeds(Integer clinicId) {
		BedStats bedStats = bedsQueryEngine.findAvailableBedsByClinic(clinicId);
		return bedStats;
	}

	@Override
	public BedStats getHospitalAvailableBeds(String hospitalName) {
		BedStats bedStats = bedsQueryEngine.findHospitalAvailableBedsAllClinics(hospitalName);
		return bedStats;
	}

	@Override
	public BedStats getHospitalAllAvailableBeds() {
		//BedStats bedStats = bedsQueryEngine.findHospitalAvailableBedsAllClinics();
		//return bedStats;
		return null;
	}

	@Override
	public List<BedStats> getHospitalAvailableBedTypes(String hospitalName) {
		List<BedStats> bedStatslist = bedsQueryEngine.findHospitalAvailableBedsTypes(hospitalName);
		return bedStatslist;            
	}

	@Override
	public List<BedStats> getHospitalAllAvailableBedTypes() {
		List<BedStats> bedStatslist = bedsQueryEngine.findHospitalAllAvailableBedsTypes();
		return bedStatslist;
	}

}
