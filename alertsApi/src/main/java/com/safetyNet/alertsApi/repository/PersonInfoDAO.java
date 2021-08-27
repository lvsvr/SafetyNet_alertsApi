package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;

import com.safetyNet.alertsApi.model.PersonInfo;

public interface PersonInfoDAO {
	
	ArrayList<PersonInfo> getPersonInfoByFirstNameAndLastName(String firstName, String lastName);

}
