package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;

import com.safetyNet.alertsApi.model.Home;
import com.safetyNet.alertsApi.model.MedicalRecord;
import com.safetyNet.alertsApi.model.Person;

public interface HomeFirestationUrlDAO {


	ArrayList<Person> getPersonsByFirestationNumber(String firestationNumber);

	ArrayList<String> arrangeListOfPersonByFirestationNumber(ArrayList<Person> persons);

	ArrayList<MedicalRecord> getMedicalRecordsByFirestationsByNumber(String firestationNumber);
	
	String getChildAndAdultNumbers(ArrayList<MedicalRecord> medicalRecords);
	
	ArrayList<String> getListOfPersonsByFirestationNumber(String firestationNumber);

	ArrayList<Home> getHomeByFirestationNumber(String firestationNumber);
}
