package com.safetyNet.alertsApi.controller;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNet.alertsApi.service.CommunityEmailService;

@RequestMapping("/communityEmail")
@RestController
public class CommunityEmailController {
	
	private final CommunityEmailService communityEmailService;

	@Autowired
	public CommunityEmailController(CommunityEmailService communityEmailService) {
		super();
		this.communityEmailService = communityEmailService;
	}
	
	@GetMapping
	public Set<String> getEmailListByCitygetPersonsListByAddress(@RequestParam(name = "city")String city){
		return communityEmailService.getEmailListByCity(city);
	}

}
