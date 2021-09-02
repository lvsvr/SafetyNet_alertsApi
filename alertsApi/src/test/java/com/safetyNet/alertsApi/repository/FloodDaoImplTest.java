package com.safetyNet.alertsApi.repository;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FloodDaoImplTest {

	@Mock
	private FirestationDaoImpl firestationDatatAccessService;
	@Mock
	private HomeDaoImpl homeDataAccessService;
	
	@Test
	public void shouldReturnPersonsListByFirestationNumberList() {
		//WHEN
		FloodDaoImpl floodDao = new FloodDaoImpl(firestationDatatAccessService, homeDataAccessService);
		ArrayList<String> firestationNumber = new ArrayList<String>();
		firestationNumber.add("1");
		//THEN
		assertNotNull(floodDao.getPersonsListByFirestationNumberList(firestationNumber));
		
	}
}
