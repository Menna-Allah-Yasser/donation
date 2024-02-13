package FCI.graduate.blood_Donation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FCI.graduate.blood_Donation.entity.UserMedicalInfo;
import FCI.graduate.blood_Donation.entity.UserSignUp;
import FCI.graduate.blood_Donation.service.UserMedicalInfoService;
import FCI.graduate.blood_Donation.service.UserSignUpService;

@RestController
@RequestMapping("/Medical")
public class UserMedicalInfoController {
	
	@Autowired
	private UserMedicalInfoService userMedicalInfoService;
	
	@PostMapping("/add")
	public UserMedicalInfo addUser(@RequestBody UserMedicalInfo user) {
		return userMedicalInfoService.addUser(user);
	}
	
	@PutMapping("/update")
	public UserMedicalInfo updateUser(@RequestBody UserMedicalInfo user) {
		return userMedicalInfoService.updateUser(user);
	}
	

}
