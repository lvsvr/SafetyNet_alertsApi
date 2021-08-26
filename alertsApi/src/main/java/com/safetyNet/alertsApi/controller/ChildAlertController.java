package com.safetyNet.alertsApi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNet.alertsApi.service.ChildAlertService;

@RequestMapping("/childAlert")
@RestController
public class ChildAlertController {
	
	private final ChildAlertService childAlertService;

	@Autowired
	public ChildAlertController(ChildAlertService childAlertService) {
		super();
		this.childAlertService = childAlertService;
	}
	
	@GetMapping
	public ArrayList<String> getChildListByAddress(@RequestParam(value="address")String address){
		address = address.replaceAll("_", " ");
		return childAlertService.getChildListByAddress(address); 
	}
}
