package eu.impress.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eu.impress.repository.model.GeoCentroid;

public class Util {
    public static String prepareQuery(String query, List<String> params) {
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
    
    public static List<Point> convertStringArraysToPoints(String[] x, String[] y) {
    	if (x.length != y.length) {
    		return null;
    	}
    	List<Point> points = new ArrayList<Point>();
    	for (int i = 0; i < x.length; i++) {
    		double xFloat = Double.parseDouble(x[i]);
    		double yFloat = Double.parseDouble(y[i]);
    		Point p = new Point();
    		p.setX(xFloat);
    		p.setY(yFloat);
    		points.add(p);
    	}
    	
    	return points;
    }
    
    public static boolean pointContained(GeoCentroid test, List<Point> points) {
        int i;
        int j;
        boolean result = false;
        for (i = 0, j = points.size() - 1; i < points.size(); j = i++) {
          if ((points.get(i).getY() > test.getCentroidLng()) != (points.get(j).getY() > test.getCentroidLng()) &&
              (test.getCentroidLat() < (points.get(j).getX() - points.get(i).getX()) * (test.getCentroidLng() - points.get(i).getY()) / (points.get(j).getY()-points.get(i).getY()) + points.get(i).getX())) {
            result = !result;
           }
        }
        return result;   	
    }
}
