package FCI.graduate.blood_Donation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FCI.graduate.blood_Donation.entity.Donor;
import FCI.graduate.blood_Donation.service.DonorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/Users")
@Tag(name = "User SignUp")
public class DonorController {
	
	@Autowired
	private DonorService userSignUpService;
	
	@PostMapping("/add")
	@Operation(summary = "Add User Personal Information ")
	public Donor addUser(@RequestBody Donor user) {
		return userSignUpService.addUser(user);
	}
	
	@PutMapping("/update")
	@Operation(summary = "Update User Personal Information ")
	public Donor updateUser(@RequestBody Donor user) {
		return userSignUpService.updateUser(user);
	}
	
	@DeleteMapping("/delete/{email}")
	@Operation(summary = "Delete User Personal Information By E-mail")
	public void deleteUser(@PathVariable String email) {
		userSignUpService.deleteUser(email);
	}
	

}
