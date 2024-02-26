package FCI.graduate.blood_Donation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@Tag(name = "User SignUp")
public class DonorController {
	
	@Autowired
	private DonorService donorService;
	
	@PostMapping("/add")
	@Operation(summary = "Add User Personal Information ")
	public Donor addUser(@RequestBody Donor user) {
		return donorService.addUser(user);
	}
	
	@PutMapping("/update")
	@Operation(summary = "Update User Personal Information ")
	public Donor updateUser(@RequestBody Donor user) {
		return donorService.updateUser(user);
	}
	
	@DeleteMapping("/delete/{email}")
	@Operation(summary = "Delete User Personal Information By E-mail")
	public void deleteUser(@PathVariable String email) {
		donorService.deleteUser(email);
	}
	
	@PutMapping("/update/pass")
	public void updatePassword(@RequestParam String email ,@RequestParam String newPass) {
		donorService.updatePassword(email, newPass);
	}
	
	@PutMapping("/update/phone")
	public void updatePhone (@RequestParam String email ,@RequestParam String newPhone) {
		donorService.updatePhone(email, newPhone);
	}
	
	@PutMapping("/update/bloodType")
	public void updateBloodType (@RequestParam String email ,@RequestParam String newBloodType) {
		donorService.updateBloodType(email, newBloodType);
	}
	
	@PutMapping("/update/name")
	public void updateName (@RequestParam String email ,@RequestParam String newFName ,@RequestParam String newLName ) {
		donorService.updateName(email, newFName, newLName);
	}
	

}
