package com.safetyNet.alertsApi.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetyNet.alertsApi.model.AgeCalculator;
import com.safetyNet.alertsApi.model.MedicalRecord;
import com.safetyNet.alertsApi.model.Person;
import com.safetyNet.alertsApi.model.PersonInfo;

@Repository
public class PersonInfoDaoImpl implements PersonInfoDAO {
	private PersonDaoImpl personDao;
	private MedicalRecordDaoImpl medicalRecordDao;

	@Autowired
	public PersonInfoDaoImpl(PersonDaoImpl personDao,
			MedicalRecordDaoImpl medicalRecordDao) {
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
