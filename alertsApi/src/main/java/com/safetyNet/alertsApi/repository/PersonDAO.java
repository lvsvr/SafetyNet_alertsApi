package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;
import java.util.Optional;

import com.safetyNet.alertsApi.model.Person;

public interface PersonDAO {

	ArrayList<Person> getAllPersons();

	Optional<Person> getPersonByNames(String firstName, String lastName);

	int insertPerson(Person person);

	int updatePersonByNames(String firstName, String lastName, Person updatedPerson);

	int deletePersonByNames(String firstName, String lastName);

}