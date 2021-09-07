package com.safetyNet.alertsApi.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.safetyNet.alertsApi.repository.MedicalRecordDAO;
import com.safetyNet.alertsApi.model.MedicalRecord;

@Service
public class MedicalRecordService {

	private final MedicalRecordDAO medicalRecordDao;

	public MedicalRecordService(MedicalRecordDAO medicalRecordDao) {
		super();
		this.medicalRecordDao = medicalRecordDao;
	}

	public ArrayList<MedicalRecord> getAllMedicalRecords() {
		return medicalRecordDao.getAllMedicalRecords();
	}

	public int insertMedicalRecord(MedicalRecord medicalRecord) {

		return medicalRecordDao.insertMedicalRecord(medicalRecord);
	}

	public MedicalRecord getMedicalRecordByNames(String firstName, String lastName) {
		return medicalRecordDao.getMedicalRecordByNames(firstName, lastName);
	}

	public int deleteMedicalRecordByNames(String firstName, String lastName) {
		return medicalRecordDao.deleteMedicalRecordByNames(firstName, firstName);
	}

	public int updateMedicalRecordByNames(String firstName, String lastName, MedicalRecord updatedMedicalRecord) {
		return medicalRecordDao.updateMedicalRecordByNames(firstName, lastName, updatedMedicalRecord);
	}
}
