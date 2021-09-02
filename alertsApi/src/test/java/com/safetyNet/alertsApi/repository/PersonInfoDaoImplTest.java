package com.safetyNet.alertsApi.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonInfoDaoImplTest {
	
	@Mock
	private PersonDaoImpl personDao;
	@Mock
	private MedicalRecordDaoImpl medicalRecordDao;

	
	@Test
	public void shouldReturnPersonInfoByFirstNameAndLastName() {
		//WHEN
		PersonInfoDaoImpl personInfoDao = new PersonInfoDaoImpl(personDao, medicalRecordDao);
		String firstName = "Clive";
		String LastName = "Ferguson";
		//THEN
		assertNotNull(personInfoDao.getPersonInfoByFirstNameAndLastName(firstName, LastName));
	}
}
