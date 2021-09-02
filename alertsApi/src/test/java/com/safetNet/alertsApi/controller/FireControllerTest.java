package com.safetNet.alertsApi.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.safetyNet.alertsApi.controller.FireController;
import com.safetyNet.alertsApi.service.FireService;

@EnableWebMvc
@SpringBootTest(classes=FireController.class)
@AutoConfigureMockMvc
public class FireControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private FireService fireService;
	
	@Test
	public void shouldReturnListOfPersonsByFirestationNumber() throws Exception {
		
		mockMvc.perform(get("/fire?address=1509_Culver_St"))
			.andDo(print())
			.andExpect(status().isOk());
		
	}

}
