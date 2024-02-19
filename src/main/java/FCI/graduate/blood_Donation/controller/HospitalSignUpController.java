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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/Hospitals")
@Tag(name = "Hospital SignUp ")
public class HospitalSignUpController {
	
	@Autowired
	private HospitalSignUpService hospitalSignUpService;
	
	
	@GetMapping("")
	@Operation(summary = "All avilable Hospitals ")
	public List<HospitalSignUp> getAllHospitals(){
		return hospitalSignUpService.getAllHospitals();
	}
	
	@PostMapping("/add")
	@Operation(summary = "Add Hospital")
	public HospitalSignUp addHospital(@RequestBody  HospitalSignUp hospital) {
		return hospitalSignUpService.addHospital(hospital);
	}
	

	@PutMapping("/update")
	@Operation(summary = "Update Hospital Information ")
	public HospitalSignUp updateHospital(@RequestBody HospitalSignUp hospital) {
		return hospitalSignUpService.updateHospital(hospital);
	}
	
	@DeleteMapping("/delete/{email}")
	@Operation(summary = "Delate Hospital  ")
	public void deleteHospital(@PathVariable String email) {
		hospitalSignUpService.deleteHospital(email);
	}

}
