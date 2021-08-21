package com.safetyNet.alertsApi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.safetyNet.alertsApi.repository.MedicalRecordDAO;
import com.safetyNet.alertsApi.model.MedicalRecord;

@Service
public class MedicalRecordService {

	private final MedicalRecordDAO medicalRecordDao;

	@Autowired
	public MedicalRecordService(@Qualifier("medicalRecordDao")MedicalRecordDAO medicalRecordDao) {
		super();
		this.medicalRecordDao = medicalRecordDao;
	}
	
	public ArrayList<MedicalRecord> getAllMedicalRecords(){
		return medicalRecordDao.getAllMedicalRecords();
	}
	
	public int insertMedicalRecord(MedicalRecord medicalRecord) {
		
		return medicalRecordDao.insertMedicalRecord(medicalRecord);
	}
	
	}

