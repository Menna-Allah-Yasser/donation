package FCI.graduate.blood_Donation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.entity.UserMedicalInfo;
import FCI.graduate.blood_Donation.entity.UserSignUp;
import FCI.graduate.blood_Donation.repository.UserMedicalInfoRepo;

@Service
public class UserMedicalInfoService {
	
	@Autowired
	private UserMedicalInfoRepo userMedicalInfoRepo;
	

	public UserMedicalInfo getUserByEmail(String email) {
		return userMedicalInfoRepo.findById(email).orElseThrow();
	}
	
	public UserMedicalInfo addUser(UserMedicalInfo user) {
		return userMedicalInfoRepo.save(user);
	}
	
	public UserMedicalInfo updateUser(UserMedicalInfo user) {
		
		UserMedicalInfo oldUser=getUserByEmail(user.getEmail());
		
		if(user.getBloodType()==null) {
			user.setBloodType(oldUser.getBloodType());
		}
		
		if(user.getLastDonateTime()==null) {
			user.setLastDonateTime(oldUser.getLastDonateTime());
		}
		
		if(user.getNote()==null) {
			user.setNote(oldUser.getNote());
		}
		
		
		if(user.getChronicDisease()==null) {
			user.setChronicDisease(oldUser.getChronicDisease());
		}
		
		if(user.getDentist()==null) {
			user.setDentist(oldUser.getDentist());
		}
		
		if(user.getSurgery()==null) {
			user.setSurgery(oldUser.getSurgery());
		}
		
		return userMedicalInfoRepo.save(user);
	}
	


}
