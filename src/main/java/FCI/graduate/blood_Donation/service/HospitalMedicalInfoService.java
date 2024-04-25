package FCI.graduate.blood_Donation.service;

import FCI.graduate.blood_Donation.entity.Donor;
import FCI.graduate.blood_Donation.entity.HospitalMedicalInfo;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.repository.HospitalMedicalInfoRepo;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalMedicalInfoService {
	
	Logger logger = LoggerFactory.getLogger(HospitalMedicalInfoService.class);
	
	@Autowired
	private HospitalMedicalInfoRepo hospitalMedicalInfoRepo;


	public List<HospitalMedicalInfo> findAll(){
		return hospitalMedicalInfoRepo.findAll();
	}

	public HospitalMedicalInfo getHospitalMedicalInfoByEmail(String email){
		return hospitalMedicalInfoRepo.findById(email).orElseThrow();
	}
	
	public void incHospitalStock (String email , String bloodType ,  int amount) {
		
		logger.info("email is {}  and Blood Type is {}  and amount is {}" , email , bloodType , amount);
		hospitalMedicalInfoRepo.incHospitalCounter(email, bloodType, amount);
	}

	public void decHospitalStock (String email , String bloodType ,  int amount) {

		logger.info("email is {}  and Blood Type is {}  and amount is {}" , email , bloodType , amount);
		hospitalMedicalInfoRepo.decHospitalCounter(email, bloodType, amount);
	}

	public List<String> getMatchBloodType (String bloodType){
		List<HospitalMedicalInfo> hospitalMedicalInfos =hospitalMedicalInfoRepo.getMatchBloodType(bloodType);
		List <String> emails = new ArrayList<>();
		for(HospitalMedicalInfo i : hospitalMedicalInfos){
			emails.add(i.getEmail());
		}
		return emails;
	}

}
