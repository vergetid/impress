package eu.impress.logevo.model;

public class Patient {
	private int id;
	private String pseudoID;
	private String asset_id;
	private String nugget;

	public String getPseudoID() {
		return pseudoID;
	}

	public void setPseudoID(String pseudoID) {
		this.pseudoID = pseudoID;
	}

	public String getAsset_id() {
		return asset_id;
	}

	public void setAsset_id(String asset_id) {
		this.asset_id = asset_id;
	}

	public String getNugget() {
		return nugget;
	}

	public void setNugget(String nugget) {
		this.nugget = nugget;
	}

	public int getId() {
		return id;
	}

	public void setId(int patientId) {
		this.id = patientId;
	}
}
