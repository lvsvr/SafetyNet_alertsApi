package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.safetyNet.alertsApi.AlertsApiApplication;
import com.safetyNet.alertsApi.model.AgeCalculator;
import com.safetyNet.alertsApi.model.Home;
import com.safetyNet.alertsApi.model.MedicalRecord;
import com.safetyNet.alertsApi.model.Person;

@Repository("homefirestationUrlDao")
public class HomeFirestationURLDataAccessService implements HomeFirestationUrlDAO{
	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);
	private FirestationDataAccessService firestationDao;
	private PersonDataAccessService personDao;
	private MedicalRecordDataAccessService medicalRecordDao;
	private HomeDataAccessService homeDao;
	
	public HomeFirestationURLDataAccessService(FirestationDataAccessService firestationDao,
			PersonDataAccessService personDao, MedicalRecordDataAccessService medicalRecordDao,
			HomeDataAccessService homeDao) {
		super();
		this.firestationDao = firestationDao;
		this.personDao = personDao;
		this.medicalRecordDao = medicalRecordDao;
		this.homeDao = homeDao;
	}
	
	@Override
	public ArrayList<Home> getHomeByFirestationNumber(String firestationNumber) {
		ArrayList<Home> homeList = homeDao.getHomeList();
		ArrayList<Home>searchedHomes=new ArrayList<Home>();
		for(Home home: homeList) {
			if(home.getStation().equals(firestationNumber)) {
				searchedHomes.add(home);
			}
		}
		return searchedHomes;
	}

	@Override
	public ArrayList<Person> getPersonsByFirestationNumber(String firestationNumber) {
		ArrayList<Home> homeList = getHomeByFirestationNumber(firestationNumber);
		ArrayList<Person>personsList =new ArrayList<Person>();
		for(Home home : homeList) {
			for(Person person : home.getPersons()) {
			 personsList.add(person);
			}
		}
		return personsList;
	}

	@Override
	public ArrayList<String> arrangeListOfPersonByFirestationNumber(ArrayList<Person> personList) {
		ArrayList<String> searchedPersonList = new ArrayList<String>();
		for(Person person :personList) {
			String personString = "firstName: "+ person.getFirstName() +"; lastName: "+ person.getLastName()+"; address: "+person.getAddress()+"; phone: "+person.getPhone();
			searchedPersonList.add(personString);
		}
		return searchedPersonList;
	}

	@Override
	public ArrayList<MedicalRecord> getMedicalRecordsByFirestationsByNumber(String firestationNumber) {
		ArrayList<Home> homeList = getHomeByFirestationNumber(firestationNumber);
		ArrayList<MedicalRecord>medicalRecordsList =new ArrayList<MedicalRecord>();
		for(Home home : homeList) {
			for(MedicalRecord medicalRecord : home.getMedicalRecords()) {
			 medicalRecordsList.add(medicalRecord);
			}
		}
		return medicalRecordsList;
	}

	@Override
	public String getChildAndAdultNumbers(ArrayList<MedicalRecord> medicalRecords) {
		int childCounter = 0;
		int adultCounter = 0;
		for(MedicalRecord medicalRecord : medicalRecords) {
			AgeCalculator ac = new AgeCalculator();
			if(ac.calculateAge(medicalRecord.getBirthDate())<=18) {
				childCounter ++;
			}
			else {
				adultCounter ++;
			}
		}
		String counters = "Adults number: "+ adultCounter+"; Children number : "+childCounter;
		return counters;
	}

	@Override
	public ArrayList<String> getListOfPersonsByFirestationNumber(String firestationNumber) {
		ArrayList<Person> personList = getPersonsByFirestationNumber(firestationNumber);
		ArrayList<String> arrangedPersons = arrangeListOfPersonByFirestationNumber(personList);
		ArrayList<MedicalRecord>medicalRecords = getMedicalRecordsByFirestationsByNumber(firestationNumber);
		String counters = getChildAndAdultNumbers(medicalRecords);
		arrangedPersons.add(counters);
		return arrangedPersons;
	}
	
	
	
}
