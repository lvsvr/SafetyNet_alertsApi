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
import com.safetyNet.alertsApi.model.PersonForEmergencyCase;
import com.safetyNet.alertsApi.model.PersonInfo;



@Repository
public class HomeDaoImpl implements HomeDAO{
	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);
	private FirestationDaoImpl firestationDao;
	private PersonDaoImpl personDao;
	private MedicalRecordDaoImpl medicalRecordDao;
	
	public HomeDaoImpl(FirestationDaoImpl firestationDao, PersonDaoImpl personDao, MedicalRecordDaoImpl medicalRecordDao) {
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
	public Home getHomeByAddress(String address) {
		ArrayList<Home> homes = getHomeList();
		Home searchedHome = null;	
		for(Home home :homes) {
			if(home.getAddress().equals(address))
				searchedHome = home;
			}
		return searchedHome;
	}

	@Override
	public ArrayList<PersonForEmergencyCase> getPersonsListByAddress(String address) {
		Home home = getHomeByAddress(address);
		ArrayList<String> personsList = new ArrayList<String>();
		personsList.add("Firestation: " + home.getStation());
		ArrayList<Person> persons = home.getPersons();
		ArrayList<MedicalRecord> medicalRecords = home.getMedicalRecords();
		ArrayList<PersonForEmergencyCase> personsForEmergencyCase = new ArrayList<PersonForEmergencyCase>();
		AgeCalculator ac = new AgeCalculator();
		for (Person person : persons) {
			PersonForEmergencyCase personFec = new PersonForEmergencyCase();
			personFec.setAddress("address: " + address);
			personFec.setFirestation("firestation: " + home.getStation());
			personFec.setFirstName("firstName: " + person.getFirstName());
			personFec.setLastName("lastName: " + person.getLastName());
			personFec.setPhone("phone: " + person.getPhone());
			for (MedicalRecord medicalRecord : medicalRecords) {
				if (medicalRecord.getFirstName().equals(person.getFirstName())
						&& medicalRecord.getLastName().equals(person.getLastName())) {
					personFec.setAge("age: " + ac.calculateAge(medicalRecord.getBirthDate()));
					personFec.setMedications(medicalRecord.getMedications());
					personFec.setAllergies(medicalRecord.getAllergies());
				}
			}
			personsForEmergencyCase.add(personFec);
		}

		return personsForEmergencyCase;
	}

	@Override
	public ArrayList<PersonForEmergencyCase> getPersonsListByAddressList(ArrayList<String> addressList) {
		ArrayList<PersonForEmergencyCase> personsForEmergencyCaseList = new ArrayList<PersonForEmergencyCase>();
		for (String address :addressList) {
			personsForEmergencyCaseList.addAll(getPersonsListByAddress(address));
		}
		return personsForEmergencyCaseList;
	}
	
}