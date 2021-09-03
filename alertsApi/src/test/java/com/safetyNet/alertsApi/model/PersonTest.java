package com.safetyNet.alertsApi.model;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonTest {
	
	private Person person;
	
	@Test
	void shouldReturnGettersAndSetters() {
	//WHEN
	person = new Person();
	person.setFirstName("fn");
	person.setLastName("ln");
	person.setAddress("ad");
	person.setCity("ci");
	person.setZip("zi");
	person.setPhone("06");
	person.setEmail("ma");
	//THEN
	assertNotNull(person.getFirstName());
	assertNotNull(person.getLastName());
	assertNotNull(person.getAddress());
	assertNotNull(person.getCity());
	assertNotNull(person.getZip());
	assertNotNull(person.getPhone());
	assertNotNull(person.getEmail());
	}

}
