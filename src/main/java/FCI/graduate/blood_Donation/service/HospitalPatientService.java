package FCI.graduate.blood_Donation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.dto.DonorDto;
import FCI.graduate.blood_Donation.dto.HospitalDto;
import FCI.graduate.blood_Donation.entity.DonorPatient;
import FCI.graduate.blood_Donation.entity.HospitalPatient;
import FCI.graduate.blood_Donation.mapper.HospitalMapper;
import FCI.graduate.blood_Donation.repository.HospitalPatientRepo;

@Service
public class HospitalPatientService {
	
	@Autowired
	private HospitalPatientRepo hospitalPatientRepo;
	
	@Autowired
	private HospitalMapper hospitalMapper;
	
	@Autowired
	private HospitalMedicalInfoService hospitalMedicalInfoService;
	
	
	public HospitalDto hospitalAcceptRequest(Long id) {
		hospitalPatientRepo.hospitalAcceptRequest(id);
		
		HospitalPatient hospitalPatient=new HospitalPatient(id);
		hospitalPatient.setStateCode(1);  // hospital Accept Request 
		
		
		HospitalDto hospitalDto=hospitalMapper.map(hospitalPatient.getHospital());
		return hospitalDto;
		
	}
	
	public void hospitalRefusedRequest (Long id) {
		hospitalPatientRepo.hospitalRefusedRequest(id);
	}
	
	public void tookBlood (Long id) {
		
		hospitalPatientRepo.tookBlood(id);
		
		HospitalPatient hospitalPatient=hospitalPatientRepo.findById(id).orElseThrow();
		
		hospitalMedicalInfoService.updateHospitalStock(hospitalPatient.getHospital().getEmail(), hospitalPatient.getPatient().getBloodType(), hospitalPatient.getPatient().getAmount());
	}
	
	
	
	


}
