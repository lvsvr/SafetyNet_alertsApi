package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

import com.safetyNet.alertsApi.AlertsApiApplication;
import com.safetyNet.alertsApi.model.JsonReader;
import com.safetyNet.alertsApi.model.MedicalRecord;

@Repository
public class MedicalRecordDaoImpl implements MedicalRecordDAO {
	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);
	private static JsonReader jsonReader = new JsonReader();
	private static ArrayList<MedicalRecord> medicalRecords;

	public MedicalRecordDaoImpl() {
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
		medicalRecords.add(new MedicalRecord(medicalRecord.getFirstName(), medicalRecord.getLastName(),
				medicalRecord.getBirthDate(), medicalRecord.getMedications(), medicalRecord.getAllergies()));
		return 1;
	}

	@Override
	public Optional<MedicalRecord> getMedicalRecordByNames(String firstName, String lastName) {
		MedicalRecord namedMedicalRecord = new MedicalRecord();
		for (MedicalRecord medicalRecord : medicalRecords) {
			if (medicalRecord.getFirstName().equals(firstName) && medicalRecord.getLastName().equals(lastName))
				namedMedicalRecord = medicalRecord;
		}
		return Optional.of(namedMedicalRecord);
	}

	@Override
	public int updateMedicalRecordByNames(String firstName, String lastName, MedicalRecord updatedMedicalRecord) {
		Optional<MedicalRecord> medicalRecordToUpdate = getMedicalRecordByNames(firstName, lastName);
		if (medicalRecordToUpdate == null) {
			return 0;
		}
		ArrayList<MedicalRecord> medicalRecordsMemo = new ArrayList<MedicalRecord>();
		for (MedicalRecord medicalRecord : medicalRecords) {
			if (!(medicalRecord.getFirstName().equals(firstName) && medicalRecord.getLastName().equals(lastName))) {
				medicalRecordsMemo.add(medicalRecord);
			} else if (medicalRecord.getFirstName().equals(firstName) && medicalRecord.getLastName().equals(lastName)) {
				medicalRecordsMemo.add(updatedMedicalRecord);
			}
		}
		medicalRecords = medicalRecordsMemo;
		return 1;
	}

	@Override
	public int deleteMedicalRecordByNames(String firstName, String lastName) {
		Optional<MedicalRecord> medicalRecordToDelete = getMedicalRecordByNames(firstName, lastName);
		if (medicalRecordToDelete == null) {
			return 0;
		}
		ArrayList<MedicalRecord> medicalRecordsMemo = new ArrayList<MedicalRecord>();
		for (MedicalRecord medicalRecord : medicalRecords) {
			if (!(medicalRecord.getFirstName().equals(firstName) && medicalRecord.getLastName().equals(lastName))) {
				medicalRecordsMemo.add(medicalRecord);
			}
		}
		medicalRecords = medicalRecordsMemo;
		return 1;
	}
}
