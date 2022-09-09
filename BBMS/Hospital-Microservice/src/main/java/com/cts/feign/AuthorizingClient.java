package com.cts.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "Authentication-Microservice", url = "http://localhost:9001/auth")
//@FeignClient(name = "Authentication-Microservice", url = "bbms-auth-ms-lb-592536383.us-west-1.elb.amazonaws.com/auth")
public interface AuthorizingClient { 
	
	@PostMapping("/validateAdmin")
	public boolean authorizeTheRequestforAdmin(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader);
	
	
	
	 

}