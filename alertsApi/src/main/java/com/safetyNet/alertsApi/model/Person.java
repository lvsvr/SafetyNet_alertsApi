package com.safetyNet.alertsApi.model;

import lombok.Data;

@Data
public class Person {
	
	private final String firstName;
	private final String lastName;
	private final String address;
	private final String city;
	private final String zip;
	private final String phone;
	private final String mail;
	
	public Person(String firstName, String lastName, String address, String city, String zip, String phone,
			String mail) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.phone = phone;
		this.mail = mail;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getZip() {
		return zip;
	}

	public String getPhone() {
		return phone;
	}

	public String getMail() {
		return mail;
	}
	
}
