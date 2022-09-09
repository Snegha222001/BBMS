package com.cts.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.model.DonorDetails;
import com.cts.model.Role;
import com.cts.model.User;
import com.cts.repository.RoleRepository;
import com.cts.repository.UserRepository;
import com.cts.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService service;
	
	@MockBean
	private RoleRepository rolwRepo;
	
	@MockBean 
	private UserRepository userRepo;
	
	@Test
	public void testRegisterNewUser() throws Exception {
		
	     Role userRole = new Role();
	     userRole.setRoleId(2);
	     userRole.setRoleName("USER");
	  

	     User user = new User();
	     user.setUsername("Snegha");
	     user.setPassword("abc");
	     Set<Role> userRoles = new HashSet<>();
	     userRoles.add(userRole);
	     user.setRole(userRoles);
	    
		when(service.registerNewUser("Snegha", "abc")).thenReturn(user);
		when(userRepo.save(user)).thenReturn(user);
		ObjectMapper mapper = new ObjectMapper();
		mockMvc.perform(MockMvcRequestBuilders.post("/registerNewUser").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(new DonorDetails(1,"Snegha","abc","abc@gmail.com","O+",21,987654290,"India","TamilNadu","Chennai","Velachery",55,"Female")))).andExpect(status().isOk());

	}
	

}
