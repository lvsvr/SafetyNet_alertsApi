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

import com.safetyNet.alertsApi.controller.FirestationController;
import com.safetyNet.alertsApi.service.FirestationService;
import com.safetyNet.alertsApi.service.HomeFirestationUrlService;

@EnableWebMvc
@SpringBootTest(classes=FirestationController.class)
@AutoConfigureMockMvc
public class FirestationControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private FirestationService firestationService;
	
	@MockBean
	private HomeFirestationUrlService homeFirestationUrlService;

	
	@Test
	public void shouldInsertFirestation() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/firestation")
		.contentType(MediaType.APPLICATION_JSON)
		.content("{\"address\":\"951 LoneTree Rd\",\"station\":\"2\"}"))	
	      .andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	@Test
	public void shouldReturnFirestationByAddress() throws Exception {
		
		mockMvc.perform(get("/firestation/1509_Culver_St"))
			.andDo(print())
			.andExpect(status().isOk());
	}
	
	@Test
	public void shouldDeleteFirestationByAddress() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders
				.delete("/firestation/1509_Culver_St")
		.contentType(MediaType.APPLICATION_JSON)
		.content("{ \"address\":\"1509 Culver St\", \"station\":\"3\" }"))	
	      .andExpect(MockMvcResultMatchers.status().isOk());
		
	}

	
	@Test
	public void shouldUpdateFirestationByAddress() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders
				.put("/firestation/1509_Culver_St")
		.contentType(MediaType.APPLICATION_JSON)
		.content("{ \"address\":\"1509 Culver St\", \"station\":\"3\" }"))		
	      .andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	@Test
	public void shouldReturnListOfPersonsByFirestationNumber() throws Exception {
		
		mockMvc.perform(get("/firestation?stationNumber=1"))
			.andDo(print())
			.andExpect(status().isOk());
		
	}
}
