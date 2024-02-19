package FCI.graduate.blood_Donation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.entity.Login;
import FCI.graduate.blood_Donation.entity.UserMedicalInfo;
import FCI.graduate.blood_Donation.entity.UserSignUp;
import FCI.graduate.blood_Donation.repository.LoginRepo;

@Service
public class LoginService {

	@Autowired
	private LoginRepo loginRepo;

	public Login getUserByEmail(String email) {
		return loginRepo.findById(email).orElseThrow();
	}

	public Login saveLogin(Login login) {
		return loginRepo.save(login);
	}

	public Login findByEmail(String email) {
		return loginRepo.findById(email).orElse(null);
	}

	public Login updateLogin(Login login) {

//		Login oldLogin  = getUserByEmail(login.getEmail());
//		
//		if(login.getPassword()==null) {
//			login.setPassword(oldLogin.getPassword());
//		}

		return loginRepo.save(login);
	}

}
