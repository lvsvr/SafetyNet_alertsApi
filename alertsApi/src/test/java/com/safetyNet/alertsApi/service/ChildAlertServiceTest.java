package com.safetyNet.alertsApi.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.alertsApi.repository.ChildAlertDaoImpl;

@SpringBootTest
public class ChildAlertServiceTest {
	
	@Mock
	private ChildAlertDaoImpl childAlertDao;
	
	@Test
	public void shouldReturnChildListByAddress() {
		//WHEN
		ChildAlertService caService = new ChildAlertService(childAlertDao);
		String address = "834 Binoc Ave";
		//THEN
		assertNotNull(caService.getChildListByAddress(address));
		
	}


}
