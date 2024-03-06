package FCI.graduate.blood_Donation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FCI.graduate.blood_Donation.dto.DonorDto;
import FCI.graduate.blood_Donation.entity.Donor;
import FCI.graduate.blood_Donation.entity.DonorPatient;
import FCI.graduate.blood_Donation.mapper.DonorMapper;
import FCI.graduate.blood_Donation.service.DonorPatientService;

@RestController
@RequestMapping("/Donor/Patient")
public class DonorPatientController {

	@Autowired
	private DonorPatientService donorPatientService;


	@PutMapping("/statecode/{id}")
	public DonorDto donorAcceptRequest(@PathVariable Long id) {

		return donorPatientService.donorAcceptRequest(id);

	}
	
	@PutMapping("/refuse/{id}")
	public void donorRefusedRequest (@PathVariable Long id) {
		donorPatientService.donorRefusedRequest(id);
	}
	
	@PutMapping("/Confirm/Donation/{id}")
	public void confirmDonation (@PathVariable Long id) {
		donorPatientService.confirmDonation(id);	
	}
	
	
	@PutMapping("/Blood/Confirm/{id}")
	public void  bloodConfirmed(@PathVariable Long id ) {
		donorPatientService.bloodConfirmed(id);
	}
	
	
	@PutMapping("/Blood/Refused/{id}")
	public void  bloodRefused(@PathVariable Long id ) {
		donorPatientService.bloodRefused(id);
	}

	
	
}
