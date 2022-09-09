package com.cts.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.util.JwtUtil;
import com.cts.model.JwtRequest;
import com.cts.model.Role;
import com.cts.model.User;
import com.cts.service.JwtUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class JwtAuthenticationControllerEndPointsTest {

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private JwtUserDetailsService userDetailsService;

	@MockBean
	private JwtUtil jwtTokenUtil;

	@MockBean
	private AuthenticationManager authenticationManager;

	@Test
	void testBadRequestGenerateToken() throws Exception {
		this.mockMvc.perform(post("/login")).andExpect(status().isBadRequest());
	}

	@Test
	void testAuthorizedGenerateToken() throws Exception {
		 Role adminRole = new Role();
	     adminRole.setRoleId(1);
	     adminRole.setRoleName("ADMIN");
	   
	     Role userRole = new Role();
	     userRole.setRoleId(2);
	     userRole.setRoleName("USER");
	
	     User user = new User();
	     user.setUsername("admin");
	     user.setPassword("pass");
	     Set<Role> adminRoles = new HashSet<>();
	     adminRoles.add(adminRole);
	     user.setRole(adminRoles);
	    
		UserDetails details = new org.springframework.security.core.userdetails.User(user.getUsername(),
				user.getPassword(), new ArrayList<>());
		when(jwtTokenUtil.generateToken(details)).thenReturn("token");
		when(userDetailsService.loadUserByUsername("admin")).thenReturn(details);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(new JwtRequest("admin", "pass"));
		this.mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(jsonString))
				.andExpect(status().isOk());
	}

	@Test
	void testBadRequest() throws Exception {
		this.mockMvc.perform(post("/login")).andExpect(status().isBadRequest());
	}

	

	@Test
	void textExistingUserAuthenticate() throws Exception {
		Role adminRole = new Role();
	     adminRole.setRoleId(1);
	     adminRole.setRoleName("ADMIN");
	   
	     Role userRole = new Role();
	     userRole.setRoleId(2);
	     userRole.setRoleName("USER");
	
	     User user = new User();
	     user.setUsername("admin");
	     user.setPassword("pass");
	     Set<Role> adminRoles = new HashSet<>();
	     adminRoles.add(adminRole);
	     user.setRole(adminRoles);
	    
		UserDetails details = new org.springframework.security.core.userdetails.User(user.getUsername(),
				user.getPassword(), new ArrayList<>());
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				"admin", "pass");
		when(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("admin", "pass")))
				.thenReturn(usernamePasswordAuthenticationToken);
		when(userDetailsService.loadUserByUsername("admin")).thenReturn(details);
		when(jwtTokenUtil.getUsernameFromToken("token")).thenReturn("admin");
		when(jwtTokenUtil.generateToken(details)).thenReturn("token");
		ObjectMapper mapper = new ObjectMapper();
		mockMvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(new JwtRequest("admin", "pass")))).andExpect(status().isOk());

	}

	
	  
   
}
