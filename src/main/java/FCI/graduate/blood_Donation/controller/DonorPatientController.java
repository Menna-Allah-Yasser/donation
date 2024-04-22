package FCI.graduate.blood_Donation.controller;

import FCI.graduate.blood_Donation.entity.DonorPatient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import FCI.graduate.blood_Donation.service.DonorPatientService;

import java.util.List;

@RestController
@RequestMapping("/api/donor-patient")
@Tag(name = "Donor Patient")
public class DonorPatientController {

	@Autowired
	private DonorPatientService donorPatientService;


	@GetMapping()
	@Operation(summary = "get all donor-patirnt")
	public List<DonorPatient> findAll(){
		return donorPatientService.findAll();
	}
	@PutMapping()
	@Operation(summary = "update state_code")
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
