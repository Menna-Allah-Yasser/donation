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
@Tag(name = "Hospital")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	@GetMapping("")
	@Operation(summary = "All avilable Hospitals ")
	public List<Hospital> getAllHospitals() {
		return hospitalService.getAllHospitals();
	}

	@PostMapping("/add")
	@Operation(summary = "Add Hospital")
	public Hospital addHospital(@RequestBody Hospital hospital) {
		return hospitalService.addHospital(hospital);
	}

	@DeleteMapping("/delete/{email}")
	@Operation(summary = "Delate Hospital  ")
	public void deleteHospital(@PathVariable String email) {
		hospitalService.deleteHospital(email);
	}

	@PutMapping("/update/pass")
	@Operation(summary = "Update Hospital Password")
	public void updatePassword(@RequestParam String email, @RequestParam String newPass) {
		hospitalService.updatePassword(email, newPass);
	}

	@PutMapping("/update/phone")
	@Operation(summary = "Update Hospital Phone")
	public void updatePhone(String email, String newPhone) {
		hospitalService.updatePhone(email, newPhone);
	}

}
