package FCI.graduate.blood_Donation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import FCI.graduate.blood_Donation.entity.Login;
import FCI.graduate.blood_Donation.service.LoginService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/Login")
@Tag(name = "Login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/add")
	public void addUser(@RequestBody Login user) {
		loginService.saveLogin(user);
	}

	@PutMapping("/updatePassword")
	public Login updateLogin(@RequestBody Login login) {

		return loginService.updateLogin(login);
	}

	@PutMapping("/update")
	public void updatePassword(@RequestParam String email, @RequestParam String newPass) {
		loginService.updatePassword(email, newPass);
	}

}
