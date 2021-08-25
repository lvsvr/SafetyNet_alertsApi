package com.safetyNet.alertsApi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetyNet.alertsApi.model.Home;
import com.safetyNet.alertsApi.service.HomeService;

@RequestMapping("/home")
@RestController
public class HomeController {
	private final HomeService homeService;

	@Autowired
	public HomeController(HomeService homeService) {
		super();
		this.homeService = homeService;
	}

	@GetMapping
	public ArrayList<Home> getHomeList() {
		return homeService.getHomeList();
	}
}


