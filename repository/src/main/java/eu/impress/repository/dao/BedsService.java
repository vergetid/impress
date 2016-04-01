package eu.impress.repository.dao;

import eu.impress.repository.model.BedStats;
import org.springframework.stereotype.Service;

@Service
public interface BedsService {
	BedStats getClinicAvailableBeds(Integer clinicId);
	BedStats getHospitalAvailableBeds(String hospitalName);
}
