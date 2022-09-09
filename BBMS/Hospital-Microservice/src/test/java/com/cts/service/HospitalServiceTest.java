package com.cts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.model.BloodRequest;
import com.cts.repository.HospitalRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
class HospitalServiceTest {
	
	@Autowired
	private HospitalService service;
	
	@MockBean
	private HospitalRepository bloodRequestRepository;

	@Test
	public void sendBloodRequestTest() {
		BloodRequest requestDetails = new BloodRequest(1,"NeoLife Hospital","B+","5 units",987654290,"Usha needs B+ blood urgent");
		when(bloodRequestRepository.save(requestDetails)).thenReturn(requestDetails);
		assertEquals(requestDetails,service.sendBloodRequest(requestDetails));
	}

}
