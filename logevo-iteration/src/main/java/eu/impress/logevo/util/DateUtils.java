package eu.impress.logevo.util;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateUtils {
	public static String XmlGregorianDateStringtoEpoch(String date) {
		try {
			if (date.equals("now")) {
			      GregorianCalendar gcal = new GregorianCalendar();
			      Long epoch = gcal.getTimeInMillis();
			      return epoch.toString();
			} else {
				XMLGregorianCalendar dateGc = DatatypeFactory.newInstance().newXMLGregorianCalendar(date);
				Long epoch = dateGc.toGregorianCalendar().getTimeInMillis();
				return epoch.toString();
			}
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}
}