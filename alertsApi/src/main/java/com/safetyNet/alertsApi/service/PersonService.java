package com.safetyNet.alertsApi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.safetyNet.alertsApi.repository.PersonDAO;
import com.safetyNet.alertsApi.model.Person;

@Service
public class PersonService {
	
	private final PersonDAO personDao;

	@Autowired
	public PersonService (@Qualifier("personDao")PersonDAO personDao) {
		super();
		this.personDao = personDao;
	}
	
	public ArrayList<Person> getAllPersons(){
		return personDao.getAllPersons();
	}
	public int insertPerson(Person person) {
		
		return personDao.insertPerson(person);
	}
}
