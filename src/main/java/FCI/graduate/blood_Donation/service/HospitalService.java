package FCI.graduate.blood_Donation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.entity.Hospital;
import FCI.graduate.blood_Donation.entity.HospitalMedicalInfo;
import FCI.graduate.blood_Donation.entity.Login;
import FCI.graduate.blood_Donation.repository.HospitalRepo;
import FCI.graduate.blood_Donation.repository.LoginRepo;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepo hospitalSignUpRepo;

	@Autowired
	private LoginRepo loginRepo;

	public Hospital getHospitalByEmail(String email) {
		return hospitalSignUpRepo.findById(email).orElseThrow();
	}

	public List<Hospital> getAllHospitals() {
		return hospitalSignUpRepo.findAll();
	}

	public Hospital addHospital(Hospital hospital) {

		Login login = new Login(hospital.getEmail(), hospital.getPassword());
		hospital.setUserLogin(login);
		
		HospitalMedicalInfo hospitalMedicalInfo= new  HospitalMedicalInfo(hospital.getEmail() , 0 , 0 , 0 , 0 , 0 , 0  , 0 , 0);
        hospital.setHospitalMedicalInfo(hospitalMedicalInfo);
        
		return hospitalSignUpRepo.save(hospital);
	}

	public Hospital updateHospital(Hospital hospital) {

		Hospital oldHospital = getHospitalByEmail(hospital.getEmail());
		LoginService loginService = new LoginService();

		if (hospital.getName() == null) {
			hospital.setName(oldHospital.getName());
		}

		if (hospital.getZipCode() == null) {
			hospital.setZipCode(oldHospital.getZipCode());
		}

		/*
		 * if (hospital.getPassword() == null) {
		 * hospital.setPassword(oldHospital.getPassword()); } else { Login login = new
		 * Login(hospital.getEmail(), hospital.getPassword());
		 * loginService.updateLogin(login);
		 * 
		 * }
		 */

		/*
		 * if (hospital.getPassword() == null) {
		 * hospital.setPassword(oldHospital.getPassword()); } else { if
		 * (!hospital.getPassword().equals(oldHospital.getPassword())) { // Update
		 * password in hospital object oldHospital.setPassword(hospital.getPassword());
		 * 
		 * // Create a new Login object with updated email and password Login login =
		 * new Login(hospital.getEmail(), hospital.getPassword());
		 * 
		 * // Update password in the login table loginService.updateLogin(login); } }
		 */

		/*
		 * if (hospital.getPassword() != null && !hospital.getPassword().isEmpty() ) {
		 * // Update password in hospital object
		 * oldHospital.setPassword(hospital.getPassword());
		 * 
		 * // Create a new Login object with updated email and password Login login =
		 * new Login(hospital.getEmail(), hospital.getPassword());
		 * 
		 * // Update password in the login table loginService.updateLogin(login); } else
		 * { // If password is not being updated, retain the old password
		 * hospital.setPassword(oldHospital.getPassword()); }
		 */

		if (hospital.getPassword() == null) {
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
			/*
			 * if(hospital.getPassword() != null) { Login login=new
			 * Login(hospital.getEmail(), hospital.getPassword());
			 * loginService.updateLogin(login);
			 * 
			 * }
			 */
			hospital.setUserLogin(oldHospital.getUserLogin());
		}
		return hospitalSignUpRepo.save(hospital);
	}

	public void deleteHospital(String email) {
		hospitalSignUpRepo.deleteById(email);
	}

}
