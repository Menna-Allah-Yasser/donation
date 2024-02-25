package FCI.graduate.blood_Donation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.entity.DonorMedicalHistory;
import FCI.graduate.blood_Donation.entity.Donor;
import FCI.graduate.blood_Donation.repository.DonorMedicalHistoryRepo;

@Service
public class DonorMedicalHistoryService {
	
	@Autowired
	private DonorMedicalHistoryRepo userMedicalInfoRepo;
	

	public DonorMedicalHistory getUserByEmail(String email) {
		return userMedicalInfoRepo.findById(email).orElseThrow();
	}
	
	public DonorMedicalHistory addUser(DonorMedicalHistory user) {
		return userMedicalInfoRepo.save(user);
	}
	
	public DonorMedicalHistory updateUser(DonorMedicalHistory user) {
		
		DonorMedicalHistory oldUser=getUserByEmail(user.getEmail());
		
		
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
