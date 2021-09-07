package com.safetNet.alertsApi.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.safetyNet.alertsApi.controller.MedicalRecordController;
import com.safetyNet.alertsApi.service.MedicalRecordService;

@EnableWebMvc
@SpringBootTest(classes=MedicalRecordController.class)
@AutoConfigureMockMvc
public class MedicalRecordControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MedicalRecordService medicalRecordService;
	
	@Test
	public void shouldReturnMedicalRecorList() throws Exception {
		
		mockMvc.perform(get("/medicalRecord"))
			.andDo(print())
			.andExpect(status().isOk());
		
	}
	
	@Test
	public void shouldInsertMedicalRecord() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/medicalRecord")
		.contentType(MediaType.APPLICATION_JSON)
		.content("{\"firstName\":\"Eric\", \"lastName\":\"Cadigan\", \"birthdate\":\"08/06/1945\", \"medications\":[\"tradoxidine:400mg\"], \"allergies\":[] }"))	
	      .andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	@Test
	public void shouldReturnMedicalRecordByNames() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/medicalRecord")
		.contentType(MediaType.APPLICATION_JSON)
		.content("{\"firstName\":\"Eric\", \"lastName\":\"Cadigan\", \"birthdate\":\"08/06/1945\", \"medications\":[\"tradoxidine:400mg\"], \"allergies\":[] }"))	
	      .andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	@Test
	public void shouldDeleteMedicalRecordByNames() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders
				.delete("/medicalRecord/Eric/Cadigan")
		.contentType(MediaType.APPLICATION_JSON)
		.content("{\"firstName\":\"Eric\", \"lastName\":\"Cadigan\", \"birthdate\":\"08/06/1945\", \"medications\":[\"tradoxidine:400mg\"], \"allergies\":[] }"))	
	      .andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	@Test
	public void shouldUpdateMedicalRecordByNames() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders
				.put("/medicalRecord/Eric/Cadigan")
		.contentType(MediaType.APPLICATION_JSON)
		.content("{\"firstName\":\"Eric\", \"lastName\":\"Cadigan\", \"birthdate\":\"08/06/1945\", \"medications\":[\"tradoxidine:400mg\"], \"allergies\":[] }"))	
	      .andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	
	
}
