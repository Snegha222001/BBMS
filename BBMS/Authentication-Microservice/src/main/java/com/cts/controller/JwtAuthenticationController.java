package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.JwtRequest;
import com.cts.model.JwtResponse;
import com.cts.service.JwtUserDetailsService;
import com.cts.util.JwtUtil;


@RestController
@CrossOrigin(origins="http://localhost:3000") 
public class JwtAuthenticationController {
	
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	
	
	@PostMapping(value = "/login")
	public JwtResponse createAuthenticationToken(@RequestBody JwtRequest jwtRequest)throws Exception
		{
			return jwtUserDetailsService.createJwtToken(jwtRequest);
		}
	
	

    
}
