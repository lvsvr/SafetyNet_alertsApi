package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

import com.safetyNet.alertsApi.AlertsApiApplication;
import com.safetyNet.alertsApi.model.Person;

@Repository
public class PersonDataAccessService {
	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);
	private static JsonReader jsonReader = new JsonReader();
	private static ArrayList<Person> persons;
	
	public PersonDataAccessService() {
		super();
		JSONObject dataJsonObject = jsonReader.readDataFromJsonFile();
		persons = jsonReader.getPersonsFromJson(dataJsonObject);
		
	}

	//public ArrayList<Person> getPersonsArrayListFromJson(){
		
	//return persons;
	
	//}
}
