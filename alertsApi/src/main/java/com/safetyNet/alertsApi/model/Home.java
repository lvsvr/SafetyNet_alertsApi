package com.safetyNet.alertsApi.model;

import java.util.ArrayList;

public class Home {
	private String address;
	private String firestation;
	private ArrayList<Person> persons;
	private ArrayList<MedicalRecord> medicalRecords;

	public Home(String address, String station, ArrayList<Person> persons, ArrayList<MedicalRecord> medicalRecords) {
		super();
		this.address = address;
		this.firestation = station;
		this.persons = persons;
		this.medicalRecords = medicalRecords;
	}

	public Home() {
		super();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStation() {
		return firestation;
	}

	public void setStation(String station) {
		this.firestation = station;
	}

	public ArrayList<Person> getPersons() {
		return persons;
	}

	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}

	public ArrayList<MedicalRecord> getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(ArrayList<MedicalRecord> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

}
