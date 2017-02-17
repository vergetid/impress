/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.impress.repository.dao;

import javax.xml.datatype.DatatypeConfigurationException;
import oasis.names.tc.emergency.edxl.have._1.HospitalStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author danae
 */
@Service
public interface BedAvailabilityService {
    
    public String getBedAvailablityHAVE(String hospitalname);

    public String createBedAvailabilityDE(String countryParam) throws DatatypeConfigurationException;

    public String getBedAvailabilityEDXLDE(String edxlde, String edxlhave) throws DatatypeConfigurationException;
    public String forwardBedAvailability(String EDXLDEmessage);
    public String getBedTypeAvailablityHAVE(String hospitalname);
    public String getBedTypeAllAvailablityHAVE();
}
