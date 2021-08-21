package com.safetyNet.alertsApi.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNet.alertsApi.model.Firestation;
import com.safetyNet.alertsApi.service.FirestationService;

@RequestMapping("/firestation")
@RestController
public class FirestationController {

	private final FirestationService firestationService;
	
	@Autowired
	public FirestationController(FirestationService firestationService) {
		super();
		this.firestationService = firestationService;
	}
	
	@GetMapping
	public ArrayList<Firestation> getAllFirestations(){
		return firestationService.getAllFirestations();
	}
	
	@PostMapping
	public void insertFirestation(@RequestBody Firestation firestation) {
		firestationService.insertFirestation(firestation);
	}
	
	@GetMapping(path= "{address}")
	public Optional<Firestation>getFirestation(@PathVariable String address){
		address = address.replaceAll("_"," ");
		return firestationService.getFirestationByAddress(address);
	}
}
