/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.impress.repository.dao;

import eu.impress.repository.model.BedStats;
import org.springframework.stereotype.Service;

/**
 *
 * @author danae
 */
@Service
public interface BedsQueryEngineService {
    
    public BedStats findHospitalAvailableBedsAllClinics(String hospital);
    public BedStats findAvailableBedsByClinic(Integer clinicId);
    
}