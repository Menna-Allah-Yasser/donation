package FCI.graduate.blood_Donation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.entity.HospitalSignUp;
import FCI.graduate.blood_Donation.repository.HospitalSignUpRepo;

@Service
public class HospitalSignUpService {

	@Autowired
	private HospitalSignUpRepo hospitalSignUpRepo;
	
	public HospitalSignUp getHospitalByEmail(String email) {
	  return  hospitalSignUpRepo.findById(email).orElseThrow();
	}
	
	public List<HospitalSignUp> getAllHospitals(){
		return hospitalSignUpRepo.findAll();
	}
	
	public HospitalSignUp addHospital(HospitalSignUp hospital) {
		return hospitalSignUpRepo.save(hospital);
	}
	
	public HospitalSignUp updateHospital(HospitalSignUp hospital) {
		
		HospitalSignUp oldHospital=getHospitalByEmail(hospital.getEmail());
		
		if(hospital.getName()==null) {
			hospital.setName(oldHospital.getName());
		}
		
		if(hospital.getZipCode()==null) {
			hospital.setZipCode(oldHospital.getZipCode());
		}
		
		if(hospital.getPassword()==null) {
			hospital.setPassword(oldHospital.getPassword());
		}
		
		if(hospital.getCity()==null) {
			hospital.setCity(oldHospital.getCity());
		}
		
		
		if(hospital.getPhone()==null) {
			hospital.setPhone(oldHospital.getPhone());
		}
		
		if(hospital.getType()==null) {
			hospital.setType(oldHospital.getType());
		}
		return hospitalSignUpRepo.save(hospital);
	}
	
	public void deleteHospital(String email) {
		hospitalSignUpRepo.deleteById(email);
	}
	
}
