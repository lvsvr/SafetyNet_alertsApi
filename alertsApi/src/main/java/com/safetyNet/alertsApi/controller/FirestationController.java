package com.safetyNet.alertsApi.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNet.alertsApi.AlertsApiApplication;
import com.safetyNet.alertsApi.model.Firestation;
import com.safetyNet.alertsApi.service.FirestationService;
import com.safetyNet.alertsApi.service.HomeFirestationUrlService;

@RequestMapping("/firestation")
@RestController
public class FirestationController {
	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);
	private final FirestationService firestationService;
	private final HomeFirestationUrlService homeFirestationUrlService;

	@Autowired
	public FirestationController(FirestationService firestationService, HomeFirestationUrlService homeFirestationUrlService) {
		super();
		this.firestationService = firestationService;
		this.homeFirestationUrlService = homeFirestationUrlService;
	}

//	@GetMapping
//	public ArrayList<Firestation> getAllFirestations() {
//		return firestationService.getAllFirestations();
//	}

	@PostMapping
	public void insertFirestation(@RequestBody Firestation firestation) {
		logger.info("Insert firestation : " + firestation.getAddress()+" "+ firestation.getStation());
		firestationService.insertFirestation(firestation);
	}

	@GetMapping(path = "{address}")
	public Firestation getFirestation(@PathVariable String address) {
		address = address.replaceAll("_", " ");
		Firestation firestation = firestationService.getFirestationByAddress(address);
		logger.info("Get firestation by address : "+ address+" "+firestation.getStation());
		return firestationService.getFirestationByAddress(address);
	}

	@DeleteMapping(path = "{address}")
	public void deleteFirestationByAddress(@PathVariable String address) {
		address = address.replaceAll("_", " ");
		logger.info("Delete firestation by address: " + address);
		firestationService.deleteFirestationByAddress(address);
	}

	@PutMapping(path = "{address}")
	public void updateFirestationByAddress(@PathVariable String address, @RequestBody Firestation updatedFirestation) {
		address = address.replaceAll("_", " ");
		logger.info("Update firestation by address: " + address +" "+updatedFirestation.getStation());
		firestationService.updateFirestationByAddress(address, updatedFirestation);
	}
	
	@GetMapping
	public ArrayList<String> getListOfPersonsByFirestationNumber(@RequestParam(value="stationNumber")String firestationNumber){
		ArrayList<String> persons = homeFirestationUrlService.getListOfPersonsByFirestationNumber(firestationNumber);
		logger.info("Get list of persons by firestation number: "+ firestationNumber);
		for(String person :persons) {
			logger.info(person);
		}
		return homeFirestationUrlService.getListOfPersonsByFirestationNumber(firestationNumber);
	}
}
