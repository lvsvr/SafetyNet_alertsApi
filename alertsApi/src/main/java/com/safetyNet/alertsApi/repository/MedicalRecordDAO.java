package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;

import com.safetyNet.alertsApi.model.MedicalRecord;

public interface MedicalRecordDAO {

	ArrayList<MedicalRecord> getAllMedicalRecords();
	
	int insertMedicalRecord(MedicalRecord medicalRecord);
}
