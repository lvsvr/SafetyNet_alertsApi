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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNet.alertsApi.model.Firestation;
import com.safetyNet.alertsApi.service.FirestationService;
import com.safetyNet.alertsApi.service.HomeFirestationUrlService;
import com.safetyNet.alertsApi.service.HomeService;

@RequestMapping("/firestation")
@RestController
public class FirestationController {

	private final FirestationService firestationService;
	private final HomeService homeService;
	private final HomeFirestationUrlService homeFirestationUrlService;

	@Autowired
	public FirestationController(FirestationService firestationService, HomeService homeService, HomeFirestationUrlService homeFirestationUrlService) {
		super();
		this.firestationService = firestationService;
		this.homeService = homeService;
		this.homeFirestationUrlService = homeFirestationUrlService;
	}

//	@GetMapping
//	public ArrayList<Firestation> getAllFirestations() {
//		return firestationService.getAllFirestations();
//	}

	@PostMapping
	public void insertFirestation(@RequestBody Firestation firestation) {
		firestationService.insertFirestation(firestation);
	}

	@GetMapping(path = "{address}")
	public Optional<Firestation> getFirestation(@PathVariable String address) {
		address = address.replaceAll("_", " ");
		return firestationService.getFirestationByAddress(address);
	}

	@DeleteMapping(path = "{address}")
	public void deleteFirestationByAddress(@PathVariable String address) {
		address = address.replaceAll("_", " ");
		firestationService.deleteFirestationByAddress(address);
	}

	@PutMapping(path = "{address}")
	public void updateFirestationByAddress(@PathVariable String address, @RequestBody Firestation updatedFirestation) {
		address = address.replaceAll("_", " ");
		firestationService.updateFirestationByAddress(address, updatedFirestation);
	}
	
	@GetMapping
	public ArrayList<String> getListOfPersonsByFirestationNumber(@RequestParam(value="stationNumber")String firestationNumber){
		return homeFirestationUrlService.getListOfPersonsByFirestationNumber(firestationNumber);
	}
}
