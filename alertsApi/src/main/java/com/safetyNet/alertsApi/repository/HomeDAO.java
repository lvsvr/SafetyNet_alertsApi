package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;

import com.safetyNet.alertsApi.model.Home;

public interface HomeDAO {

	ArrayList<String> getAddressList();

	ArrayList<Home> createHomeListByAddress(ArrayList<String> addressList);

	int insertFirestations(ArrayList<Home> homes);

	int insertPersons(ArrayList<Home> homes);

	int insertMedicalRecords(ArrayList<Home> homes);

	ArrayList<Home> getHomeList();
	
	Home getHomeByAddress(String address);
	
}