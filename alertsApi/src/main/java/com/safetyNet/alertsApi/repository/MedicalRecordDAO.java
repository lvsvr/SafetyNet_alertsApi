package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;
import java.util.Optional;

import com.safetyNet.alertsApi.model.MedicalRecord;

public interface MedicalRecordDAO {

	ArrayList<MedicalRecord> getAllMedicalRecords();

	Optional<MedicalRecord> getMedicalRecordByNames(String firstName, String lastName);

	int insertMedicalRecord(MedicalRecord medicalRecord);

	int updateMedicalRecordByNames(String firstName, String lastName, MedicalRecord updatedMedicalRecord);

	int deleteMedicalRecordByNames(String firstName, String lastName);

}
