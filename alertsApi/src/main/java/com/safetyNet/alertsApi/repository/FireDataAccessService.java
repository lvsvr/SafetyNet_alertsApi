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
import com.safetyNet.alertsApi.model.PersonForFireCase;

@Repository("firesDao")
public class FireDataAccessService implements FireDAO {

	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);
	private HomeDataAccessService homeDataAccessService;

	public FireDataAccessService(HomeDataAccessService homeDataAccessService) {
		super();
		this.homeDataAccessService = homeDataAccessService;
	}

	@Override
	public ArrayList<PersonForFireCase> getPersonsListByAdress(String address) {
		Home home = homeDataAccessService.getHomeByAddress(address);
		ArrayList<String> personsList = new ArrayList<String>();
		personsList.add("Firestation: " + home.getStation());
		ArrayList<Person> persons = home.getPersons();
		ArrayList<MedicalRecord> medicalRecords = home.getMedicalRecords();
		ArrayList<PersonForFireCase> personsForFireCase = new ArrayList<PersonForFireCase>();
		AgeCalculator ac = new AgeCalculator();
		for (Person person : persons) {
			PersonForFireCase personFfc = new PersonForFireCase();
			personFfc.setFirestation("firestation: " + home.getStation());
			personFfc.setFirstName("firstName: " + person.getFirstName());
			personFfc.setLastName("lastName: " + person.getLastName());
			personFfc.setPhone("phone: " + person.getPhone());
			for (MedicalRecord medicalRecord : medicalRecords) {
				if (medicalRecord.getFirstName().equals(person.getFirstName())
						&& medicalRecord.getLastName().equals(person.getLastName())) {
					personFfc.setAge("age: " + ac.calculateAge(medicalRecord.getBirthDate()));
					personFfc.setMedications(medicalRecord.getMedications());
					personFfc.setAllergies(medicalRecord.getAllergies());
				}
			}
			personsForFireCase.add(personFfc);
		}

		return personsForFireCase;
	}

}
