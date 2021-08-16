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
import com.safetyNet.alertsApi.model.Firestation;
import com.safetyNet.alertsApi.model.MedicalRecord;
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
		logger.info(person.getFirstName()+" "+person.getLastName()+" "+person.getAddress()+" "+ person.getCity()+" "+person.getZip()+" "+person.getPhone()+" "+person.getEmail());
		}		
		return persons;
	}
	
	public ArrayList<Firestation> getFirestationsFromJson(JSONObject dataJsonObject) {
			
			JSONArray jsonArray = (JSONArray) dataJsonObject.get("firestations");
			ArrayList<Firestation> firestations = new ArrayList<Firestation>();
			for(int i=0; i<jsonArray.size(); i++) {
				JSONObject jsonFirestation = (JSONObject)jsonArray.get(i);
				
				String address = (String) jsonFirestation.get("address");
				String station = (String) jsonFirestation.get("station");
							
				Firestation firestation = new Firestation(address,station);
				//System.out.println(person.getLastName());
				firestations.add(firestation);
			}
			//System.out.println(persons);
			logger.info("firestations: ");
			for(Firestation firestation :firestations) {
			logger.info(firestation.getAddress()+": st."+firestation.getStation());
			}		
			return firestations;
		}

	public ArrayList<MedicalRecord> getMedicalRecordsFromJson(JSONObject dataJsonObject) {
		
		JSONArray jsonArray = (JSONArray) dataJsonObject.get("medicalrecords");
		ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
		for(int i=0; i<jsonArray.size(); i++) {
			JSONObject jsonMedicalRecord = (JSONObject)jsonArray.get(i);
			
			String firstName = (String) jsonMedicalRecord.get("firstName");
			String lastName = (String) jsonMedicalRecord.get("lastName");
			String birthDate = (String) jsonMedicalRecord.get("birthdate");
			ArrayList<String> medications = (ArrayList<String>) jsonMedicalRecord.get("medications");
			ArrayList<String> allergies = (ArrayList<String>) jsonMedicalRecord.get("allergies");
			
			MedicalRecord medicalRecord = new MedicalRecord(firstName, lastName, birthDate, medications, allergies);
			//System.out.println(person.getLastName());
			medicalRecords.add(medicalRecord);
		}
		//System.out.println(persons);
		logger.info("medicalrecords: ");
		for(MedicalRecord medicalRecord :medicalRecords) {
		logger.info(medicalRecord.getFirstName()+" "+medicalRecord.getLastName()+" "+medicalRecord.getBirthDate()+" "+medicalRecord.getMedications()+" "+medicalRecord.getAllergies());
		}		
		return medicalRecords;
	}
	
}
