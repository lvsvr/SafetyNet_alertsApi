package com.safetyNet.alertsApi.repository;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.alertsApi.model.Home;
import com.safetyNet.alertsApi.model.MedicalRecord;

@SpringBootTest
public class ChildAlertDaoImplTest {

	@Mock
	private FirestationDaoImpl firestationDao;
	@Mock
	private PersonDaoImpl personDao;
	@Mock
	private MedicalRecordDaoImpl medicalRecordDao;
	@Mock
	private HomeDaoImpl homeDao;
	
	@Test
	public void shouldReturnHomeByAddress() {
		//WHEN
		ChildAlertDaoImpl childDao = new ChildAlertDaoImpl(firestationDao, personDao, medicalRecordDao, homeDao);
		String address = "951 LoneTree Rd";
		//THEN
		assertNotNull(childDao.getHomeByAddress(address));
		
	}
	
	@Test
	public void shouldReturnMedicalRecordByHome() {
		//WHEN
		ChildAlertDaoImpl childDao = new ChildAlertDaoImpl(firestationDao, personDao, medicalRecordDao, homeDao);
		Home home = new Home();
		ArrayList<MedicalRecord> mrlist = new ArrayList<MedicalRecord>();
		MedicalRecord mr = new MedicalRecord();
		ArrayList<String>medications = new ArrayList<String>();
		medications.add("tradoxidine:400mg");
		mr.setMedications(medications);
		home.setAddress("951 LoneTree Rd");
		home.setStation("2");
		home.setMedicalRecords(mrlist);
		//THEN
		assertNotNull(childDao.getMedicalRecordsByHome(home));
		
	}
	
	@Test
	public void shouldReturnChildListFromMedialRecordList() {
		//WHEN
		ChildAlertDaoImpl childDao = new ChildAlertDaoImpl(firestationDao, personDao, medicalRecordDao, homeDao);
		ArrayList<MedicalRecord> mrlist = medicalRecordDao.getAllMedicalRecords();
		//THEN
		assertNotNull(childDao.getChildListFromMedicalRecordList(mrlist));
	}
	
	@Test
	public void shouldReturnChildListByAddress() {
		//WHEN
		FirestationDaoImpl firestationDao2 = new FirestationDaoImpl(); 
		PersonDaoImpl personDao2 = new PersonDaoImpl();
		MedicalRecordDaoImpl medicalRecordDao2 = new MedicalRecordDaoImpl();
		HomeDaoImpl homeDao2 = new HomeDaoImpl(firestationDao2, personDao2, medicalRecordDao2);
		ChildAlertDaoImpl childDao = new ChildAlertDaoImpl(firestationDao2, personDao2, medicalRecordDao2, homeDao2);
		ArrayList<MedicalRecord> mrlist = medicalRecordDao.getAllMedicalRecords();
		//THEN
		assertNotNull(childDao.getChildListByAddress("951 LoneTree Rd"));
	}
	
	
	}
