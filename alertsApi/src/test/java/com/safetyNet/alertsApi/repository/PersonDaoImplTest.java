package com.safetyNet.alertsApi.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.alertsApi.model.JsonReader;
import com.safetyNet.alertsApi.model.Person;

@SpringBootTest
public class PersonDaoImplTest {
	
	@Test
	public void shouldLoadDataJsonObject() {
		//GIVEN
		JsonReader jsonReader = new JsonReader();
		//WHEN
		JSONObject dataJsonObject = jsonReader.readDataFromJsonFile();
		//THEN
		assertNotNull(dataJsonObject);
	}
	
	@Test
	public void shouldLoadPersonsArrayList() {
		//GIVEN
		JsonReader jsonReader = new JsonReader();
		JSONObject dataJsonObject = jsonReader.readDataFromJsonFile();
		ArrayList<Person> persons;
		//WHEN
		persons = jsonReader.getPersonsFromJson(dataJsonObject);
		//THEN
		assertNotNull(persons);
	}
	
	@Test
	public void shouldreturnAllPersons() {
		//GIVEN WHEN
		PersonDaoImpl personDao = new PersonDaoImpl();
		//THEN
		assertNotNull(personDao.getAllPersons());
		
	}
	
	@Test
	public void shouldInsertPerson() {
		//GIVEN
		PersonDaoImpl personDao = new PersonDaoImpl();
		Person person = new Person();
		person.setFirstName("gin");
		person.setLastName("rogers");
		//WHEN
		personDao.insertPerson(person);
		//THEN
		assertNotNull(personDao.getPersonByNames("gin", "rogers"));
		
	}
	
	@Test
	public void shouldUpdatePersonByNames() {
		//GIVEN
		PersonDaoImpl personDao = new PersonDaoImpl();
		Person person = new Person();
		person.setFirstName("gin");
		person.setLastName("rogers");
		personDao.insertPerson(person);
		person.setFirstName("ginger");
		//WHEN
		personDao.updatePersonByNames("gin","rogers", person);
		//THEN
		assertNotSame(personDao.getPersonByNames(person.getFirstName(), person.getLastName()), personDao.getPersonByNames("gin", "rogers"));
		
	}
	
	@Test
	public void shouldDeletePersonByNames() {
		//GIVEN
		PersonDaoImpl personDao = new PersonDaoImpl();
		
		Person person = new Person();
		person.setFirstName("gin");
		person.setLastName("rogers");
		personDao.insertPerson(person);
		//WHEN
		personDao.deletePersonByNames(person.getFirstName(),person.getLastName());
		//THEN
		assertNotSame(personDao.getPersonByNames(person.getFirstName(),person.getLastName()), person);
		
	}

}
