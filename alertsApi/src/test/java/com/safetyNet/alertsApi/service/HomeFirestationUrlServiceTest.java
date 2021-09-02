package com.safetyNet.alertsApi.service;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.alertsApi.repository.HomeFirestationURLDaoImpl;

@SpringBootTest
public class HomeFirestationUrlServiceTest {
	
	@Mock
	private HomeFirestationURLDaoImpl homeFirestationUrlDao;
	
	@Test
	public void shouldReturnListOfPersonsByFirestationNumber() {
		//WHEN
		HomeFirestationUrlService homefsService = new HomeFirestationUrlService(homeFirestationUrlDao);
		String firestationNumber = "1";
		//THEN
		assertNotNull(homefsService.getListOfPersonsByFirestationNumber(firestationNumber));
		
	}

}
