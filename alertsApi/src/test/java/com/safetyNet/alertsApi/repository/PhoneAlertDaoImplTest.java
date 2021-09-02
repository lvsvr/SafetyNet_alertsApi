package com.safetyNet.alertsApi.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PhoneAlertDaoImplTest {
	@Mock
	private HomeFirestationUrlDAO homeFirestationUrlDao;
	
	@Test
	public void shouldReturnPhonesByFirestationNumbers() {
		//WHEN
		PhoneAlertDaoImpl phoneDao = new PhoneAlertDaoImpl(homeFirestationUrlDao);
		String address = "1";
		//THEN
		assertNotNull(phoneDao.getPhonesByFirestationNumbers(address));
		
	}

}
