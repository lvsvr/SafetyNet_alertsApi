package com.safetyNet.alertsApi.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.alertsApi.model.Firestation;
import com.safetyNet.alertsApi.model.JsonReader;

@SpringBootTest
public class FirestationDaoImplTest {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void shouldLoadDataJsonObject() {
		//GIVEN
		JsonReader jsonReader = new JsonReader();
		//WHEN
		JSONObject dataJsonObject = jsonReader.readDataFromJsonFile();
		//THEN
		assertNotNull(dataJsonObject);
	}
	
	@Test
	public void shouldLoadFirestationArrayList() {
		//GIVEN
		JsonReader jsonReader = new JsonReader();
		JSONObject dataJsonObject = jsonReader.readDataFromJsonFile();
		ArrayList<Firestation> firestations;
		//WHEN
		firestations = jsonReader.getFirestationsFromJson(dataJsonObject);
		//THEN
		assertNotNull(firestations);
	}
	
	@Test
	public void shouldreturnAllFireStations() {
		//GIVEN WHEN
		FirestationDaoImpl firestationDao = new FirestationDaoImpl();
		//THEN
		assertNotNull(firestationDao.getAllFirestations());
		
	}
	
	@Test
	public void shouldInsertFireStation() {
		//GIVEN
		FirestationDaoImpl firestationDao = new FirestationDaoImpl();
		Firestation fs = new Firestation("ad1", "1");
		//WHEN
		firestationDao.insertFirestation(fs);
		//THEN
		assertNotNull(firestationDao.getFirestationByAddress("ad1"));
		
	}
	
	@Test
	public void shouldReturnFirestationByAddress() {
		//GIVEN
		FirestationDaoImpl firestationDao = new FirestationDaoImpl();
		//WHEN
		String address = "ad";
		//THEN
		assertNotNull(firestationDao.getFirestationByAddress(address));
		
	}
	
	@Test
	public void shouldUpdateFireStationByAddress() {
		//GIVEN
		FirestationDaoImpl firestationDao = new FirestationDaoImpl();
		Firestation fs = new Firestation("ad1", "1");
		firestationDao.insertFirestation(fs);
		FirestationDaoImpl firestationDao2 = firestationDao;
		String address = "ad2";
		//WHEN
		firestationDao.updateFirestationByAddress(address, fs);
		//THEN
		assertNotSame(firestationDao2.getAddressListByFirestation("1")  , firestationDao.getAddressListByFirestation("1"));
		
		
	}
	
	@Test
	public void shouldDeleteFirestationByAddress() {
		//GIVEN
		FirestationDaoImpl firestationDao = new FirestationDaoImpl();
		
		Firestation fs = new Firestation("ad1","5");
		firestationDao.insertFirestation(fs);
		//WHEN
		firestationDao.deleteFirestationByAddress(fs.getAddress());
		//THEN
		assertNotSame(firestationDao.getFirestationByAddress(fs.getAddress()), fs);
		
	}
	
	@Test
	public void shouldReturnAddressListByFirestationList() {
		//GIVEN
		FirestationDaoImpl firestationDao = new FirestationDaoImpl();
		ArrayList<String> al = new ArrayList<String>();
		al.add("1");
		ArrayList<String> ad = new ArrayList<String>();
		//WHEN
		ad = firestationDao.getAddressListByFirestationList(al);
		//THEN
		assertNotNull(ad);
		
	}
	
}
