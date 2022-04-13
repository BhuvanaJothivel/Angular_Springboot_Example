package com.examly.springapp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class SpringappApplicationTests {

	@Autowired
    private MockMvc mockMvc;
    
	
	@Test
	@Transactional
    public void BE_Add_Employee() throws Exception {
        String newEmployee = "{\"id\":\"1\",\"firstName\":\"Bhuvana\",\"lastName\":\"Jothivel\",\"emailId\":\"bhuvanamjothivel@gmail.com\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/employees")
		.contentType(MediaType.APPLICATION_JSON)
		.content(newEmployee)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
    }
	
	@Test
	@Transactional
    public void BE_Get_Employee() throws Exception {
	 	mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/employees")
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON))
    	.andExpect(status().isOk())
    	.andReturn();
    }
	
}
