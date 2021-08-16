package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

import com.safetyNet.alertsApi.AlertsApiApplication;
import com.safetyNet.alertsApi.model.Firestation;

@Repository
public class FirestationDataAccessService {
	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);
	private static JsonReader jsonReader = new JsonReader();
	private static ArrayList<Firestation> firestations;
	
	public FirestationDataAccessService(){
		super();
		JSONObject dataJsonObject = jsonReader.readDataFromJsonFile();
		firestations = jsonReader.getFirestationsFromJson(dataJsonObject);
		
	}
}
