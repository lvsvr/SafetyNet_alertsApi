//package com.safetNet.alertsApi.controller;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import com.safetyNet.alertsApi.controller.HomeController;
//import com.safetyNet.alertsApi.service.HomeService;
//
//@EnableWebMvc
//@SpringBootTest(classes=HomeController.class)
//@AutoConfigureMockMvc
//public class HomeControllerTest {
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@MockBean
//	private HomeService homeService;
//	
//	@Test
//	public void shouldReturnHomeList() throws Exception {
//		
//		mockMvc.perform(get("/home"))
//			.andDo(print())
//			.andExpect(status().isOk());
//		
//	}
//
//}
