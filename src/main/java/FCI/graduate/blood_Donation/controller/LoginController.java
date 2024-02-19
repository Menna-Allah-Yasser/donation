package FCI.graduate.blood_Donation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FCI.graduate.blood_Donation.entity.Login;
import FCI.graduate.blood_Donation.service.LoginService;

@RestController
@RequestMapping("/Login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/add")
	public void addUser(@RequestBody Login user) {
		loginService.saveLogin(user);
	}

}
