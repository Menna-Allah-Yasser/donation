package FCI.graduate.blood_Donation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FCI.graduate.blood_Donation.entity.UserSignUp;
import FCI.graduate.blood_Donation.service.UserSignUpService;

@RestController
@RequestMapping("/Users")
public class UserSignUpController {
	
	@Autowired
	private UserSignUpService userSignUpService;
	
	@PostMapping("/add")
	public UserSignUp addUser(@RequestBody UserSignUp user) {
		return userSignUpService.addUser(user);
	}
	
	@PutMapping("/update")
	public UserSignUp updateUser(@RequestBody UserSignUp user) {
		return userSignUpService.updateUser(user);
	}
	
	@DeleteMapping("/delete/{email}")
	public void deleteUser(@PathVariable String email) {
		userSignUpService.deleteUser(email);
	}
	

}
