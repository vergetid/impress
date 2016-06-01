package eu.impress.logevo.util;

public enum Asset {
	Discharged("0"), Transferred("7"), Deceased("0"), NoTreatmentRequired("0"),
	RefusedCare("0"), TreatedAndReleased("0"), TreatedAndTransferredCare("7"),
	TreatedAndTransported("4"), Admitted("7"), TreatedAndTransportedToHospital("7"),
	PendingOngoing("0"),ExtensionValue("6");
	
	private String val;
	public String getVal() {
		return val;
	}
	private Asset(String val) {
		this.val = val;		
	}
	public static String getValByName(String name) {		
		for (Asset val: Asset.values()) {
			if ( name.replace("-","").toLowerCase().contains(val.name().toLowerCase())) {
				return val.getVal();
			}
		}
		return null;
	}
}

