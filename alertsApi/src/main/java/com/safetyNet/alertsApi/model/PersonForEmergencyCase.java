package com.safetyNet.alertsApi.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PersonForEmergencyCase {

	private String address;
	private String firestation;
	private String firstName;
	private String lastName;
	private String age;
	private String phone;
	private ArrayList<String> medications;
	private ArrayList<String> allergies;

	public PersonForEmergencyCase(@JsonProperty("address") String address,
			@JsonProperty("firsestation") String firestation,
			@JsonProperty("firstName") String firstName, @JsonProperty("lasttName") String lastName,
			@JsonProperty("age") String age, @JsonProperty("phone") String phone,
			@JsonProperty("medications") ArrayList<String> medications,
			@JsonProperty("allergies") ArrayList<String> allergies) {
		super();
		this.address = address;
		this.firestation = firestation;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.phone = phone;
		this.medications = medications;
		this.allergies = allergies;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public PersonForEmergencyCase() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getFirestation() {
		return firestation;
	}

	public void setFirestation(String firestation) {
		this.firestation = firestation;
	}

}
