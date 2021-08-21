package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;

import com.safetyNet.alertsApi.model.Person;

public interface PersonDAO {
	
	ArrayList<Person> getAllPersons();

	int insertPerson(Person person);

}
