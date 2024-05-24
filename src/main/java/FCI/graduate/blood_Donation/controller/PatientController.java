package FCI.graduate.blood_Donation.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import FCI.graduate.blood_Donation.entity.Patient;
import FCI.graduate.blood_Donation.service.PatientService;

@RestController
@RequestMapping("/api/patients")
@Tag(name = "Patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@GetMapping()
	@Operation(summary = "all patients")
	public  List<Patient> getAllPatients () {
		return patientService.getAll();
	}
	
	@PostMapping("/request-blood")
	@Operation(summary = "request blood from donors & hospitals")
	public void requestBlood(@RequestBody Patient patient) {

		patientService.requestBlood(patient);
	}
	
	@PostMapping("/request-blood-from-donor")
	@Operation(summary = "request blood from donors")
	public void requestBloodFromDonor(@RequestBody Patient patient) {
		patientService.requestBloodFromDonor(patient);
	}
	
	@PostMapping("/request-blood-from-hospital")
	@Operation(summary = "request blood from hospitals")
	public void requestBloodFromHospital(@RequestBody Patient patient) {
		patientService.requestBloodFromHospital(patient);
	}

	@PutMapping("/{email}/{bloodType}")
	public void updatePatientBloodType(@PathVariable String email ,@PathVariable String bloodType){
		 patientService.updatePatientBloodType(email , bloodType);
	}
	
	
	
}
