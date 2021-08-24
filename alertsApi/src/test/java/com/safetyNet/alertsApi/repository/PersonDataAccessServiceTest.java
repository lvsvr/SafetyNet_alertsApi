package com.safetyNet.alertsApi.repository;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.alertsApi.model.Person;
import com.safetyNet.alertsApi.repository.JsonReader;

@SpringBootTest
public class PersonDataAccessServiceTest {
	
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

}
