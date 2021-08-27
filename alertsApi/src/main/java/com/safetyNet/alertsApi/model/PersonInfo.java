package com.safetyNet.alertsApi.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PersonInfo {
	
	private String firstName;
	private String lastName;
	private String address;
	private String age;
	private String email;
	private ArrayList<String> medications;
	private ArrayList<String> allergies;
	
	public PersonInfo(@JsonProperty("firstName")String firstName, 
			@JsonProperty("lastName")String lastName, 
			@JsonProperty("address")String address, 
			@JsonProperty("age") String age, 
			@JsonProperty("email") String email,
			@JsonProperty("medications")ArrayList<String> medications, 
			@JsonProperty("allergies")ArrayList<String> allergies) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.age = age;
		this.email = email;
		this.medications = medications;
		this.allergies = allergies;
	}
	
	public PersonInfo() {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
