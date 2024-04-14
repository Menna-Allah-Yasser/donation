package FCI.graduate.blood_Donation.controller;

import java.time.LocalDate;

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

import FCI.graduate.blood_Donation.entity.DonorMedicalHistory;
import FCI.graduate.blood_Donation.entity.Donor;
import FCI.graduate.blood_Donation.service.DonorMedicalHistoryService;
import FCI.graduate.blood_Donation.service.DonorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/medical-history")
@Tag(name = "Donor Medical History")
public class DonorMedicalHistoryController {

	@Autowired
	private DonorMedicalHistoryService userMedicalInfoService;

	@GetMapping("/{email}")
	@Operation(summary = "get Donor Medical History By Email")
	public DonorMedicalHistory getDonorMedicalHistoryByEmail(@PathVariable String email) {
		return userMedicalInfoService.getUserByEmail(email);
	}

	@PostMapping()
	@Operation(summary = "Add Donor Medical Information")
	public DonorMedicalHistory addDonorMedicalHistory(@RequestBody DonorMedicalHistory user) {
		return userMedicalInfoService.addUser(user);
	}

	@PutMapping()
	@Operation(summary = "Update Donor Medical Information")
	public DonorMedicalHistory updateDonorMedicalHistory(@RequestBody DonorMedicalHistory user) {
		return userMedicalInfoService.updateUser(user);
	}

	@PutMapping("/last-donate-time")
	@Operation(summary = "update Last Donate_Time")
	public void updateLastDonateTime(@RequestParam String email, @RequestParam LocalDate date) {
		userMedicalInfoService.updateLastDonateTime(email, date);
	}

	@PutMapping("/note")
	@Operation(summary = "update Note")
	public void updateNote(@RequestParam String email, @RequestParam String note) {
		userMedicalInfoService.updateNote(email, note);
	}

	@PutMapping("/surgery")
	@Operation(summary = "update surgery state")
	public void updateSurgey(@RequestParam String email, @RequestParam String surgery) {
		userMedicalInfoService.updateSurgery(email, surgery);
	}

	@PutMapping("/dentist")
	@Operation(summary = "update dentist state")
	public void updateDentist(@RequestParam String email, @RequestParam String dentist) {
		userMedicalInfoService.updateDentist(email, dentist);
	}

	@PutMapping("/chronic")
	@Operation(summary = "update chronic disease state")
	public void updateChronicDisease(@RequestParam String email, @RequestParam String chronicDisease) {
		userMedicalInfoService.updateChronicDisease(email, chronicDisease);
	}
	
	@PutMapping("/legal-to-donate")
	@Operation(summary = "update legal_to_donate state")
	public void updateLegalToDonate(@RequestParam String email) {
		userMedicalInfoService.updateLegalToDonate(email);
	}


	@GetMapping("update/{email}")
	public void updateMedicalHistoryEvery3Months(@PathVariable String email){
		userMedicalInfoService.updateMedicalHistoryEvery3Months(email);
	}
}
