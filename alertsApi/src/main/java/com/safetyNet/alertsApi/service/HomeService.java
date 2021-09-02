package com.safetyNet.alertsApi.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.safetyNet.alertsApi.model.Home;
import com.safetyNet.alertsApi.repository.HomeDAO;

@Service
public class HomeService {
	private final HomeDAO homeDao;

	public HomeService(HomeDAO homeDao) {
		super();
		this.homeDao = homeDao;
	}
	
	public ArrayList<String> getAddressList() {
		return homeDao.getAddressList();
	}
	
	public ArrayList<Home> getHomeList() {
		return homeDao.getHomeList();
	}
}