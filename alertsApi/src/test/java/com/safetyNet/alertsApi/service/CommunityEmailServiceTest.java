package com.safetyNet.alertsApi.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.alertsApi.repository.CommunityEmailDaoImpl;

@SpringBootTest
public class CommunityEmailServiceTest {
	
	@Mock
	private CommunityEmailDaoImpl CommunityEmailDao;
	
	@Test
	public void shouldReturnEmailListByCity() {
		//WHEN
		CommunityEmailService ceService = new CommunityEmailService(CommunityEmailDao);
		String city = "Culver";
		//THEN
		assertNotNull(ceService.getEmailListByCity(city));
		
	}

}
