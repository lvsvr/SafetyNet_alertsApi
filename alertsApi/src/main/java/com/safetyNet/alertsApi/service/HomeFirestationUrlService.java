package com.safetyNet.alertsApi.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.safetyNet.alertsApi.repository.HomeFirestationUrlDAO;

@Service
public class HomeFirestationUrlService {

	private final HomeFirestationUrlDAO homeFirestationUrlDao;

	public HomeFirestationUrlService(HomeFirestationUrlDAO homeFirestationUrlDao) {
		super();
		this.homeFirestationUrlDao = homeFirestationUrlDao;
	}
	public ArrayList<String> getListOfPersonsByFirestationNumber(String firestationNumber){
		return homeFirestationUrlDao.getListOfPersonsByFirestationNumber(firestationNumber);
	}
}
