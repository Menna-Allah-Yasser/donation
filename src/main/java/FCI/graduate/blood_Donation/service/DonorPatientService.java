package FCI.graduate.blood_Donation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.entity.Donor;
import FCI.graduate.blood_Donation.entity.DonorPatient;
import FCI.graduate.blood_Donation.entity.Patient;
import FCI.graduate.blood_Donation.repository.DonorPatientRepo;

@Service
public class DonorPatientService {
	
	@Autowired
	private DonorPatientRepo donorPatientRepo;
	
	DonorPatient addRequest(DonorPatient donorPatient) {
		return donorPatientRepo.save(donorPatient);
	}

}
