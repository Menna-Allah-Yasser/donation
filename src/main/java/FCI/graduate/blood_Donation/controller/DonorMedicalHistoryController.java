package FCI.graduate.blood_Donation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FCI.graduate.blood_Donation.entity.DonorMedicalHistory;
import FCI.graduate.blood_Donation.entity.Donor;
import FCI.graduate.blood_Donation.service.DonorMedicalHistoryService;
import FCI.graduate.blood_Donation.service.DonorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/Medical")
@Tag(name = "Donor Medical History")
public class DonorMedicalHistoryController {

	@Autowired
	private DonorMedicalHistoryService userMedicalInfoService;

	@PostMapping("/add")
	@Operation(summary = "Add User Medical Information")
	public DonorMedicalHistory addUser(@RequestBody DonorMedicalHistory user) {
		return userMedicalInfoService.addUser(user);
	}

	@PutMapping("/update")
	@Operation(summary = "Update User Medical Information")
	public DonorMedicalHistory updateUser(@RequestBody DonorMedicalHistory user) {
		return userMedicalInfoService.updateUser(user);
	}

}
