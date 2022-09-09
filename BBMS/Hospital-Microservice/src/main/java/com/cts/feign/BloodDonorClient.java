package com.cts.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.model.BloodRequest;
import com.cts.model.DonorDetails;

@FeignClient(name = "donor-service", url = "http://localhost:9000/donor")
//FeignClient(name = "donor-service", url = "bbms-donor-ms-lb-826048484.us-west-1.elb.amazonaws.com/donor")
public interface BloodDonorClient {
	@PostMapping("/addBloodRequest") 
	public BloodRequest addBloodRequest(@RequestBody BloodRequest bloodRequest,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception;
	
	@GetMapping("/searchDonor")
	public List<DonorDetails> searchdonorbykeyword(@RequestParam String bloodgroup,
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) throws Exception;
}
 