package FCI.graduate.blood_Donation.controller;

import FCI.graduate.blood_Donation.entity.Donor;
import FCI.graduate.blood_Donation.entity.HospitalMedicalInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import FCI.graduate.blood_Donation.service.HospitalMedicalInfoService;

import java.util.List;

@RestController
@RequestMapping("/api/hospitals/medical-info")
@Tag(name = "Hospital Medical Info")
public class HospitalMedicalInfoController {

	
	@Autowired
	private HospitalMedicalInfoService hospitalMedicalInfoService;

	@GetMapping()
	@Operation(summary = "get all Hospital-Medical-Info")
	public List<HospitalMedicalInfo> findAll(){
		return hospitalMedicalInfoService.findAll();
	}

	@GetMapping("email/{email}")
	@Operation(summary = " get hospital medical info  by email")
	public HospitalMedicalInfo getHospitalMedicalInfoByEmail(@PathVariable String email){
		return hospitalMedicalInfoService.getHospitalMedicalInfoByEmail(email);
	}
	@PutMapping("/+")
	@Operation(summary = "increment hospital stock ")
	public void incHospitalStock (@RequestParam String email ,@RequestParam String bloodType , @RequestParam int amount) {
		hospitalMedicalInfoService.incHospitalStock(email, bloodType, amount);
	}

	@PutMapping("/-")
	@Operation(summary = "decrement hospital stock ")
	public void decHospitalStock (@RequestParam String email ,@RequestParam String bloodType , @RequestParam int amount) {
		hospitalMedicalInfoService.decHospitalStock(email, bloodType, amount);
	}

	@GetMapping("/{bloodType}")
	@Operation(summary = " get hospital emails that has stock that matches blood-Type required by patient")
	List<String> getMatchBloodType (@PathVariable String bloodType){
		return hospitalMedicalInfoService.getMatchBloodType(bloodType);
	}


}
