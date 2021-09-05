package com.safetyNet.alertsApi.controller;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNet.alertsApi.AlertsApiApplication;
import com.safetyNet.alertsApi.service.ChildAlertService;

@RequestMapping("/childAlert")
@RestController
public class ChildAlertController {
	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);
	private final ChildAlertService childAlertService;

	@Autowired
	public ChildAlertController(ChildAlertService childAlertService) {
		super();
		this.childAlertService = childAlertService;
	}
	
	@GetMapping
	public ArrayList<String> getChildListByAddress(@RequestParam(value="address")String address){
		address = address.replaceAll("_", " ");
		logger.info("Get child list byy address : ", childAlertService.getChildListByAddress(address));
		return childAlertService.getChildListByAddress(address); 
	}
}
