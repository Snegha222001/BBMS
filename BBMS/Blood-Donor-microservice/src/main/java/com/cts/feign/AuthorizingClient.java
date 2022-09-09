package com.cts.feign;

import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.model.DonorDetails;
import com.cts.model.User;


@FeignClient(name = "Authentication-Microservice", url = "http://localhost:9001/auth")
//@FeignClient(name = "Authentication-Microservice", url = "bbms-auth-ms-lb-592536383.us-west-1.elb.amazonaws.com/auth")
public interface AuthorizingClient { 
	
	@PostMapping("/validateUser")
	public boolean authorizeTheRequestforUser(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader);
	
	@PostMapping("/validateAdmin")
	public boolean authorizeTheRequestforAdmin(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader);
	
	@PostMapping({"/registerNewUser"}) 
	public User registerNewUser(@RequestBody DonorDetails donorDetails);
	


}