package com.safetyNet.alertsApi.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.alertsApi.model.Home;

@SpringBootTest
public class HomeDaoImplTest {
	
	@Mock
	private FirestationDaoImpl firestationDao;
	@Mock
	private PersonDaoImpl personDao;
	@Mock
	private MedicalRecordDaoImpl medicalRecordDao;
	
	@Test
	public void shouldReturnAddressList() {
		//WHEN
		HomeDaoImpl homeDao = new HomeDaoImpl(firestationDao, personDao, medicalRecordDao);
		//THEN
		assertNotNull(homeDao.getAddressList());

	}
	
	@Test
	public void shouldCreateHomeListAddress() {
		//WHEN
		HomeDaoImpl homeDao = new HomeDaoImpl(firestationDao, personDao, medicalRecordDao);
		ArrayList<String> addressList = homeDao.getAddressList();
		//THEN
		assertNotNull(homeDao.createHomeListByAddress(addressList));
		
	}
	
	
	
	@Test
	public void shouldConfirmInsertFirestations() {
		//WHEN
		HomeDaoImpl homeDao = new HomeDaoImpl(firestationDao, personDao, medicalRecordDao);
		ArrayList<Home> homes = homeDao.createHomeListByAddress(homeDao.getAddressList());
		//THEN
		assertNotNull(homeDao.insertFirestations(homes));
		
	}
	
	@Test
	public void shouldConfirmInsertPersons() {
		//WHEN
		HomeDaoImpl homeDao = new HomeDaoImpl(firestationDao, personDao, medicalRecordDao);
		ArrayList<Home> homes = homeDao.createHomeListByAddress(homeDao.getAddressList());
		//THEN
		assertNotNull(homeDao.insertPersons(homes));
		
	}
	
	@Test
	public void shouldConfirmInsertMedicalRecords() {
		//WHEN
		HomeDaoImpl homeDao = new HomeDaoImpl(firestationDao, personDao, medicalRecordDao);
		ArrayList<Home> homes = homeDao.createHomeListByAddress(homeDao.getAddressList());
		//THEN
		assertNotNull(homeDao.insertMedicalRecords(homes));
		
	}
	
	@Test
	public void shouldReturnHomeList() {
		//WHEN
		HomeDaoImpl homeDao = new HomeDaoImpl(firestationDao, personDao, medicalRecordDao);

		//THEN
		assertNotNull(homeDao.getHomeList());
		
	}
	
	@Test
	public void shouldReturnPersonsListByAddress() {
		//WHEN
		FirestationDaoImpl firestationDao2 = new FirestationDaoImpl(); 
		PersonDaoImpl personDao2 = new PersonDaoImpl();
		MedicalRecordDaoImpl medicalRecordDao2 = new MedicalRecordDaoImpl();
		HomeDaoImpl homeDao = new HomeDaoImpl(firestationDao2, personDao2, medicalRecordDao2);

		//THEN
		assertNotNull(homeDao.getPersonsListByAddress(homeDao.getAddressList().get(0)));
	}
	
	@Test
	public void shouldReturnPersonsListByAddressList() {
		//WHEN
		FirestationDaoImpl firestationDao2 = new FirestationDaoImpl(); 
		PersonDaoImpl personDao2 = new PersonDaoImpl();
		MedicalRecordDaoImpl medicalRecordDao2 = new MedicalRecordDaoImpl();
		HomeDaoImpl homeDao = new HomeDaoImpl(firestationDao2, personDao2, medicalRecordDao2);

		//THEN
		assertNotNull(homeDao.getPersonsListByAddressList(homeDao.getAddressList()));
	}
	
	
}