package com.safetyNet.alertsApi.model;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@SpringBootTest
public class AgeCalculatorTest {
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void shouldCalculateAgeFromBirthDate() {
	//GIVEN
	AgeCalculator ac = new AgeCalculator();
	//WHEN
	MedicalRecord mr = new MedicalRecord("Bart", "Simpson", "08/26/1991", null, null);
	//THEN
	assertEquals(30,ac.calculateAge(mr.getBirthDate()));
	}

	
}
