package com.safetyNet.alertsApi.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.alertsApi.model.MedicalRecord;
import com.safetyNet.alertsApi.model.Person;
import com.safetyNet.alertsApi.repository.MedicalRecordDaoImpl;

@SpringBootTest
public class MedicalRecordServiceTest {
	
	@Mock
	private MedicalRecordDaoImpl medicalRecordDao;
	
	@Test
	public void shouldReturnAllMedicalRecords() {
		//WHEN
		MedicalRecordService medicalRecordService = new MedicalRecordService(medicalRecordDao);
		//THEN
		assertNotNull(medicalRecordService.getAllMedicalRecords());
	}

	@Test
	public void shouldinsertMedicalRecord() {
		//GIVEN
		MedicalRecordService medicalRecordService = new MedicalRecordService(medicalRecordDao);
		MedicalRecord mr = new MedicalRecord("John","AAAAA","07/14/1789",null, null);
		ArrayList<MedicalRecord>medicalRecords = medicalRecordService.getAllMedicalRecords();
		//WHEN
		medicalRecordService.insertMedicalRecord(mr);
		//THEN
		assertNotSame(medicalRecords, medicalRecordService.getAllMedicalRecords());
		
	}
	
	@Test
	public void shouldReturnMedicalRecordByNames() {
		//WHEN
		MedicalRecordService medicalRecordService = new MedicalRecordService(medicalRecordDao);
		//THEN
		assertNotNull(medicalRecordService.getMedicalRecordByNames("John", "Boyd"));
		
	}
	
	@Test
	public void shouldDeleteMedicalRecordByNames() {
		//GIVEN
		MedicalRecordService medicalRecordService = new MedicalRecordService(medicalRecordDao);
		ArrayList<MedicalRecord>medicalRecords = medicalRecordService.getAllMedicalRecords();
		//WHEN
		medicalRecordService.deleteMedicalRecordByNames("John", "Boyd");
		//THEN
		assertNotSame(medicalRecords, medicalRecordService.getAllMedicalRecords());
		
	}
	
	@Test
	public void shouldUpdateMedicalRecordByNames() {
		//GIVEN
		MedicalRecordService medicalRecordService = new MedicalRecordService(medicalRecordDao);
		MedicalRecord mr = new MedicalRecord("gin","rogers","07/14/1789",null, null);
		//WHEN
		medicalRecordService.updateMedicalRecordByNames("John", "Boyd", mr);
		//THEN
		assertNotNull(medicalRecordService.getMedicalRecordByNames("gin", "rogers"));
		
	}
}
