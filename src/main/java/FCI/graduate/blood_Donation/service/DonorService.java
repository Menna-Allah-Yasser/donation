package FCI.graduate.blood_Donation.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.entity.Login;
import FCI.graduate.blood_Donation.entity.Patient;
import FCI.graduate.blood_Donation.entity.Donor;
import FCI.graduate.blood_Donation.entity.DonorMedicalHistory;
import FCI.graduate.blood_Donation.repository.LoginRepo;
import FCI.graduate.blood_Donation.repository.DonorRepo;

@Service
public class DonorService {

	@Autowired
	private DonorRepo donorRepo;

	@Autowired
	private LoginRepo loginRepo;

	public Donor getDonorByEmail(String email) {
		return donorRepo.findById(email).orElseThrow();
	}

	public Donor addDonor(Donor user) {

		Login login = new Login(user.getEmail(), user.getPassword());
		user.setUserLogin(login);

		DonorMedicalHistory donorMedicalHistory = new DonorMedicalHistory(user.getEmail());
		user.setDonorMedicalHistory(donorMedicalHistory);
		
		Patient patient= new Patient(user.getEmail());
		user.setPatient(patient);

		return donorRepo.save(user);

	}

	public void updatePassword(String email, String newPass) {
		loginRepo.updatePassword(email, newPass);
		donorRepo.updatePassword(email, newPass);
	}

	public void updatePhone(String email, String newPhone) {
		donorRepo.updatePhone(email, newPhone);
	}

	public void updateBloodType(String email, String newBloodType) {
		donorRepo.updateBloodType(email, newBloodType);
	}

	public void updateName(String email, String newFName, String newLName) {
		donorRepo.updateName(email, newFName, newLName);
	}

	public void deleteUser(String email) {
		donorRepo.deleteById(email);
	}
	
	public List<Donor> findByBloodType(String bloodType) {
		return donorRepo.findByBloodType(bloodType);
	}

}
