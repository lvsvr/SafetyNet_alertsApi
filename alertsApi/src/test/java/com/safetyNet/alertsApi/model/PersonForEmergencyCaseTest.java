package com.safetyNet.alertsApi.model;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonForEmergencyCaseTest {
	
	private PersonForEmergencyCase personFec;
	
	@Test
	public void shouldConstructPfec() {
		//WHEN
		PersonForEmergencyCase personFec2  = new PersonForEmergencyCase();
		//THEN
		assertNotNull(personFec2);
	}
	
	@Test
	public void shouldConstructPfec2() {
		//WHEN
		personFec  = new PersonForEmergencyCase("ad", "1", "gin", "rogers","27", "888", null, null);
		//THEN
		assertNotNull(personFec);
	}
	
	@Test
	public void shouldReturngetters() {
		//WHEN
		ArrayList<String>medications = new ArrayList<String>();
		medications.add("medtest");
		ArrayList<String>allergies = new ArrayList<String>();
		allergies.add("alltest");
		PersonForEmergencyCase personFec3  = new PersonForEmergencyCase("ad", "1", "gin", "rogers","27", "888", medications, allergies);
		//THEN
		assertNotNull(personFec3.getAddress());
		assertNotNull(personFec3.getFirestation());
		assertNotNull(personFec3.getFirstName());
		assertNotNull(personFec3.getLastName());
		assertNotNull(personFec3.getAge());
		assertNotNull(personFec3.getPhone());
		assertNotNull(personFec3.getMedications());
		assertNotNull(personFec3.getAllergies());
	}
	
	@Test
	public void shouldConstructPfec3() {
		//WHEN
		ArrayList<String>medications = new ArrayList<String>();
		medications.add("medtest");
		ArrayList<String>allergies = new ArrayList<String>();
		allergies.add("alltest");
		personFec  = new PersonForEmergencyCase();
		personFec.setAddress("ad");
		personFec.setFirestation("1");
		personFec.setFirstName("gin");
		personFec.setLastName("rogers");
		personFec.setAge("27");
		personFec.setPhone("888");
		personFec.setMedications(medications);
		personFec.setAllergies(allergies);
		
		//THEN
		assertNotNull(personFec.getAddress());
		assertNotNull(personFec.getFirestation());
		assertNotNull(personFec.getFirstName());
		assertNotNull(personFec.getLastName());
		assertNotNull(personFec.getAge());
		assertNotNull(personFec.getPhone());
		assertNotNull(personFec.getMedications());
		assertNotNull(personFec.getAllergies());
	}
}
