package FCI.graduate.blood_Donation.controller;

import FCI.graduate.blood_Donation.dto.DonorInfoDto;
import FCI.graduate.blood_Donation.entity.DonorPatient;
import FCI.graduate.blood_Donation.entity.Hospital;
import FCI.graduate.blood_Donation.entity.Patient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.antlr.v4.runtime.misc.Pair;
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

	@GetMapping("/{email}")
	@Operation(summary = "get all requests that paient sent to donor")
	public List<DonorPatient> getPatientReqs (@PathVariable String email){
		return donorPatientService.getPatientReqs(email);
	}

	@GetMapping("/donor")
	@Operation(summary = "get specific state-code requests that donor received")
	public List<Patient> getDonorReqs (@RequestParam String donorEmail , @RequestParam String stateCode){
		return donorPatientService.getDonorReqs(donorEmail , stateCode);
	}

	@GetMapping("/user")
	@Operation(summary = "get specific state-code user requests that donor received")
	public List<Pair<DonorInfoDto , String >> getRecivedReqDonors (@RequestParam String donorEmail , @RequestParam String stateCode){
		return donorPatientService.getRecivedReqDonors(donorEmail , stateCode);
	}

	@GetMapping("/hospital")
	@Operation(summary = "get specific state-code hospital requests that donor received")
	public List<Pair <Hospital , String >> getRecivedReqHospitals (@RequestParam String donorEmail , @RequestParam String stateCode){
		return donorPatientService.getRecivedReqHospitals(donorEmail , stateCode);
	}

	@PutMapping()
	@Operation(summary = "update state_code")
	public void updateStateCode(@RequestParam Long id ,@RequestParam String newState) {
		donorPatientService.updateStateCode(id, newState);
	}

	@PostMapping()
	@Operation(summary = "patient send request to donor")
	public DonorPatient sendRequest(@RequestParam String patientEmail ,@RequestParam String donorEmail ,@RequestParam String statCode) {

		return donorPatientService.addRequest(patientEmail, donorEmail, statCode);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "delete request")
	public void cancleReqest (@PathVariable Long id){
		donorPatientService.cancleReqest(id);
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
