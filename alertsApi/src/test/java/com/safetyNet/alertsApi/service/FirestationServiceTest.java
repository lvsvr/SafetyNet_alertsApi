package com.safetyNet.alertsApi.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.alertsApi.model.Firestation;
import com.safetyNet.alertsApi.model.Person;
import com.safetyNet.alertsApi.repository.FirestationDaoImpl;

@SpringBootTest
public class FirestationServiceTest {
	
	@Mock
	private FirestationDaoImpl firestationDao;
	
	@Test
	public void shouldReturnFirestationList() {
		//WHEN
		FirestationService fsService = new FirestationService(firestationDao);
		//THEN
		assertNotNull(fsService.getAllFirestations());
		
	}
	
	@Test
	public void shouldInsertFirestation() {
		//GIVEN
		FirestationService fsService = new FirestationService(firestationDao);
		Firestation fs= new Firestation("paradise", "7");
		ArrayList<Firestation>firestations = fsService.getAllFirestations();
		//WHEN
		fsService.insertFirestation(fs);
		//THEN
		assertNotSame(firestations, fsService.getAllFirestations());
		
	}
	
	@Test
	public void shouldReturnFirestationByAddress() {
		//WHEN
		FirestationService fsService = new FirestationService(firestationDao);
		//THEN
		assertNotNull(fsService.getFirestationByAddress("1509 Culver St"));
		
	}
	
	@Test
	public void shouldDeleteFirestationByAddress() {
		//GIVEN
		FirestationService fsService = new FirestationService(firestationDao);
		ArrayList<Firestation>firestations = fsService.getAllFirestations();
		//WHEN
		fsService.deleteFirestationByAddress("1509 Culver St");
		//THEN
		assertNotSame(firestations, fsService.getAllFirestations());
		
	}
	
	@Test
	public void shouldUpdateFirestationByAddress() {
		//GIVEN
		FirestationService fsService = new FirestationService(firestationDao);
		Firestation fs= new Firestation("paradise", "7");
		//WHEN
		fsService.updateFirestationByAddress("1509 Culver St", fs);
		//THEN
		assertNotNull(fsService.getFirestationByAddress("paradise"));
		
	}

}
