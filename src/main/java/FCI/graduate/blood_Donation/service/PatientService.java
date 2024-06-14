package FCI.graduate.blood_Donation.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.entity.Donor;
import FCI.graduate.blood_Donation.entity.DonorPatient;
import FCI.graduate.blood_Donation.entity.Hospital;
import FCI.graduate.blood_Donation.entity.HospitalMedicalInfo;
import FCI.graduate.blood_Donation.entity.HospitalPatient;
import FCI.graduate.blood_Donation.entity.Patient;
import FCI.graduate.blood_Donation.repository.DonorPatientRepo;
import FCI.graduate.blood_Donation.repository.DonorRepo;
import FCI.graduate.blood_Donation.repository.HospitalMedicalInfoRepo;
import FCI.graduate.blood_Donation.repository.HospitalPatientRepo;
import FCI.graduate.blood_Donation.repository.PatientRepo;

@Service
public class PatientService {
	
	Logger logger = LoggerFactory.getLogger(PatientService.class);

	@Autowired
	private PatientRepo patientRepo;

	@Autowired
	private DonorRepo donorRepo;

	@Autowired
	private DonorPatientRepo donorPatientRepo;

	@Autowired
	private HospitalPatientRepo hospitalPatientRepo;

	@Autowired
	private HospitalMedicalInfoRepo hospitalMedicalInfoRepo;


	public void requestBloodFromDonor(Patient patient) {
		patientRepo.save(patient);
		List<Donor> donors = donorRepo.findByBloodType(patient.getBloodType());

		for (Donor i : donors) {

			if (!(i.getEmail().equals(patient.getEmail())) && i.getDonorMedicalHistory().getLegalToDonate()!="false" ) {
				DonorPatient donorPatient = new DonorPatient();
				donorPatient.setDonor(i);
				donorPatient.setPatient(patient);
				donorPatient.setStateCode("pending"); // patient request Blood
				donorPatientRepo.save(donorPatient);
			}

		}
	}

	public void updatePatientBloodType(String email , String bloodType){
		 patientRepo.updatePatientBloodType(email , bloodType);
	}

	public void requestBloodFromHospital(Patient patient) {
		patientRepo.save(patient);
		List<HospitalMedicalInfo> hospitals = hospitalMedicalInfoRepo.findByBloodType(patient.getBloodType());
	
		for (HospitalMedicalInfo i : hospitals) {
			HospitalPatient hospitalPatient = new HospitalPatient();
			hospitalPatient.setStateCode("pending");
			hospitalPatient.setPatient(patient);

			Hospital hospital = new Hospital(i.getEmail());
			hospitalPatient.setHospital(hospital);

			hospitalPatientRepo.save(hospitalPatient);
		}
	
	}

	public void requestBlood(Patient patient) {
		
		requestBloodFromDonor(patient);
		requestBloodFromHospital(patient);
		
	}
	
	

	public List<Patient> getAll() {
		return patientRepo.findAll();

	}



}
