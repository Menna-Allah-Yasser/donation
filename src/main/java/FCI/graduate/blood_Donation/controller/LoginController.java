package FCI.graduate.blood_Donation.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import FCI.graduate.blood_Donation.entity.Login;
import FCI.graduate.blood_Donation.service.LoginService;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/login")
@Tag(name = "Login -NOT COMPLETED-")
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
	@Operation(summary = "update password")
	public void updatePassword(@RequestParam String email, @RequestParam String newPass) {
		loginService.updatePassword(email, newPass);
	}
	
	@GetMapping("")
	@Operation(summary = "authentication")
	public void authen(@RequestParam String email ,@RequestParam String password) {
		 loginService.authen(email, password);
	}


	@GetMapping("/emails")
	@Operation(summary = "get all e-mails in system")
	public List<String> getAllEmails(){
		return loginService.getAllEmails();
	}

	@GetMapping("/donors-emails")
	@Operation(summary = "get all donors e-mails in system")
	public List<String> getDonorsEmails(){
		return loginService.getDonorsEmails();
	}

	@GetMapping("/hospitals-emails")
	@Operation(summary = "get all hospitals e-mails in system")
	public List<String> getHospitalsEmails(){
		return loginService.getHospitalsEmails();
	}

	@GetMapping("/banks-emails")
	@Operation(summary = "get all  banks e-mails in system")
	public List<String> getBanksEmails(){
		return loginService.getBanksEmails();
	}

}
