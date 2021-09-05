package com.safetyNet.alertsApi.controller;

import java.util.ArrayList;
import java.util.Optional;

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
	public ArrayList<Person> getAllPersons() {
		logger.info("Get all persons : ", personService.getAllPersons());
		return personService.getAllPersons();
	}

	@PostMapping
	public void insertPerson(@RequestBody Person person) {
		logger.info("Insert person : ", person);
		personService.insertPerson(person);
	}

	@GetMapping(path = "{firstName}/{lastName}")
	public Optional<Person> getPersonByNames(@PathVariable String firstName, @PathVariable String lastName) {
		logger.info("Get person by names : ", personService.getPersonByNames(firstName, lastName));
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
		logger.info("Update person by names : " + firstName + " " + lastName);
		personService.updatePersonByNames(firstName, lastName, updatedPerson);
	}
}
