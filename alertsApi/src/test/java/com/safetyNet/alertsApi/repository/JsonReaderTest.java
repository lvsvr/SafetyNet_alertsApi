package com.safetyNet.alertsApi.repository;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.alertsApi.model.Firestation;
import com.safetyNet.alertsApi.model.MedicalRecord;
import com.safetyNet.alertsApi.model.Person;
import com.safetyNet.alertsApi.repository.JsonReader;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@SpringBootTest
public class JsonReaderTest {
	
	@Test
	public void shouldFindJsonFile() throws IOException, ParseException {
		//GIVEN - WHEN
		FileReader fileReader = new FileReader("src/main/resources/data.json");
		//THEN
		assertNotNull(fileReader);
	}
	
	@Test
	public void shouldParseJsonFile() throws IOException, ParseException {
		//GIVEN
		JSONParser jsonParser = new JSONParser();
		FileReader fileReader = new FileReader("src/main/resources/data.json");
		//WHEN
		Object object = jsonParser.parse(fileReader);
		//THEN
		assertNotNull(object);
	}

	@Test
	public void shouldReadDataFromJsonFile() {
		//GIVEN
		JSONObject dataJsonObject =null;
		JsonReader jsonReader = new JsonReader();
		//WHEN
		dataJsonObject = jsonReader.readDataFromJsonFile();
		//THEN
		assertNotNull(dataJsonObject);
	}


	@Test
	public void ShouldGetPersonsFromJson() {
		//GIVEN
		ArrayList<Person> persons = new ArrayList<Person>();
		JSONObject dataJsonObject =null;
		JsonReader jsonReader = new JsonReader();
		dataJsonObject = jsonReader.readDataFromJsonFile();
		//WHEN
		persons = jsonReader.getPersonsFromJson(dataJsonObject);
		//THEN
		assertNotNull(persons);
	}
	
	@Test
	public void ShouldGetFirestationsFromJson() {
		//GIVEN
		ArrayList<Firestation> firestations = new ArrayList<Firestation>();
		JSONObject dataJsonObject =null;
		JsonReader jsonReader = new JsonReader();
		dataJsonObject = jsonReader.readDataFromJsonFile();
		//WHEN
		firestations = jsonReader.getFirestationsFromJson(dataJsonObject);
		//THEN
		assertNotNull(firestations);
	}
	
	@Test
	public void ShouldGetMedicalRecordsFromJson() {
		//GIVEN
		ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
		JSONObject dataJsonObject =null;
		JsonReader jsonReader = new JsonReader();
		dataJsonObject = jsonReader.readDataFromJsonFile();
		//WHEN
		medicalRecords = jsonReader.getMedicalRecordsFromJson(dataJsonObject);
		//THEN
		assertNotNull(medicalRecords);
	}
}