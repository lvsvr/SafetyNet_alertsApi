package com.safetyNet.alertsApi.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNet.alertsApi.model.Person;
import com.safetyNet.alertsApi.service.PersonService;

@RequestMapping("/person")
@RestController
public class PersonController {
	
	private final PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}

	@GetMapping
	public ArrayList<Person> getAllPersons(){
		return personService.getAllPersons();
	}
	
	@PostMapping
	public void insertPerson(@RequestBody Person person){
		personService.insertPerson(person);
	}
	
	@GetMapping(path= "{firstName}/{lastName}")
	public Optional<Person> getPersonByNames(@PathVariable String firstName,@PathVariable String lastName) {
		return personService.getPersonByNames(firstName, lastName);
	}
	
	@DeleteMapping(path= "{firstName}/{lastName}")
	public void deletePersonByNames(@PathVariable String firstName, @PathVariable String lastName) {
		personService.deletePersonByNames(firstName, lastName);
	}
	
	@PutMapping(path="{firstName}/{lastName}" )
	public void updatePersonByNames(@PathVariable String firstName, @PathVariable String lastName, @RequestBody Person updatedPerson) {
		personService.updatePersonByNames(firstName, lastName, updatedPerson);
	}
}
