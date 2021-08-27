package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetyNet.alertsApi.AlertsApiApplication;
import com.safetyNet.alertsApi.model.AgeCalculator;
import com.safetyNet.alertsApi.model.MedicalRecord;
import com.safetyNet.alertsApi.model.Person;
import com.safetyNet.alertsApi.model.PersonInfo;

@Repository("personInfoDao")
public class PersonInfoDataAccessService implements PersonInfoDAO {
	private static final Logger logger = LogManager.getLogger(AlertsApiApplication.class);
	private PersonDataAccessService personDao;
	private MedicalRecordDataAccessService medicalRecordDao;

	@Autowired
	public PersonInfoDataAccessService(PersonDataAccessService personDao,
			MedicalRecordDataAccessService medicalRecordDao) {
		super();
		this.personDao = personDao;
		this.medicalRecordDao = medicalRecordDao;
	}

	@Override
	public ArrayList<PersonInfo> getPersonInfoByFirstNameAndLastName(String firstName, String lastName) {
		ArrayList<Person> persons = personDao.getAllPersons();
		ArrayList<MedicalRecord> medicalRecords = medicalRecordDao.getAllMedicalRecords();
		ArrayList<PersonInfo> searchedPersons = new ArrayList<PersonInfo>();
		PersonInfo searchedPerson = new PersonInfo();
		AgeCalculator ac = new AgeCalculator();

		for (Person person : persons) {
			if (person.getFirstName().equals(firstName) && (person.getLastName().equals(lastName))) {
				searchedPerson.setFirstName(firstName);
				searchedPerson.setLastName(lastName);
				searchedPerson.setAddress(person.getAddress());
				searchedPerson.setEmail(person.getEmail());
				for (MedicalRecord medicalRecord : medicalRecords) {
					if ((medicalRecord.getFirstName().equals(firstName))
							&& (medicalRecord.getLastName().equals(lastName))) {
						searchedPerson.setAge(" " + ac.calculateAge(medicalRecord.getBirthDate()));
						searchedPerson.setMedications(medicalRecord.getMedications());
						searchedPerson.setAllergies(medicalRecord.getAllergies());
					}
				}
				searchedPersons.add(searchedPerson);
			}
		}
		return searchedPersons;
	}

}
