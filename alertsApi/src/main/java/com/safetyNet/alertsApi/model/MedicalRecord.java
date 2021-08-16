package com.safetyNet.alertsApi.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class MedicalRecord {

	private String firstName;
	private String lastName;
	private String birthDate;
	private ArrayList<String> medications;
	private ArrayList<String> allergies;
	public MedicalRecord(String firstName, String lastName, String birthDate, ArrayList<String> medications,
			ArrayList<String> allergies) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.medications = medications;
		this.allergies = allergies;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public ArrayList<String> getMedications() {
		return medications;
	}
	public void setMedications(ArrayList<String> medications) {
		this.medications = medications;
	}
	public ArrayList<String> getAllergies() {
		return allergies;
	}
	public void setAllergies(ArrayList<String> allergies) {
		this.allergies = allergies;
	}
	
}
