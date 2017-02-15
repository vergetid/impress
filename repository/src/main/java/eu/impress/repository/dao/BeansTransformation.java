package eu.impress.repository.dao;

import eu.impress.repository.model.BedStats;
import java.util.List;

import eu.impress.repository.model.incicrowd.PutObservation;
import oasis.names.tc.emergency.edxl.have._1.HospitalStatus;
import oasis.names.tc.emergency.edxl.sitrep._1.SitRep;
import org.springframework.stereotype.Service;

@Service
public interface BeansTransformation {
	public HospitalStatus BedStatstoHAVE(BedStats bedstats);
	public HospitalStatus BedTypesStatstoHAVE(List<BedStats> bedstatslist);
	public SitRep ObservationToEDLXL(PutObservation putObservation);
}
