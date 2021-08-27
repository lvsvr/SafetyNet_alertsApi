package com.safetyNet.alertsApi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.safetyNet.alertsApi.model.PersonForEmergencyCase;
import com.safetyNet.alertsApi.repository.FireDAO;

@Service
public class FireService {

	private final FireDAO fireDao;

	@Autowired
	public FireService(@Qualifier("firesDao") FireDAO fireDao) {
		super();
		this.fireDao = fireDao;
	}

	public ArrayList<PersonForEmergencyCase> getPersonsListByAddress(String address) {
		return fireDao.getPersonsListByAddress(address);
	}

}
