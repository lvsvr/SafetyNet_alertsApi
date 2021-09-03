package com.safetyNet.alertsApi.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.alertsApi.model.Home;
import com.safetyNet.alertsApi.model.MedicalRecord;

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
	public void shouldReturnHomeByAddress() {
		//WHEN
		HomeDaoImpl homeDao = new HomeDaoImpl(firestationDao, personDao, medicalRecordDao);
		//THEN
		assertNotNull(homeDao.getHomeList());
	}
	
}
