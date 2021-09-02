package com.safetyNet.alertsApi.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.safetyNet.alertsApi.repository.PersonDAO;
import com.safetyNet.alertsApi.model.Person;

@Service
public class PersonService {

	private final PersonDAO personDao;

	public PersonService(PersonDAO personDao) {
		super();
		this.personDao = personDao;
	}

	public ArrayList<Person> getAllPersons() {
		return personDao.getAllPersons();
	}

	public int insertPerson(Person person) {

		return personDao.insertPerson(person);
	}

	public Optional<Person> getPersonByNames(String firstName, String lastName) {
		return personDao.getPersonByNames(firstName, lastName);
	}

	public int deletePersonByNames(String firstName, String lastName) {
		return personDao.deletePersonByNames(firstName, lastName);
	}

	public int updatePersonByNames(String firstName, String lastName, Person updatedPerson) {
		return personDao.updatePersonByNames(firstName, lastName, updatedPerson);
	}
}
