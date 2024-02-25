package FCI.graduate.blood_Donation.service;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.entity.Login;
import FCI.graduate.blood_Donation.entity.Donor;
import FCI.graduate.blood_Donation.entity.DonorMedicalHistory;
import FCI.graduate.blood_Donation.repository.LoginRepo;
import FCI.graduate.blood_Donation.repository.DonorRepo;

@Service
public class DonorService {
	
	@Autowired
	private DonorRepo userSignUpRepo;
	
	@Autowired
	private  LoginRepo loginRepo;
	
	
	public Donor getUserByEmail(String email) {
		return userSignUpRepo.findById(email).orElseThrow();
	}
	
	public Donor addUser(Donor user) {

		Login login = new Login(user.getEmail(), user.getPassword());
		user.setUserLogin(login);
		
		DonorMedicalHistory donorMedicalHistory=new DonorMedicalHistory(user.getEmail());
		user.setDonorMedicalHistory(donorMedicalHistory);

		return userSignUpRepo.save(user);

	}
	
	public Donor updateUser(Donor user) {
		
		Donor oldUser=getUserByEmail(user.getEmail());
		
		if(user.getFirstName()==null) {
			user.setFirstName(oldUser.getFirstName());
		}
		
		if(user.getLastName()==null) {
			user.setLastName(oldUser.getLastName());
		}
		
		if(user.getGender()==null) {
			user.setGender(oldUser.getGender());
		}
		
		if(user.getNationalID()==null) {
			user.setNationalID(oldUser.getNationalID());
		}
		
		if(user.getPassword()==null) {
			user.setPassword(oldUser.getPassword());
		}
		
		if(Integer.compare(user.getAge(), 0)==0) {
			user.setAge(oldUser.getAge());
		}
		
		if(user.getPhone()==null) {
			user.setPhone(oldUser.getPhone());
		}
		
		if(user.getUserLogin()==null) {
			user.setUserLogin(oldUser.getUserLogin());
		}
		
		if(user.getBloodType()==null) {
			user.setBloodType(oldUser.getBloodType());
		}
		
		if(user.getAddress()==null) {
			user.setAddress(oldUser.getAddress());
		}
		
		if(user.getDonorMedicalHistory()==null) {
			user.setDonorMedicalHistory(oldUser.getDonorMedicalHistory());
		}
		
		if(Integer.compare(user.getCountDonates(), 0)==0) {
			user.setCountDonates(oldUser.getCountDonates());
		}
		
		
		return userSignUpRepo.save(user);
	}
	
	public void deleteUser(String email) {
		userSignUpRepo.deleteById(email);
	}
	
	

}
