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

import FCI.graduate.blood_Donation.entity.Donor;
import FCI.graduate.blood_Donation.service.DonorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/Donor")
@Tag(name = "Donor")
public class DonorController {

	@Autowired
	private DonorService donorService;

	@PostMapping("/add")
	@Operation(summary = "Add Donor Personal Information ")
	public Donor addDonor(@RequestBody Donor user) {
		return donorService.addDonor(user);
	}

	@DeleteMapping("/delete/{email}")
	@Operation(summary = "Delete Donor Personal Information By E-mail")
	public void deleteDonor(@PathVariable String email) {
		donorService.deleteUser(email);
	}

	@PutMapping("/update/pass")
	@Operation(summary = "Update Donor's Password By E-mail")
	public void updatePassword(@RequestParam String email, @RequestParam String newPass) {
		donorService.updatePassword(email, newPass);
	}

	@PutMapping("/update/phone")
	@Operation(summary = "Update Donor's Phone By E-mail")
	public void updatePhone(@RequestParam String email, @RequestParam String newPhone) {
		donorService.updatePhone(email, newPhone);
	}

	@PutMapping("/update/bloodType")
	@Operation(summary = "Update Donor's Blood Type By E-mail")
	public void updateBloodType(@RequestParam String email, @RequestParam String newBloodType) {
		donorService.updateBloodType(email, newBloodType);
	}

	@PutMapping("/update/name")
	@Operation(summary = "Update Donor's Name By E-mail")
	public void updateName(@RequestParam String email, @RequestParam String newFName, @RequestParam String newLName) {
		donorService.updateName(email, newFName, newLName);
	}
	
	@GetMapping("/BloodType/{bloodType}")
	public List<Donor> findByBloodType( @PathVariable  String bloodType) {
		return donorService.findByBloodType(bloodType);
	}

}
