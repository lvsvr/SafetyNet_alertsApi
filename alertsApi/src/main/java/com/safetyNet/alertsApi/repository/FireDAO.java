package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;

import com.safetyNet.alertsApi.model.PersonForFireCase;

public interface FireDAO {

	ArrayList<PersonForFireCase> getPersonsListByAdress(String address);

}
