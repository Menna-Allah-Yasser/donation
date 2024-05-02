package FCI.graduate.blood_Donation.controller;

import FCI.graduate.blood_Donation.entity.HospitalMedicalInfo;
import FCI.graduate.blood_Donation.entity.HospitalPatient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import FCI.graduate.blood_Donation.dto.HospitalDto;
import FCI.graduate.blood_Donation.service.HospitalPatientService;

import java.util.List;

@RestController
@RequestMapping("/api/hospital-patient")
@Tag(name = "Hospital Patient")
public class HospitalPatientController {

	@Autowired
	private HospitalPatientService hospitalPatientService;

	@GetMapping()
	@Operation(summary = "get all hospital-Patient")
	public List<HospitalPatient> findAll(){
		return hospitalPatientService.findAll();
	}

	@GetMapping("/{email}")
	@Operation(summary = "get all requests that paient sent to hospital")
	public List<HospitalPatient> getPatientReqs (@PathVariable String email){
		return hospitalPatientService.getPatientReqs(email);
	}

	@GetMapping("/hospital")
	@Operation(summary = "get specific state-code requests that hospital received")
	public List<HospitalPatient> getHosReqs (@RequestParam String email ,@RequestParam String stateCode){
		return hospitalPatientService.getHosReqs(email , stateCode);
	}

	@PutMapping()
	@Operation(summary = "update state code")
	public void updateStateCode(@RequestParam Long id, @RequestParam String newState) {
		hospitalPatientService.updateStateCode(id, newState);
	}

	@PostMapping()
	@Operation(summary = "Patient send Request to hospital ")
	public HospitalPatient addRequest(@RequestParam String patientEmail ,@RequestParam String hospitalEmail ,@RequestParam String statCode){
		return hospitalPatientService.addRequest(patientEmail , hospitalEmail , statCode);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "delete request")
	void cancleReqest (@PathVariable Long id){
		hospitalPatientService.cancleReqest(id);
	}

	/*
	 * @PutMapping("/{id}") public HospitalDto hospitalAcceptRequest(@PathVariable
	 * Long id) { return hospitalPatientService.hospitalAcceptRequest(id); }
	 * 
	 * @PutMapping("/refuse/{id}") public void hospitalRefusedRequest (@PathVariable
	 * Long id) { hospitalPatientService.hospitalRefusedRequest(id); }
	 */

	/*
	 * @PutMapping("/took/Blood/{id}") public void tookBlood (@PathVariable Long id)
	 * { hospitalPatientService.tookBlood(id); }
	 */
}
