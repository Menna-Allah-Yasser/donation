package FCI.graduate.blood_Donation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.entity.HospitalSignUp;
import FCI.graduate.blood_Donation.entity.Login;
import FCI.graduate.blood_Donation.repository.HospitalSignUpRepo;
import FCI.graduate.blood_Donation.repository.LoginRepo;

@Service
public class HospitalSignUpService {

	@Autowired
	private HospitalSignUpRepo hospitalSignUpRepo;
	
	@Autowired
	private LoginRepo loginRepo;

	public HospitalSignUp getHospitalByEmail(String email) {
		return hospitalSignUpRepo.findById(email).orElseThrow();
	}

	public List<HospitalSignUp> getAllHospitals() {
		return hospitalSignUpRepo.findAll();
	}

	public HospitalSignUp addHospital(HospitalSignUp hospital) {

		Login login = new Login(hospital.getEmail(), hospital.getPassword());
		hospital.setUserLogin(login);

		return hospitalSignUpRepo.save(hospital);
	}

	public HospitalSignUp updateHospital(HospitalSignUp hospital) {

		HospitalSignUp oldHospital = getHospitalByEmail(hospital.getEmail());
		LoginService loginService = new LoginService();

		if (hospital.getName() == null) {
			hospital.setName(oldHospital.getName());
		}

		if (hospital.getZipCode() == null) {
			hospital.setZipCode(oldHospital.getZipCode());
		}

//		if (hospital.getPassword() == null) {
//			hospital.setPassword(oldHospital.getPassword());
//		} else { // change pass
////			LoginService loginService= new LoginService();
////			Login login = new Login(hospital.getEmail() , hospital.getPassword());
////			loginService.updateLogin(login);
//
//			Login login = new Login(hospital.getEmail(), hospital.getPassword());
//			loginService.updateLogin(login);
//
//		}
		
		if (hospital.getPassword() != null && !hospital.getPassword().isEmpty()) {
	        // Update password in hospital object
	        oldHospital.setPassword(hospital.getPassword());
	        
	        // Create a new Login object with updated email and password
	        Login login = new Login(hospital.getEmail(), hospital.getPassword());
	        
	        // Update password in the login table
	        loginService.updateLogin(login);
	    }
	    else {
	        // If password is not being updated, retain the old password
	        hospital.setPassword(oldHospital.getPassword());
	    }

		if (hospital.getCity() == null) {
			hospital.setCity(oldHospital.getCity());
		}

		if (hospital.getPhone() == null) {
			hospital.setPhone(oldHospital.getPhone());
		}

		if (hospital.getType() == null) {
			hospital.setType(oldHospital.getType());
		}

		if (hospital.getUserLogin() == null) {
			hospital.setUserLogin(oldHospital.getUserLogin());
		}
		return hospitalSignUpRepo.save(hospital);
	}

	public void deleteHospital(String email) {
		hospitalSignUpRepo.deleteById(email);
	}

}
