package com.safetyNet.alertsApi.model;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FirestationTest {
	
	private Firestation fs;
	
	@Test
	void shouldReturnGettersAndSetters() {
		//WHEN
		fs = new Firestation();
		fs.setAddress("ad");
		fs.setStation("7");
		//THEN
		assertNotNull(fs.getAddress());
		assertNotNull(fs.getStation());
	}
}
