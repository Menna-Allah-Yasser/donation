package FCI.graduate.blood_Donation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import FCI.graduate.blood_Donation.entity.Patient;
import FCI.graduate.blood_Donation.service.PatientService;

@RestController
@RequestMapping("/Patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@GetMapping()
	public  List<Patient> getAllPatients () {
		return patientService.getAll();
	}
	
	@PostMapping("/Request/Blood")
	public void requestBlood(@RequestBody Patient patient) {
		patientService.requestBlood(patient);
	}
	
	@PostMapping("/RequestBlood/Donor")
	public void requestBloodFromDonor(@RequestBody Patient patient) {
		patientService.requestBloodFromDonor(patient);
	}
	
	@PostMapping("/RequestBlood/Hospital")
	public void requestBloodFromHospital(@RequestBody Patient patient) {
		patientService.requestBloodFromHospital(patient);
	}
	
	
	
	
}
