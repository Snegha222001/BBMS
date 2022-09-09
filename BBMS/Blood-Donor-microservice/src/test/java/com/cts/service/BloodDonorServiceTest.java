package com.cts.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.model.BloodRequest;
import com.cts.model.DonorDetails;
import com.cts.repository.BloodRequestRepository;
import com.cts.repository.DonorDetailsRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class BloodDonorServiceTest {

	
	
	@Autowired
	private BloodDonorService service;
	
	@Autowired
	private DonorDetailsRepository donorRepo;
	
	@MockBean
	private DonorDetailsRepository donorDetailsRepository;

	@MockBean
	private BloodRequestRepository bloodRequestRepository;
	
	@Test
	public void getDonorsTest() {
		when(donorDetailsRepository.findAll()).thenReturn(Stream.of(new DonorDetails(1,"Snegha","abc","abc@gmail.com","O+",21,987654290,"India","TamilNadu","Chennai","Velachery",55,"Female")).collect(Collectors.toList()));
		assertEquals(1,service.getDonors().size());
	}
	
	@Test
	public void registerDonorTest() {
		DonorDetails details = new DonorDetails(1,"Snegha","abc","abc@gmail.com","O+",21,987654290,"India","TamilNadu","Chennai","Velachery",55,"Female");
		when(donorDetailsRepository.save(details)).thenReturn(details);
		assertEquals(details,service.registerDonor(details));
	}
	
	@Test
	public void getDonorsByIdTest() {
		int id = 1;
		DonorDetails details = new DonorDetails(1,"Snegha","abc","abc@gmail.com","O+",21,987654290,"India","TamilNadu","Chennai","Velachery",55,"Female");
		 doReturn(Optional.of(details)).when(donorDetailsRepository).findById(id);
		assertEquals(1,service.getDonorsById(id).getId());
	}
	
	@Test
	public void searchdonorbykeywordTest() {
		String bloodgroup="O+";
		when(donorDetailsRepository.findByBloodgroupOfDonor(bloodgroup)).thenReturn(Stream.of(new DonorDetails(1,"Snegha","abc","abc@gmail.com","O+",21,987654290,"India","TamilNadu","Chennai","Velachery",55,"Female")).collect(Collectors.toList()));
		assertEquals(1,service.searchdonorbykeyword(bloodgroup).size());
	}
	
	@Test
	public void updateProfileTest() throws Exception {
		DonorDetails details = new DonorDetails(1,"Snegha","abc","abc@gmail.com","O+",21,987654290,"India","TamilNadu","Chennai","Velachery",55,"Female");
		int id=1;
		doReturn(Optional.of(details)).when(donorDetailsRepository).findById(id);
		DonorDetails details1 = new DonorDetails(1,"Snegha","abc","abc@gmail.com","B+",21,987654290,"India","TamilNadu","Chennai","Velachery",55,"Female");
		when(donorDetailsRepository.save(details1)).thenReturn(details1);
		assertEquals(details1,service.updateProfile(1, details1));
	}
	@Test
	public void updateProfileExceptionTest() throws Exception {
		DonorDetails details = new DonorDetails(1,"Snegha","abc","abc@gmail.com","O+",21,987654290,"India","TamilNadu","Chennai","Velachery",55,"Female");
		donorRepo.save(details);
		int id =2;
		DonorDetails updatedDetails = new DonorDetails(1,"Snegha","abc","abc@gmail.com","O+",21,987654290,"India","TamilNadu","Chennai","Velachery",55,"Female");
		assertThrows(Exception.class, () -> {
			service.updateProfile(id, updatedDetails);
		});
	}
	
	@Test
	public void getBloodRequestTest() {
		when(bloodRequestRepository.findAll()).thenReturn(Stream.of(new BloodRequest(1,"NeoLife Hospital","B+","5 units",987654290,"Usha needs B+ blood urgent")).collect(Collectors.toList()));
		assertEquals(1,service.getBloodRequest().size());
	}
	
	@Test
	public void addBloodRequestTest() {
		BloodRequest requestDetails = new BloodRequest(1,"NeoLife Hospital","B+","5 units",987654290,"Usha needs B+ blood urgent");
		when(bloodRequestRepository.save(requestDetails)).thenReturn(requestDetails);
		assertEquals(requestDetails,service.addBloodRequest(requestDetails));
	}
	
}
