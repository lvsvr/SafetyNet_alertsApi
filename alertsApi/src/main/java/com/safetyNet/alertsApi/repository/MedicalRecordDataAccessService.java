package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

import com.safetyNet.alertsApi.AlertsApiApplication;
import com.safetyNet.alertsApi.model.MedicalRecord;

@Repository
public class MedicalRecordDataAccessService implements MedicalRecordDAO{
	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);
	private static JsonReader jsonReader = new JsonReader();
	private static ArrayList<MedicalRecord> medicalRecords;
	
	public MedicalRecordDataAccessService() {
		super();
		JSONObject dataJsonObject = jsonReader.readDataFromJsonFile();
		medicalRecords = jsonReader.getMedicalRecordsFromJson(dataJsonObject);
	}

	@Override
	public ArrayList<MedicalRecord> getAllMedicalRecords() {
		// TODO Auto-generated method stub
		return medicalRecords;
	}
	
	
}
