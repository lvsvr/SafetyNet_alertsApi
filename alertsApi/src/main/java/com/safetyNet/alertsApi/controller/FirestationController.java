package com.safetyNet.alertsApi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
}
