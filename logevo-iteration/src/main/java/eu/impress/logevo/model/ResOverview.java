package eu.impress.logevo.model;

import java.util.ArrayList;
import java.util.List;

public class ResOverview {
	ArrayList<String> desirableAssets;
	ArrayList<String> balancedAssets;
	
	public ResOverview() {
		desirableAssets = new ArrayList<String>();
		balancedAssets = new ArrayList<String>();
	}
	
	public List<String> getDesirableAssets() {
		return this.desirableAssets;
	}
	
	public List<String> getBalancedAssets() {
		return this.balancedAssets;
	}	
}
