package com.safetyNet.alertsApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Firestation {

	private String address;
	private String station;
	
	public Firestation(@JsonProperty("address")String address, 
					@JsonProperty("station")String station) {
		super();
		this.address = address;
		this.station = station;
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
