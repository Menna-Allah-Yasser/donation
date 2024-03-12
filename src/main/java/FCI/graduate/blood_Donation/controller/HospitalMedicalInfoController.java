package FCI.graduate.blood_Donation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import FCI.graduate.blood_Donation.service.HospitalMedicalInfoService;

@RestController
@RequestMapping("/api/medical-info-hospital")
public class HospitalMedicalInfoController {

	
	@Autowired
	private HospitalMedicalInfoService hospitalMedicalInfoService;
	
	
	@PutMapping()
	public void updateHospitalStock (@RequestParam String email ,@RequestParam String bloodType , @RequestParam int amount) {
		hospitalMedicalInfoService.updateHospitalStock(email, bloodType, amount);
	}
}
