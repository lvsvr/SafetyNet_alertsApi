package com.safetyNet.alertsApi.repository;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FireDaoImplTest {
	
	@Mock
	private HomeDaoImpl homeDataAccessService;
	
	@Test
	public void shouldReturnPersonsListByAddress() {
		//WHEN
		FireDaoImpl fireDao = new FireDaoImpl(homeDataAccessService);
		String address = "951 LoneTree Rd";
		//THEN
		assertNotNull(fireDao.getPersonsListByAddress(address));
		
	}

}
