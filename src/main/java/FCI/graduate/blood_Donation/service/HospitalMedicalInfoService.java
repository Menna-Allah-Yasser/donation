package FCI.graduate.blood_Donation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.repository.HospitalMedicalInfoRepo;

@Service
public class HospitalMedicalInfoService {
	
	
	@Autowired
	private HospitalMedicalInfoRepo hospitalMedicalInfoRepo;
	
	public void updateHospitalStock (String email , String bloodType ,  int amount) {
		hospitalMedicalInfoRepo.updateHospitalStock(email, bloodType, amount);
	}

}
