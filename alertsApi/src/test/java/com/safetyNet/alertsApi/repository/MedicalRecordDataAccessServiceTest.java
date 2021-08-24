package com.safetyNet.alertsApi.repository;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.alertsApi.model.MedicalRecord;
import com.safetyNet.alertsApi.repository.JsonReader;

@SpringBootTest
public class MedicalRecordDataAccessServiceTest {
	
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

}
