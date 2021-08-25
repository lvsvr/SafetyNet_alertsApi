package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.safetyNet.alertsApi.AlertsApiApplication;
import com.safetyNet.alertsApi.model.AgeCalculator;
import com.safetyNet.alertsApi.model.Firestation;
import com.safetyNet.alertsApi.model.Home;
import com.safetyNet.alertsApi.model.MedicalRecord;
import com.safetyNet.alertsApi.model.Person;



@Repository("homeDao")
public class HomeDataAccessService implements HomeDAO{
	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);
	private FirestationDataAccessService firestationDao;
	private PersonDataAccessService personDao;
	private MedicalRecordDataAccessService medicalRecordDao;
	
	public HomeDataAccessService(FirestationDataAccessService firestationDao, PersonDataAccessService personDao, MedicalRecordDataAccessService medicalRecordDao) {
		super();
		this.firestationDao = firestationDao;
		this.personDao = personDao;
		this.medicalRecordDao = medicalRecordDao;
	}
	
	@Override
	public ArrayList<String> getAddressList() {
		ArrayList<String> addressList = new ArrayList<String>();
		ArrayList<Firestation> firestations = firestationDao.getAllFirestations();
		for (Firestation firestation : firestations) {
			addressList.add(firestation.getAddress());
		}
		return addressList;
	}
	@Override
	public ArrayList<Home> createHomeListByAddress(ArrayList<String> addressList) {
		ArrayList<Home> homes = new ArrayList<Home>();
		for (String address : addressList) {
			Home home = new Home(address, null, null, null);
			homes.add(home);
		}
		return homes;
	}
	
	@Override
	public int insertFirestations(ArrayList<Home> homes) {
		if (homes == null) {
			return 0;
		}
		for (Home home : homes) {
			ArrayList<Firestation> firestations= firestationDao.getAllFirestations();
			for (Firestation firestation : firestations) {
				if (firestation.getAddress() == home.getAddress()) {
					home.setStation(firestation.getStation());
				}
			}
		}
		return 1;
	}

	@Override
	public int insertPersons(ArrayList<Home> homes) {
		if (homes == null) {
			return 0;
		}
		ArrayList<Person> persons = personDao.getAllPersons();
		for (Home home : homes) {
			ArrayList<Person>personsMemo = new ArrayList<Person>();
			for (Person person : persons) {
				//System.out.println(person.getAddress());
				//System.out.println(home.getAddress());
				if (person.getAddress().equals(home.getAddress())) {
					//System.out.println(person.getLastName());
					personsMemo.add(person);
				}
			}
			home.setPersons(personsMemo);
		}
		return 1;
	}
	
	@Override
	public int insertMedicalRecords(ArrayList<Home> homes) {
		if (homes == null) {
			return 0;
		}
		ArrayList<MedicalRecord> medicalRecords = medicalRecordDao.getAllMedicalRecords();
		for (Home home : homes) {
			if (home.getPersons() == null) {
				return 0;
			}
			ArrayList<MedicalRecord>medicalRecordMemo = new ArrayList<MedicalRecord>();
			for (MedicalRecord medicalRecord : medicalRecords) {
				for (Person person : home.getPersons()) {
					if (medicalRecord.getFirstName().equals(person.getFirstName())
							&& medicalRecord.getLastName().equals(person.getLastName())) {
						medicalRecordMemo.add(medicalRecord);
					}
				}
			}
			home.setMedicalRecords(medicalRecordMemo);
		}
		return 1;
	}
	
	@Override
	public ArrayList<Home> getHomeList() {
		ArrayList<String>addressListForHome = getAddressList();
		ArrayList<Home>homeList = createHomeListByAddress(addressListForHome);
		insertFirestations(homeList);
		insertPersons(homeList);
		insertMedicalRecords(homeList);
		return homeList;
	}
	
	@Override
	public ArrayList<Home> getHomeByFirestationNumber(String firestationNumber) {
		ArrayList<Home> homeList = getHomeList();
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