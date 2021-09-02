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

import com.safetyNet.alertsApi.controller.PersonInfoController;
import com.safetyNet.alertsApi.service.PersonInfoService;

@EnableWebMvc
@SpringBootTest(classes=PersonInfoController.class)
@AutoConfigureMockMvc
public class PersonInfoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PersonInfoService fpersonInfoService;
	
	@Test
	public void shouldReturnPersonInfoByFirstNameAndLastName() throws Exception {
		
		mockMvc.perform(get("/personInfo?firstName=John&lastName=Boyd"))
			.andDo(print())
			.andExpect(status().isOk());
		
	}
	

}
