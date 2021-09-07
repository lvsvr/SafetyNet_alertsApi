package com.safetyNet.alertsApi.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.safetyNet.alertsApi.AlertsApiApplication;
import com.safetyNet.alertsApi.model.Person;
import com.safetyNet.alertsApi.service.PersonService;

@RequestMapping("/person")
@RestController
public class PersonController {
	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);
	private final PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}

	@GetMapping
	public ArrayList<Person> getAllPersons() throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		logger.info("Get all persons: ");
		for(Person person :personService.getAllPersons()) {
		logger.info(person.getFirstName()+" "+person.getLastName()+" "+person.getAddress()+" "+ person.getCity()+" "+person.getZip()+" "+person.getPhone()+" "+person.getEmail());
		}
		return personService.getAllPersons();
		
		
	}

	@PostMapping
	public void insertPerson(@RequestBody Person person) {
		logger.info("Insert person : ");
		logger.info(person.getFirstName()+" "+person.getLastName()+" "+person.getAddress()+" "+ person.getCity()+" "+person.getZip()+" "+person.getPhone()+" "+person.getEmail());
		personService.insertPerson(person);
	}

	@GetMapping(path = "{firstName}/{lastName}")
	public Person getPersonByNames(@PathVariable String firstName, @PathVariable String lastName) {
		Person person = personService.getPersonByNames(firstName, lastName);
		logger.info("Get person by names : " + firstName + " "+ lastName);
		logger.info(person.getFirstName()+" "+person.getLastName()+" "+person.getAddress()+" "+ person.getCity()+" "+person.getZip()+" "+person.getPhone()+" "+person.getEmail());
		return personService.getPersonByNames(firstName, lastName);
	}

	@DeleteMapping(path = "{firstName}/{lastName}")
	public void deletePersonByNames(@PathVariable String firstName, @PathVariable String lastName) {
		logger.info("Delete person by names : " + firstName + " " + lastName);
		personService.deletePersonByNames(firstName, lastName);
	}

	@PutMapping(path = "{firstName}/{lastName}")
	public void updatePersonByNames(@PathVariable String firstName, @PathVariable String lastName,
			@RequestBody Person updatedPerson) {
		logger.info("Update person by names : "  + firstName + " "+ lastName);
		logger.info(updatedPerson.getFirstName()+" "+updatedPerson.getLastName()+" "+updatedPerson.getAddress()+" "+ updatedPerson.getCity()+" "+updatedPerson.getZip()+" "+updatedPerson.getPhone()+" "+updatedPerson.getEmail());
		personService.updatePersonByNames(firstName, lastName, updatedPerson);
	}
}
