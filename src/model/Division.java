package model;

public class Division {
	
	private String divisionName, stationLocationName;
	
	public Division() {
		
	}
	
	public Division(String divisionName, String stationLocationName) {
		this.divisionName = divisionName;
		this.stationLocationName = stationLocationName;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getStationLocationName() {
		return stationLocationName;
	}

	public void setStationLocationName(String stationLocationName) {
		this.stationLocationName = stationLocationName;
	}
	
	
	
}
