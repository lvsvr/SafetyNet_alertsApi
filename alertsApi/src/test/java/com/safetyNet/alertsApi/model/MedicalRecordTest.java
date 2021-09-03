package com.safetyNet.alertsApi.model;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MedicalRecordTest {

	private MedicalRecord mr;
	@Mock
	private ArrayList<String> medications;
	@Mock
	private ArrayList<String> allergies;
	
	@Test
	void shouldReturnGettersAndSetters() {
	//WHEN
	mr = new MedicalRecord();
	mr.setFirstName("fn");
	mr.setLastName("ln");
	mr.setBirthDate("07/14/1789");
	mr.setMedications(medications);
	mr.setAllergies(allergies);
	
	assertNotNull(mr.getFirstName());
	assertNotNull(mr.getLastName());
	assertNotNull(mr.getBirthDate());
	assertNotNull(mr.getMedications());
	assertNotNull(mr.getAllergies());
	}
}
