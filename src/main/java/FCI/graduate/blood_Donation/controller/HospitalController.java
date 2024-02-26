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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import FCI.graduate.blood_Donation.entity.Hospital;
import FCI.graduate.blood_Donation.entity.Donor;
import FCI.graduate.blood_Donation.service.HospitalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/Hospitals")
@Tag(name = "Hospital SignUp ")
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalSignUpService;
	
	
	@GetMapping("")
	@Operation(summary = "All avilable Hospitals ")
	public List<Hospital> getAllHospitals(){
		return hospitalSignUpService.getAllHospitals();
	}
	
	@PostMapping("/add")
	@Operation(summary = "Add Hospital")
	public Hospital addHospital(@RequestBody  Hospital hospital) {
		return hospitalSignUpService.addHospital(hospital);
	}
	

	@PutMapping("/update")
	@Operation(summary = "Update Hospital Information ")
	public Hospital updateHospital(@RequestBody Hospital hospital) {
		return hospitalSignUpService.updateHospital(hospital);
	}
	
	@DeleteMapping("/delete/{email}")
	@Operation(summary = "Delate Hospital  ")
	public void deleteHospital(@PathVariable String email) {
		hospitalSignUpService.deleteHospital(email);
	}
	
	@PutMapping("/updatePass")
	public void updatePassword(@RequestParam String email ,@RequestParam String newPass) {
		hospitalSignUpService.updatePassword(email, newPass);
	}

}
