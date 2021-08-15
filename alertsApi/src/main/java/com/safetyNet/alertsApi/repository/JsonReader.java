package com.safetyNet.alertsApi.repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.safetyNet.alertsApi.AlertsApiApplication;
import com.safetyNet.alertsApi.model.Person;

import lombok.Data;

@Data
public class JsonReader {
	
	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);
	
	public JSONObject readDataFromJsonFile(){
	
		JSONObject dataJsonObject =null;
		try {
		JSONParser jsonParser = new JSONParser();
		FileReader fileReader = new FileReader("src/main/resources/data.json");
		Object object = jsonParser.parse(fileReader);
		dataJsonObject = (JSONObject)object;
		
		}catch (FileNotFoundException e) {
		}catch (IOException e) {
		}catch (ParseException e){
		}
		logger.info("Json object"+ dataJsonObject);
		return dataJsonObject;
	}

	public ArrayList<Person> getPersonsFromJson(JSONObject dataJsonObject) {
		
		JSONArray jsonArray = (JSONArray) dataJsonObject.get("persons");
		ArrayList<Person> persons = new ArrayList<Person>();
		for(int i=0; i<jsonArray.size(); i++) {
			JSONObject jsonPerson = (JSONObject)jsonArray.get(i);
			
			String firstName = (String) jsonPerson.get("firstName");
			//System.out.println(firstName);
			String lastName = (String) jsonPerson.get("lastName");
			String address = (String) jsonPerson.get("address");
			String city = (String) jsonPerson.get("city");
			String zip = (String) jsonPerson.get("zip");
			String phone = (String) jsonPerson.get("phone");
			String email = (String) jsonPerson.get("email");
			
			Person person = new Person(firstName, lastName, address, city, zip, phone, email);
			//System.out.println(person.getLastName());
			persons.add(person);
		}
		//System.out.println(persons);
		logger.info("persons: ");
		for(Person person :persons) {
		logger.info(person.getFirstName());
		}		
		return persons;
	}
	
}
