package com.safetyNet.alertsApi.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommunityEmailDaoImplTest {
	
	@Mock
	private PersonDaoImpl personDataAccessService;
	
	@Test
	public void shouldReturnEmailListByCity() {
		//WHEN
		CommunityEmailDaoImpl communityEmailDao = new CommunityEmailDaoImpl(personDataAccessService);
		String city = "Culver";
		//THEN
		assertNotNull(communityEmailDao.getEmailListByCity(city));
	}

}
