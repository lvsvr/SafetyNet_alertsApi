package com.safetyNet.alertsApi.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.alertsApi.repository.FloodDaoImpl;

@SpringBootTest
public class FloodServiceTest {
	
	@Mock
	private FloodDaoImpl floodDao;
	
	@Test
	public void shouldReturnPersonsListByFirestationNumberList() {
		//WHEN
		FloodService floodService = new FloodService(floodDao);
		ArrayList<String> fsNumbers = new ArrayList<String>();
		String firestationNumber = "1";
		fsNumbers.add(firestationNumber);
		//THEN
		assertNotNull(floodService.getPersonsListByFirestationNumberList(fsNumbers));
		
	}
	

}
