package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetyNet.alertsApi.AlertsApiApplication;
import com.safetyNet.alertsApi.model.Person;

@Repository
public class PhoneAlertDaoImpl implements PhoneAlertDAO{
	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);
	private HomeFirestationUrlDAO homeFirestationUrlDao;
	
	@Autowired
	public PhoneAlertDaoImpl(HomeFirestationUrlDAO homeFirestationUrlDao) {
		super();
		this.homeFirestationUrlDao = homeFirestationUrlDao;
	}

	public PhoneAlertDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<String> getPhonesByFirestationNumbers(String firestationNumber) {
		ArrayList<Person> persons = homeFirestationUrlDao.getPersonsByFirestationNumber(firestationNumber);
		Set<String> phones = new HashSet<String>();	
			for(Person person : persons) {
				phones.add(person.getPhone());
			}
		return phones;
	}
	
	
}
