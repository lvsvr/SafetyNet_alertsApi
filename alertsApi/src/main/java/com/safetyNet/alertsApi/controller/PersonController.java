package com.safetyNet.alertsApi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
