package com.safetyNet.alertsApi;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.alertsApi.model.Person;
import com.safetyNet.alertsApi.model.Firestation;
import com.safetyNet.alertsApi.model.MedicalRecord;
import com.safetyNet.alertsApi.repository.JsonReader;
import static org.junit.Assert.*;

@SpringBootTest
class AlertsApiApplicationTests {

	@Test
	void contextLoads() {
	}
	
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
	public void shouldLoadPersonsArrayList() {
		//GIVEN
		JsonReader jsonReader = new JsonReader();
		JSONObject dataJsonObject = jsonReader.readDataFromJsonFile();
		ArrayList<Person> persons;
		//WHEN
		persons = jsonReader.getPersonsFromJson(dataJsonObject);
		//THEN
		assertNotNull(persons);
	}
	
	@Test
	public void shouldLoadFirestationArrayList() {
		//GIVEN
		JsonReader jsonReader = new JsonReader();
		JSONObject dataJsonObject = jsonReader.readDataFromJsonFile();
		ArrayList<Firestation> firestations;
		//WHEN
		firestations = jsonReader.getFirestationsFromJson(dataJsonObject);
		//THEN
		assertNotNull(firestations);
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
