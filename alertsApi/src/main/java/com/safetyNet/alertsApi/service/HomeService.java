package com.safetyNet.alertsApi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.safetyNet.alertsApi.model.Home;
import com.safetyNet.alertsApi.repository.HomeDAO;

@Service
public class HomeService {
	private final HomeDAO homeDao;

	@Autowired
	public HomeService(@Qualifier("homeDao")HomeDAO homeDao) {
		super();
		this.homeDao = homeDao;
	}
	
	public ArrayList<String> getAddressList() {
		return homeDao.getAddressList();
	}
	
	public ArrayList<Home> getHomeList() {
		return homeDao.getHomeList();
	}
	
	public ArrayList<String> getListOfPersonsByFirestationNumber(String firestationNumber){
		return homeDao.getListOfPersonsByFirestationNumber(firestationNumber);
	}
}