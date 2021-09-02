package com.safetyNet.alertsApi.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.alertsApi.model.MedicalRecord;
import com.safetyNet.alertsApi.model.Person;

@SpringBootTest
public class HomeFirestationURLDaoImplTest {

	@Mock
	private FirestationDaoImpl firestationDao;
	@Mock
	private PersonDaoImpl personDao;
	@Mock
	private MedicalRecordDaoImpl medicalRecordDao;
	@Mock
	private HomeDaoImpl homeDao;
	
	@Test
	public void shouldReturnHomeByFirestationNumber() {
		//GIVEN
		HomeFirestationURLDaoImpl homeFsDao = new HomeFirestationURLDaoImpl(firestationDao, personDao, medicalRecordDao, homeDao);
		//WHEN
		String firestationNumber ="1";
		//THEN
		assertNotNull(homeFsDao.getHomeByFirestationNumber(firestationNumber));
		
	}
	
	@Test
	public void shouldReturnPersonsByFirestationNumber() {
		//GIVEN
		HomeFirestationURLDaoImpl homeFsDao = new HomeFirestationURLDaoImpl(firestationDao, personDao, medicalRecordDao, homeDao);
		//WHEN
		String firestationNumber ="1";
		//THEN
		assertNotNull(homeFsDao.getPersonsByFirestationNumber(firestationNumber));
		
	}
	
	@Test
	public void shouldReturnArrangedListOfPersonsByFirestationNumber() {
		//GIVEN
		HomeFirestationURLDaoImpl homeFsDao = new HomeFirestationURLDaoImpl(firestationDao, personDao, medicalRecordDao, homeDao);
		//WHEN
		ArrayList<Person>persons = personDao.getAllPersons();
		//THEN
		assertNotNull(homeFsDao.arrangeListOfPersonByFirestationNumber(persons));
		
	}
	
	@Test
	public void shouldReturnMedicalRecordsByFirestationNumber() {
		//GIVEN
		HomeFirestationURLDaoImpl homeFsDao = new HomeFirestationURLDaoImpl(firestationDao, personDao, medicalRecordDao, homeDao);
		//WHEN
		String firestationNumber ="1";
		//THEN
		assertNotNull(homeFsDao.getMedicalRecordsByFirestationsByNumber(firestationNumber));
		
	}
	
	@Test
	public void shouldReturnChildAndAdultNumbers() {
		//WHEN
		HomeFirestationURLDaoImpl homeFsDao = new HomeFirestationURLDaoImpl(firestationDao, personDao, medicalRecordDao, homeDao);
		ArrayList<MedicalRecord> medicalRecords = medicalRecordDao.getAllMedicalRecords();
		//THEN
		assertNotNull(homeFsDao.getChildAndAdultNumbers(medicalRecords));
	
	}
	
	@Test
	public void shouldReturnListOfPersonsByFirestationNumber() {
		//WHEN
		HomeFirestationURLDaoImpl homeFsDao = new HomeFirestationURLDaoImpl(firestationDao, personDao, medicalRecordDao, homeDao);
		String firestationNumber ="1";
		//THEN
		assertNotNull(homeFsDao.getListOfPersonsByFirestationNumber(firestationNumber));
	
	}
	
	
}
