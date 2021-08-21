package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

import com.safetyNet.alertsApi.AlertsApiApplication;
import com.safetyNet.alertsApi.model.MedicalRecord;

@Repository("medicalRecordDao")
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

	@Override
	public int insertMedicalRecord(MedicalRecord medicalRecord) {
		medicalRecords.add(new MedicalRecord(medicalRecord.getFirstName(), medicalRecord.getLastName(), medicalRecord.getBirthDate(), medicalRecord.getMedications(), medicalRecord.getAllergies()));
		return 1;
	}

	@Override
	public Optional<MedicalRecord> getMedicalRecordByNames(String firstName, String lastName) {
		MedicalRecord namedMedicalRecord = new MedicalRecord();
		for(MedicalRecord medicalRecord : medicalRecords) {
			if(medicalRecord.getFirstName().equals(firstName) && medicalRecord.getLastName().equals(lastName))
				namedMedicalRecord = medicalRecord;
		}
		return Optional.of(namedMedicalRecord);
	}

	@Override
	public int updateMedicalRecordByNames(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleMedicalRecordByNames(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
