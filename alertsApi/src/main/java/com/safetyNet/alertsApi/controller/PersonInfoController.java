package com.safetyNet.alertsApi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNet.alertsApi.model.PersonInfo;
import com.safetyNet.alertsApi.service.PersonInfoService;

@RequestMapping("/personInfo")
@RestController
public class PersonInfoController {
	
	@Autowired
	private final PersonInfoService personInfoService;

	public PersonInfoController(PersonInfoService personInfoService) {
		super();
		this.personInfoService = personInfoService;
	}
	
	@GetMapping
	public ArrayList<PersonInfo> getPersonInfoByFirstNameAndLastName(@RequestParam(name="firstName")String firstName, @RequestParam(name="lastName") String lastName){
		return personInfoService.getPersonInfoByFirstNameAndLastName(firstName, lastName);
	}
	

}
