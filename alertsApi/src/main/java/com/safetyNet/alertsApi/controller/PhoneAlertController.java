package com.safetyNet.alertsApi.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNet.alertsApi.service.PhoneAlertService;

@RequestMapping("/phoneAlert")
@RestController
public class PhoneAlertController {

	private final PhoneAlertService phoneAlertService;

	@Autowired
	public PhoneAlertController(PhoneAlertService phoneAlertService) {
		super();
		this.phoneAlertService = phoneAlertService;
	}

	@GetMapping
	public Set<String> getPhonesByFirestationNumbers(
			@RequestParam(value = "firestation") String firestationNumber) {
		return phoneAlertService.getPhonesByFirestationNumbers(firestationNumber);
	}

}
