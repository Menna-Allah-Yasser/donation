package FCI.graduate.blood_Donation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.entity.Login;
import FCI.graduate.blood_Donation.entity.DonorMedicalHistory;
import FCI.graduate.blood_Donation.entity.Donor;
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

		return loginRepo.save(login);
	}
	
	public void updatePassword(String email , String newPass) {
		loginRepo.updatePassword(email, newPass);
	}

}
