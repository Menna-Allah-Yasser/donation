package FCI.graduate.blood_Donation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.repository.HospitalPatientRepo;

@Service
public class HospitalPatientService {
	
	@Autowired
	private HospitalPatientRepo hospitalPatientRepo;
	
	

}
