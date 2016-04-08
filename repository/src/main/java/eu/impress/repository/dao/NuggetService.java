package eu.impress.repository.dao;

import eu.impress.repository.model.NuggetDescription;

public interface NuggetService
{
    public NuggetDescription retrieveNuggetByPatientPseudoID(String patientPseudoID);
    public void insertNewNugget(NuggetDescription nugget);
}
