package FCI.graduate.blood_Donation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.dto.DonorDto;
import FCI.graduate.blood_Donation.entity.Donor;
import FCI.graduate.blood_Donation.entity.DonorPatient;
import FCI.graduate.blood_Donation.entity.Patient;
import FCI.graduate.blood_Donation.mapper.DonorMapper;
import FCI.graduate.blood_Donation.mapper.DonorMapperImpl;
import FCI.graduate.blood_Donation.repository.DonorPatientRepo;

@Service
public class DonorPatientService {

	@Autowired
	private DonorPatientRepo donorPatientRepo;
	
	@Autowired
	private DonorMapper donorMapper;

	public DonorPatient addRequest(DonorPatient donorPatient) {
		return donorPatientRepo.save(donorPatient);
	}

	public DonorDto donorAcceptRequest(Long id) {
		donorPatientRepo.donorAcceptRequest(id);
		
		DonorPatient donorPatient=new DonorPatient(id);
		donorPatient.setStateCode(1);  // Donor Accept Request 
		
		
		DonorDto donorDto=donorMapper.map(donorPatient.getDonor());
		return donorDto;
		
	}
	
	public void donorRefusedRequest (Long id) {
		donorPatientRepo.donorRefusedRequest(id);
	}

}
