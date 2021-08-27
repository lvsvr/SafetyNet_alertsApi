package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

import com.safetyNet.alertsApi.AlertsApiApplication;
import com.safetyNet.alertsApi.model.Person;

@Repository("personDao")
public class PersonDataAccessService implements PersonDAO {
	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);
	private static JsonReader jsonReader = new JsonReader();
	private static ArrayList<Person> persons;

	public PersonDataAccessService() {
		super();
		JSONObject dataJsonObject = jsonReader.readDataFromJsonFile();
		persons = jsonReader.getPersonsFromJson(dataJsonObject);

	}

	@Override
	public ArrayList<Person> getAllPersons() {
		return persons;
	}

	@Override
	public int insertPerson(Person person) {
		persons.add(new Person(person.getFirstName(), person.getLastName(), person.getAddress(), person.getCity(),
				person.getZip(), person.getPhone(), person.getEmail()));
		return 1;
	}

	@Override
	public Optional<Person> getPersonByNames(String firstName, String lastName) {
		Person namedPerson = new Person();
		for (Person person : persons) {
			if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
				namedPerson = person;
			}
		}
		return Optional.of(namedPerson);
	}

	@Override
	public int updatePersonByNames(String firstName, String lastName, Person updatedPerson) {
		Optional<Person> personToUpdate = getPersonByNames(firstName, lastName);
		if (personToUpdate == null) {
			return 0;
		}
		ArrayList<Person> personsMemo = new ArrayList<Person>();
		for (Person person : persons) {
			if (!(person.getFirstName().equals(firstName) && person.getLastName().equals(lastName))) {
				personsMemo.add(person);
			} else if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
				personsMemo.add(updatedPerson);
			}
		}
		persons = personsMemo;
		return 1;
	}

	@Override
	public int deletePersonByNames(String firstName, String lastName) {
		Optional<Person> personToDelete = getPersonByNames(firstName, lastName);
		if (personToDelete == null) {
			return 0;
		}
		ArrayList<Person> personsMemo = new ArrayList<Person>();
		for (Person person : persons) {
			if (!(person.getFirstName().equals(firstName) && person.getLastName().equals(lastName))) {
				personsMemo.add(person);
			}
		}
		persons = personsMemo;
		return 1;
	}

}
