package com.safetyNet.alertsApi.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNet.alertsApi.model.PersonForFireCase;
import com.safetyNet.alertsApi.service.FireService;

@RequestMapping("/fire")
@RestController
public class FireController {

	private final FireService fireService;

	public FireController(FireService fireService) {
		super();
		this.fireService = fireService;
	}

	@GetMapping
	public ArrayList<PersonForFireCase> getPersonsListByAdress(@RequestParam(value = "address") String address) {
		address = address.replaceAll("_", " ");
		return fireService.getPersonsListByAdress(address);
	}

}
