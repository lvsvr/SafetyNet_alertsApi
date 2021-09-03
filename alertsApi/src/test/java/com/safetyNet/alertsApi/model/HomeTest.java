package com.safetyNet.alertsApi.model;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HomeTest {
	
	private Home home;
	@Mock
	private ArrayList<Person> persons;
	@Mock
	private ArrayList<MedicalRecord> medicalRecords;
	
	@Test
	void shouldConstructHome() {
	//WHEN
	Home home2 = new Home();
	//THEN
	assertNotNull(home2);
	}	

	@Test
	void shouldConstructHome2() {
	//WHEN
	Home home2 = new Home("ad", "1", null, null);
	//THEN
	assertNotNull(home2);
	}
	
	@Test
	void shouldReturnGettersAndSetters() {
	//WHEN
	home = new Home();
	home.setAddress("ad");
	home.setStation("1");
	home.setPersons(persons);
	home.setMedicalRecords(medicalRecords);
	//THEN
	assertNotNull(home.getAddress());
	assertNotNull(home.getStation());
	assertNotNull(home.getPersons());
	assertNotNull(home.getMedicalRecords());
	}
}
