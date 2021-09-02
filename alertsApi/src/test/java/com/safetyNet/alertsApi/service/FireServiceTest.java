package com.safetyNet.alertsApi.service;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.alertsApi.repository.FireDaoImpl;

@SpringBootTest
public class FireServiceTest {
	
	@Mock
	private FireDaoImpl fireDao;
	
	@Test
	public void shouldReturnPersonsListByAddres() {
		//WHEN
		FireService fireService = new FireService(fireDao);
		String address = "29 15th St";
		//THEN
		assertNotNull(fireService.getPersonsListByAddress(address));
		
	}

}
