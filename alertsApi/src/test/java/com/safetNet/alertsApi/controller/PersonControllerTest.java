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

import com.safetyNet.alertsApi.controller.PersonController;
import com.safetyNet.alertsApi.service.PersonService;

@EnableWebMvc
@SpringBootTest(classes=PersonController.class)
@AutoConfigureMockMvc
public class PersonControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PersonService personService;
	
	@Test
	public void shouldReturnPersonsList() throws Exception {
		
		mockMvc.perform(get("/person"))
			.andDo(print())
			.andExpect(status().isOk());
		
	}
	
	@Test
	public void shouldInsertPerson() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders
				.post("/person")
		.contentType(MediaType.APPLICATION_JSON)
		.content("{\"firstName\":\"Eric\", \"lastName\":\"Cadigan\", \"address\":\"951 LoneTree Rd\", \"city\":\"Culver\", \"zip\":\"97451\", \"phone\":\"841-874-7458\", \"email\":\"gramps@email.com\" }"))	
	      .andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	@Test
	public void shouldReturnPersonByNames() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/person")
		.contentType(MediaType.APPLICATION_JSON)
		.content("{\"firstName\":\"Eric\", \"lastName\":\"Cadigan\", \"address\":\"951 LoneTree Rd\", \"city\":\"Culver\", \"zip\":\"97451\", \"phone\":\"841-874-7458\", \"email\":\"gramps@email.com\" }"))	
	      .andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	@Test
	public void shouldDeletePersonByNames() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders
				.delete("/person/Eric/Cadigan")
		.contentType(MediaType.APPLICATION_JSON)
		.content("{\"firstName\":\"Eric\", \"lastName\":\"Cadigan\", \"address\":\"951 LoneTree Rd\", \"city\":\"Culver\", \"zip\":\"97451\", \"phone\":\"841-874-7458\", \"email\":\"gramps@email.com\" }"))	
	      .andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	@Test
	public void shouldUpdatePersonByNames() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders
				.put("/person/Eric/Cadigan")
		.contentType(MediaType.APPLICATION_JSON)
		.content("{\"firstName\":\"Eric\", \"lastName\":\"Cadigan\", \"address\":\"951 LoneTree Rd\", \"city\":\"Culver\", \"zip\":\"97451\", \"phone\":\"841-874-7458\", \"email\":\"gramps@email.com\" }"))	
	      .andExpect(MockMvcResultMatchers.status().isOk());
		
	}
		
}

