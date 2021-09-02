package com.safetyNet.alertsApi.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.safetyNet.alertsApi.repository.PhoneAlertDAO;

@Service
public class PhoneAlertService {
	
	private final PhoneAlertDAO phoneAlertDao;

	public PhoneAlertService(PhoneAlertDAO phoneAlertDao) {
		super();
		this.phoneAlertDao = phoneAlertDao;
	}

	public Set<String> getPhonesByFirestationNumbers(String firestationNumber) {
		return phoneAlertDao.getPhonesByFirestationNumbers(firestationNumber);
	}
	
}
