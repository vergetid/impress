package eu.impress.logevo.util;

public enum Asset {
	NONE("0"), AMBULANCE("1"), EMERGENCY("2"), OPERATING("3"),
    POLICE("4"), SCENE("5"), SITE("6"); 
	
	private String val;
	public String getVal() {
		return val;
	}
	private Asset(String val) {
		this.val = val;		
	}
	public static String getValByName(String name) {		
		for (Asset val: Asset.values()) {
			if ( name.toLowerCase().contains(val.name().toLowerCase())) {
				return val.getVal();
			}
		}
		return null;
	}
}

