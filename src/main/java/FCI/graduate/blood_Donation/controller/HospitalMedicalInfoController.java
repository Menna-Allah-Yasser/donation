package FCI.graduate.blood_Donation.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import FCI.graduate.blood_Donation.service.HospitalMedicalInfoService;

@RestController
@RequestMapping("/api/medical-info-hospital")
@Tag(name = "Hospital Medical Info")
public class HospitalMedicalInfoController {

	
	@Autowired
	private HospitalMedicalInfoService hospitalMedicalInfoService;
	
	
	@PutMapping()
	@Operation(summary = "update hospital stock ")
	public void updateHospitalStock (@RequestParam String email ,@RequestParam String bloodType , @RequestParam int amount) {
		hospitalMedicalInfoService.updateHospitalStock(email, bloodType, amount);
	}
}
