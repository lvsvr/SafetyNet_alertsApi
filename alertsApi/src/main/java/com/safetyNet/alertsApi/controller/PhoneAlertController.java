package com.safetyNet.alertsApi.controller;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNet.alertsApi.AlertsApiApplication;
import com.safetyNet.alertsApi.service.PhoneAlertService;

@RequestMapping("/phoneAlert")
@RestController
public class PhoneAlertController {
	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);
	private final PhoneAlertService phoneAlertService;

	@Autowired
	public PhoneAlertController(PhoneAlertService phoneAlertService) {
		super();
		this.phoneAlertService = phoneAlertService;
	}

	@GetMapping
	public Set<String> getPhonesByFirestationNumbers(
			@RequestParam(value = "firestation") String firestationNumber) {
		logger.info("Get phones by firestations' number: " + firestationNumber + " " + phoneAlertService.getPhonesByFirestationNumbers(firestationNumber));
		return phoneAlertService.getPhonesByFirestationNumbers(firestationNumber);
	}

}
