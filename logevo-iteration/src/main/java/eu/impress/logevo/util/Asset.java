package eu.impress.logevo.util;

public enum Asset {
	Discharged("0"), Transferred("2"), Deceased("0"), NoTreatmentRequired("3"),
	RefusedCare("5"), TreatedAndReleased("0"), TreatedAndTransferredCare("2"),
	TreatedAndTransported("1"), Admitted("2"), TreatedAndTransportedToHospital("2"),
	PendingOngoing("5");
	
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

