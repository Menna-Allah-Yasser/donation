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
