package com.safetyNet.alertsApi.controller;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNet.alertsApi.AlertsApiApplication;
import com.safetyNet.alertsApi.model.PersonForEmergencyCase;
import com.safetyNet.alertsApi.service.FireService;

@RequestMapping("/fire")
@RestController
public class FireController {
	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);
	private final FireService fireService;

	public FireController(FireService fireService) {
		super();
		this.fireService = fireService;
	}

	@GetMapping
	public ArrayList<PersonForEmergencyCase> getPersonsListByAddress(@RequestParam(value = "address") String address) {
		address = address.replaceAll("_", " ");
		logger.info("Get person list by address : "+ address);
		for(PersonForEmergencyCase pfec : fireService.getPersonsListByAddress(address)) {
			logger.info(pfec.getAddress()+" "+pfec.getFirestation()+" "+pfec.getFirstName()+" "+pfec.getLastName()+" "+pfec.getAge()+" "+pfec.getPhone()+" "+ pfec.getMedications(), pfec.getAllergies());
		}
		return fireService.getPersonsListByAddress(address);
	}

}
