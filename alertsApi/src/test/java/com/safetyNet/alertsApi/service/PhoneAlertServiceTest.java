package com.safetyNet.alertsApi.service;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.alertsApi.repository.PhoneAlertDaoImpl;

@SpringBootTest
public class PhoneAlertServiceTest {
	
	@Mock
	private PhoneAlertDaoImpl  phoneAlertDao;
	
	@Test
	public void shouldReturnPhonesByFirestationNumbers() {
		//WHEN
		PhoneAlertService phoneService = new PhoneAlertService(phoneAlertDao);
		String firestationNumber = "1";
		//THEN
		assertNotNull(phoneService.getPhonesByFirestationNumbers(firestationNumber));
		
	}
}
