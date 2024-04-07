package FCI.graduate.blood_Donation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import FCI.graduate.blood_Donation.service.DonorPatientService;

@RestController
@RequestMapping("/api/donor-patient")
public class DonorPatientController {

	@Autowired
	private DonorPatientService donorPatientService;


	@PutMapping()
	public void updateStateCode(@RequestParam Long id ,@RequestParam String newState) {
		donorPatientService.updateStateCode(id, newState);
	}
	
	/*
	 * @PutMapping("/statecode/{id}") public DonorDto
	 * donorAcceptRequest(@PathVariable Long id) {
	 * 
	 * return donorPatientService.donorAcceptRequest(id);
	 * 
	 * }
	 * 
	 * @PutMapping("/refuse/{id}") public void donorRefusedRequest (@PathVariable
	 * Long id) { donorPatientService.donorRefusedRequest(id); }
	 * 
	 * @PutMapping("/Confirm/Donation/{id}") public void confirmDonation
	 * (@PathVariable Long id) { donorPatientService.confirmDonation(id); }
	 * 
	 * 
	 * @PutMapping("/Blood/Confirm/{id}") public void bloodConfirmed(@PathVariable
	 * Long id ) { donorPatientService.bloodConfirmed(id); }
	 * 
	 * 
	 * @PutMapping("/Blood/Refused/{id}") public void bloodRefused(@PathVariable
	 * Long id ) { donorPatientService.bloodRefused(id); }
	 */

	
	
}
