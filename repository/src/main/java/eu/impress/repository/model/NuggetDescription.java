package eu.impress.repository.model;

import javax.xml.datatype.XMLGregorianCalendar;

public class NuggetDescription
{
    private String contents;
    private String patientPseudoID;
    private XMLGregorianCalendar timeStamp;

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getPatientPseudoID() {
        return patientPseudoID;
    }

    public void setPatientPseudoID(String patientPseudoID) {
        this.patientPseudoID = patientPseudoID;
    }

    public XMLGregorianCalendar getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(XMLGregorianCalendar timeStamp) {
        this.timeStamp = timeStamp;
    }    
}
