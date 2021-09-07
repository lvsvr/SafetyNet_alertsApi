package com.safetyNet.alertsApi.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.alertsApi.model.Person;
import com.safetyNet.alertsApi.repository.PersonDaoImpl;

@SpringBootTest
public class PersonServiceTest {
	
	@Mock
	private PersonDaoImpl personDao;
	
	@Test
	public void shouldReturnPersonsList() {
		//WHEN
		PersonService personService = new PersonService(personDao);
		//THEN
		assertNotNull(personService.getAllPersons());
		
	}

	@Test
	public void shouldinsertPerson() {
		//GIVEN
		PersonService personService = new PersonService(personDao);
		Person person = new Person("John","AAAAA","1509 Culver St","Culver","97451","841-874-6512","jaboyd@email.com");
		ArrayList<Person>persons = personService.getAllPersons();
		//WHEN
		personService.insertPerson(person);
		//THEN
		assertNotSame(persons, personService.getAllPersons());
		
	}
	
	@Test
	public void shouldReturnPersonByNames() {
		//WHEN
		PersonDaoImpl personDao = new PersonDaoImpl();
		PersonService personService = new PersonService(personDao);
		//THEN
		assertNotNull(personService.getPersonByNames("John", "Boyd"));
		
	}
	
	@Test
	public void shouldDeletePersonByNames() {
		//GIVEN
		PersonService personService = new PersonService(personDao);
		ArrayList<Person>persons = personService.getAllPersons();
		//WHEN
		personService.deletePersonByNames("John", "Boyd");
		//THEN
		assertNotSame(persons, personService.getAllPersons());
		
	}
	
	@Test
	public void shouldUpdatePersonByNames() {
		//GIVEN
		PersonDaoImpl personDao = new PersonDaoImpl();
		PersonService personService = new PersonService(personDao);
		Person person = personService.getPersonByNames("John", "Boyd");
		person.setAddress("paradise");
		//WHEN
		personService.updatePersonByNames("John","Boyd", person);
		//THEN
		assertEquals("paradise",personService.getPersonByNames("John", "Boyd").getAddress());
		
	}
}
