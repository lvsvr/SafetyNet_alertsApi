package com.safetyNet.alertsApi.model;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonInfoTest {
	
	private PersonInfo personInfo;
	@Mock
	private ArrayList<String> medications;
	@Mock
	private ArrayList<String> allergies;
	
	@Test
	void shouldConstructPersonInfo() {
	//WHEN
	PersonInfo personInfo2 = new PersonInfo();
	//THEN
	assertNotNull(personInfo2);
	}	

	@Test
	void shouldConstructHome2() {
	//WHEN
	PersonInfo personInfo2 = new PersonInfo("gin", "rogers", "ad", "27", "grmail", null, null);
	//THEN
	assertNotNull(personInfo2);
	}
	
	@Test
	void shouldReturnGettersAndSetters() {
	//WHEN
	personInfo = new PersonInfo();
	personInfo.setFirstName("gin");
	personInfo.setLastName("rogers");
	personInfo.setAddress("ad");
	personInfo.setAge("27");
	personInfo.setEmail("grmail");
	personInfo.setMedications(medications);
	personInfo.setAllergies(allergies);
	//THEN
	assertNotNull(personInfo.getFirstName());
	assertNotNull(personInfo.getLastName());
	assertNotNull(personInfo.getAddress());
	assertNotNull(personInfo.getAge());
	assertNotNull(personInfo.getEmail());
	assertNotNull(personInfo.getMedications());
	assertNotNull(personInfo.getAllergies());
	}
}


