package eu.impress.repository.dao;



import eu.impress.repository.model.BedStats;
import oasis.names.tc.emergency.edxl.have._1.HospitalStatus;
import org.springframework.stereotype.Service;

@Service
public interface BeansTransformation {
	public HospitalStatus BedStatstoHAVE(BedStats bedstats);
}
