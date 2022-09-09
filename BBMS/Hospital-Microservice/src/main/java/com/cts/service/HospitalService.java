package com.cts.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.BloodRequest;
import com.cts.repository.HospitalRepository;

@Service
public class HospitalService {
	
	Logger logger = LoggerFactory.getLogger(HospitalService.class);
	
	@Autowired 
	private HospitalRepository hospitalRepository;
	
	public BloodRequest sendBloodRequest(BloodRequest bloodRequest) {
		logger.info("sending a blood request to donor");
		return hospitalRepository.save(bloodRequest);
	}
	

}

