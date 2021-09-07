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
import com.safetyNet.alertsApi.service.CommunityEmailService;

@RequestMapping("/communityEmail")
@RestController
public class CommunityEmailController {
	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);
	private final CommunityEmailService communityEmailService;

	@Autowired
	public CommunityEmailController(CommunityEmailService communityEmailService) {
		super();
		this.communityEmailService = communityEmailService;
	}

	@GetMapping
	public Set<String> getEmailListByCity(@RequestParam(name = "city") String city) {
		logger.info("Get email list by city : " + city);
		for (String mail : communityEmailService.getEmailListByCity(city)) {
			logger.info(mail);
		}
		return communityEmailService.getEmailListByCity(city);
	}

}
