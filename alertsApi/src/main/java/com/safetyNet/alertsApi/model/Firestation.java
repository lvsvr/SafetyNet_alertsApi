package com.safetyNet.alertsApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Firestation {

	private String address;
	private String station;
	
	public Firestation(@JsonProperty("address")String address, 
					@JsonProperty("station")String station) {
		super();
		this.address = address;
		this.station = station;
	}

	public Firestation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAddress() {
		return address;
	}

	public String getStation() {
		return station;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setStation(String station) {
		this.station = station;
	}
	
	
	
}
