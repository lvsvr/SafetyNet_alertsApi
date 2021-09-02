package com.safetyNet.alertsApi.service;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetyNet.alertsApi.repository.PersonInfoDaoImpl;

@SpringBootTest
public class PersonInfoServiceTest {

	@Mock
	private PersonInfoDaoImpl PersonInfoDao;
	
	@Test
	public void shouldReturnPersonInfoByFirstNameAndLastName() {
		//WHEN
		PersonInfoService personInfoService = new PersonInfoService(PersonInfoDao);
		String firstName = "John";
		String lastName = "Boyd";
		//THEN
		assertNotNull(personInfoService.getPersonInfoByFirstNameAndLastName(firstName, lastName));
		
	}
}
