package eu.impress.repository.model;

public class GeoCentroid {
	double centroidLat;
	double centroidLng;
	Integer population;
	public double getCentroidLat() {
		return centroidLat;
	}
	public void setCentroidLat(double centroidLat) {
		this.centroidLat = centroidLat;
	}
	public double getCentroidLng() {
		return centroidLng;
	}
	public void setCentroidLng(double centroidLng) {
		this.centroidLng = centroidLng;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}	
}
