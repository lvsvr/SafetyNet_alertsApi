package com.safetyNet.alertsApi.service;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.alertsApi.repository.HomeDaoImpl;

@SpringBootTest
public class HomeServiceTest {
	@Mock
	private HomeDaoImpl homeDao;
	
	@Test
	public void shouldReturnAddressList() {
		//WHEN
		HomeService homeService = new HomeService(homeDao);
		//THEN
		assertNotNull(homeService.getAddressList());
		
	}
	
	@Test
	public void shouldReturnHomesList() {
		//WHEN
		HomeService homeService = new HomeService(homeDao);
		//THEN
		assertNotNull(homeService.getHomeList());
		
	}

}
