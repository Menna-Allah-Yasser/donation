package FCI.graduate.blood_Donation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FCI.graduate.blood_Donation.entity.HospitalSignUp;
import FCI.graduate.blood_Donation.entity.UserSignUp;
import FCI.graduate.blood_Donation.service.HospitalSignUpService;

@RestController
@RequestMapping("/Hospitals")
public class HospitalSignUpController {
	
	@Autowired
	private HospitalSignUpService hospitalSignUpService;
	
	
	@GetMapping("")
	public List<HospitalSignUp> getAllHospitals(){
		return hospitalSignUpService.getAllHospitals();
	}
	
	@PostMapping("/add")
	public HospitalSignUp addHospital(@RequestBody  HospitalSignUp hospital) {
		return hospitalSignUpService.addHospital(hospital);
	}
	

	@PutMapping("/update")
	public HospitalSignUp updateHospital(@RequestBody HospitalSignUp hospital) {
		return hospitalSignUpService.updateHospital(hospital);
	}
	
	@DeleteMapping("/delete/{email}")
	public void deleteHospital(@PathVariable String email) {
		hospitalSignUpService.deleteHospital(email);
	}

}
