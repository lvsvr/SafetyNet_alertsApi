package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;

import com.safetyNet.alertsApi.model.PersonForEmergencyCase;

public interface FireDAO {

	ArrayList<PersonForEmergencyCase> getPersonsListByAddress(String address);

}
