package FCI.graduate.blood_Donation.service;

import java.time.LocalDate;
import java.util.Date;

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
	
	
	public void updateLastDonateTime (String email , LocalDate date ){
		userMedicalInfoRepo.updateLastDonateTime(email, date);
		userMedicalInfoRepo.updateLastUpdate(email, LocalDate.now());
	}
	
	public void updateNote (String email , String note ) {
		userMedicalInfoRepo.updateNote(email, note);
	}
	
	public void updateSurgery (String email , String surgery) {
		userMedicalInfoRepo.updateSurgery(email, surgery);	
		userMedicalInfoRepo.updateLastUpdate(email, LocalDate.now());
	}
	

	public void updateDentist (String email , String dentist) {
		userMedicalInfoRepo.updateDentist(email, dentist);	
		userMedicalInfoRepo.updateLastUpdate(email, LocalDate.now());
	}
	

	public void updateLastUpdate (String email , LocalDate lastUpdate) {
		userMedicalInfoRepo.updateLastUpdate(email, lastUpdate);	
	}
	

	public void updateChronicDisease(String email, String chronicDisease) {
		userMedicalInfoRepo.updateChronicDisease(email, chronicDisease);
		userMedicalInfoRepo.updateLegalToDonate(email, 0);
	}

	
	


}
