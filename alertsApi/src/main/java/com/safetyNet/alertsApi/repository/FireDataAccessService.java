package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.safetyNet.alertsApi.AlertsApiApplication;
import com.safetyNet.alertsApi.model.AgeCalculator;
import com.safetyNet.alertsApi.model.Home;
import com.safetyNet.alertsApi.model.MedicalRecord;
import com.safetyNet.alertsApi.model.Person;
import com.safetyNet.alertsApi.model.PersonForEmergencyCase;

@Repository("firesDao")
public class FireDataAccessService implements FireDAO {

	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);
	private HomeDataAccessService homeDataAccessService;

	public FireDataAccessService(HomeDataAccessService homeDataAccessService) {
		super();
		this.homeDataAccessService = homeDataAccessService;
	}

	@Override
	public ArrayList<PersonForEmergencyCase> getPersonsListByAddress(String address) {
		return homeDataAccessService.getPersonsListByAddress(address);
	}

}
