package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;

import com.safetyNet.alertsApi.model.Home;
import com.safetyNet.alertsApi.model.MedicalRecord;
import com.safetyNet.alertsApi.model.Person;

public interface HomeDAO {

	ArrayList<String> getAddressList();

	ArrayList<Home> createHomeListByAddress(ArrayList<String> addressList);

	int insertFirestations(ArrayList<Home> homes);

	int insertPersons(ArrayList<Home> homes);

	int insertMedicalRecords(ArrayList<Home> homes);

	ArrayList<Home> getHomeList();
	

	ArrayList<Person> getPersonsByFirestationNumber(String firestationNumber);

	ArrayList<String> arrangeListOfPersonByFirestationNumber(ArrayList<Person> persons);

	ArrayList<MedicalRecord> getMedicalRecordsByFirestationsByNumber(String firestationNumber);
	
	String getChildAndAdultNumbers(ArrayList<MedicalRecord> medicalRecords);
	
	ArrayList<String> getListOfPersonsByFirestationNumber(String firestationNumber);

	ArrayList<Home> getHomeByFirestationNumber(String firestationNumber);
}