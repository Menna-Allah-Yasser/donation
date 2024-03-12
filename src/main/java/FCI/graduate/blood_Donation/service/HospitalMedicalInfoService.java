package FCI.graduate.blood_Donation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.repository.HospitalMedicalInfoRepo;

@Service
public class HospitalMedicalInfoService {
	
	
	@Autowired
	private HospitalMedicalInfoRepo hospitalMedicalInfoRepo;
	
	Logger logger=LoggerFactory.getLogger(HospitalMedicalInfoService.class);
	
	public void updateHospitalStock (String email , String bloodType ,  int amount) {
		
		logger.info("email is {}  and Blood Type is {}  and amount is {}" , email , bloodType , amount);
		hospitalMedicalInfoRepo.updateHospitalCounters(email, bloodType, amount);
	}

}
