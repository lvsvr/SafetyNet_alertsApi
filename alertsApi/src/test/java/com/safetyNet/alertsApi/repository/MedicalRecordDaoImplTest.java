package com.safetyNet.alertsApi.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.alertsApi.model.Firestation;
import com.safetyNet.alertsApi.model.JsonReader;
import com.safetyNet.alertsApi.model.MedicalRecord;
import com.safetyNet.alertsApi.model.Person;

@SpringBootTest
public class MedicalRecordDaoImplTest {
	
	@Test
	public void shouldLoadDataJsonObject() {
		//GIVEN
		JsonReader jsonReader = new JsonReader();
		//WHEN
		JSONObject dataJsonObject = jsonReader.readDataFromJsonFile();
		//THEN
		assertNotNull(dataJsonObject);
	}
	
	@Test
	public void shouldLoadMedicalRecordsArrayList() {
		//GIVEN
		JsonReader jsonReader = new JsonReader();
		JSONObject dataJsonObject = jsonReader.readDataFromJsonFile();
		ArrayList<MedicalRecord> medicalRecords;
		//WHEN
		medicalRecords = jsonReader.getMedicalRecordsFromJson(dataJsonObject);
		//THEN
		assertNotNull(medicalRecords);
	}
	
	@Test
	public void shouldReturnAllMedicalRecords() {
		//GIVEN WHEN
		MedicalRecordDaoImpl medicalRecordDao = new MedicalRecordDaoImpl();
		//THEN
		assertNotNull(medicalRecordDao.getAllMedicalRecords());
		
	}
	
	@Test
	public void shouldInsertMedicalRecord() {
		//GIVEN
		MedicalRecordDaoImpl medicalRecordDao = new MedicalRecordDaoImpl();
		MedicalRecord mr = new MedicalRecord();
		mr.setFirstName("gin");
		mr.setLastName("rogers");
		//WHEN
		medicalRecordDao.insertMedicalRecord(mr);
		//THEN
		assertNotNull(medicalRecordDao.getMedicalRecordByNames("gin", "rogers"));
		
	}
	
	@Test
	public void shouldUpdateMedicalRecordByNames() {
		//GIVEN
		MedicalRecordDaoImpl medicalRecordDao = new MedicalRecordDaoImpl();
		MedicalRecord mr = new MedicalRecord();
		mr.setFirstName("gin");
		mr.setLastName("rogers");
		medicalRecordDao.insertMedicalRecord(mr);
		MedicalRecordDaoImpl medicalRecordDao2 = medicalRecordDao;
		String firstName = "ginger";
		//WHEN
		medicalRecordDao.updateMedicalRecordByNames(firstName,mr.getLastName(), mr);
		//THEN
		assertNotSame(medicalRecordDao2.getMedicalRecordByNames(mr.getFirstName(), mr.getLastName()), medicalRecordDao.getMedicalRecordByNames(mr.getFirstName(), mr.getLastName()));
		
		
	}
	
	@Test
	public void shouldDeleteMedicalRecordByNames() {
		//GIVEN
		MedicalRecordDaoImpl medicalRecordDao = new MedicalRecordDaoImpl();
		
		MedicalRecord mr = new MedicalRecord();
		mr.setFirstName("gin");
		mr.setLastName("rogers");
		medicalRecordDao.insertMedicalRecord(mr);
		//WHEN
		medicalRecordDao.deleteMedicalRecordByNames(mr.getFirstName(),mr.getLastName());
		//THEN
		assertNotSame(medicalRecordDao.getMedicalRecordByNames(mr.getFirstName(),mr.getLastName()), mr);
		
	}
}
