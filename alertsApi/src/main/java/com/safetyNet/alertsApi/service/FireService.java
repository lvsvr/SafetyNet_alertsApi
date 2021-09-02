package com.safetyNet.alertsApi.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.safetyNet.alertsApi.model.PersonForEmergencyCase;
import com.safetyNet.alertsApi.repository.FireDAO;

@Service
public class FireService {

	private final FireDAO fireDao;

	public FireService( FireDAO fireDao) {
		super();
		this.fireDao = fireDao;
	}

	public ArrayList<PersonForEmergencyCase> getPersonsListByAddress(String address) {
		return fireDao.getPersonsListByAddress(address);
	}

}
