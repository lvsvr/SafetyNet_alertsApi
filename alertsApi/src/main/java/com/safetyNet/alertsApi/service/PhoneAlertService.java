package com.safetyNet.alertsApi.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.safetyNet.alertsApi.repository.PhoneAlertDAO;

@Service
public class PhoneAlertService {
	
	private final PhoneAlertDAO phoneAlertDao;

	@Autowired
	public PhoneAlertService(@Qualifier("PhoneAlertDao")PhoneAlertDAO phoneAlertDao) {
		super();
		this.phoneAlertDao = phoneAlertDao;
	}

	public Set<String> getPhonesByFirestationNumbers(String firestationNumber) {
		return phoneAlertDao.getPhonesByFirestationNumbers(firestationNumber);
	}
	
}
