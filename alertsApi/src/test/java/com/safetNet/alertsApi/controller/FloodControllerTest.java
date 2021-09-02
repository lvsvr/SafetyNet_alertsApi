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

import com.safetyNet.alertsApi.controller.FloodController;
import com.safetyNet.alertsApi.service.FloodService;

@EnableWebMvc
@SpringBootTest(classes=FloodController.class)
@AutoConfigureMockMvc
public class FloodControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private FloodService floodService;
	
	@Test
	public void shouldReturnListOfPersonsByFirestationNumber() throws Exception {
		
		mockMvc.perform(get("/flood/stations?stations=1"))
			.andDo(print())
			.andExpect(status().isOk());
		}

}
