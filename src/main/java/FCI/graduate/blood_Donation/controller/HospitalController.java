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
import FCI.graduate.blood_Donation.dto.HospitalInfoDto;
import FCI.graduate.blood_Donation.entity.Donor;
import FCI.graduate.blood_Donation.service.HospitalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/hospitals")
@Tag(name = "Hospital")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	@GetMapping("")
	@Operation(summary = "All Hospitals ")
	public List<HospitalInfoDto> getAllHospitals() {
		return hospitalService.getAllHospitals();
	}

	@GetMapping("/{email}")
	@Operation(summary = " get hospital by email")
	public Hospital getHospitalByEmail(@PathVariable String email){
		return hospitalService.getHospitalByEmail(email);
	}
	@PostMapping()
	@Operation(summary = "Add Hospital")
	public Hospital addHospital(@RequestBody Hospital hospital) {
		return hospitalService.addHospital(hospital);
	}


	@PutMapping()
	@Operation(summary = "Update Hospital ")
	public Hospital updateHospital(@RequestBody Hospital newHospital){
		return hospitalService.updateHospital(newHospital);
	}

	@PutMapping("/password")
	@Operation(summary = "Update Hospital Password")
	public void updatePassword(@RequestParam String email, @RequestParam String newPass) {
		hospitalService.updatePassword(email, newPass);
	}

	@PutMapping("/phone")
	@Operation(summary = "Update Hospital Phone")
	public void updatePhone(String email, String newPhone) {
		hospitalService.updatePhone(email, newPhone);
	}
	
	@DeleteMapping("/{email}")
	@Operation(summary = "Delate Hospital  ")
	public void deleteHospital(@PathVariable String email) {
		hospitalService.deleteHospital(email);
	}

}
