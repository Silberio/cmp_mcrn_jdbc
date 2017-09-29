package model;

public class Station {
	private String station;
	private int status;
	public Station() {

	}

	public Station(String station, int status) {
		this.station = station;
		this.status = status;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
