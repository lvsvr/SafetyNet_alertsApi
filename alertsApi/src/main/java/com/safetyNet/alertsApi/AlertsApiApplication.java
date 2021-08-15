package com.safetyNet.alertsApi;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.safetyNet.alertsApi.model.Person;
import com.safetyNet.alertsApi.repository.JsonReader;


@SpringBootApplication
public class AlertsApiApplication {

	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);
	static JsonReader jsonReader = new JsonReader();
	static JSONObject dataJsonObject;
	static ArrayList<Person> persons;
	
	public static void main(String[] args) {
		SpringApplication.run(AlertsApiApplication.class, args);
		logger.info("app inititialized");
		dataJsonObject = jsonReader.readDataFromJsonFile();
		//logger.info(dataJsonObject);
		persons = jsonReader.getPersonsFromJson(dataJsonObject);
		
	}
	
}
