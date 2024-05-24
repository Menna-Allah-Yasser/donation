package FCI.graduate.blood_Donation.service;

import FCI.graduate.blood_Donation.dto.DonorInfoDto;
import FCI.graduate.blood_Donation.entity.*;
import FCI.graduate.blood_Donation.repository.HospitalRepo;
import FCI.graduate.blood_Donation.repository.PatientRepo;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.dto.DonorDto;
import FCI.graduate.blood_Donation.dto.HospitalDto;
import FCI.graduate.blood_Donation.mapper.HospitalMapper;
import FCI.graduate.blood_Donation.repository.HospitalPatientRepo;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalPatientService {
	
	Logger logger = LoggerFactory.getLogger(HospitalPatientService.class);

	@Autowired
	private HospitalPatientRepo hospitalPatientRepo;

	@Autowired
	private HospitalMapper hospitalMapper;

	@Autowired
	private HospitalMedicalInfoService hospitalMedicalInfoService;

	@Autowired
	private PatientRepo patientRepo;

	@Autowired
	private HospitalRepo hospitalRepo;

	@Autowired
	private DonorService donorService;

	@Autowired
	private HospitalService hospitalService;

	public List<HospitalPatient> findAll(){
		return hospitalPatientRepo.findAll();
	}

	public List<HospitalPatient> getPatientReqs (String email){
		return hospitalPatientRepo.getPatientReqs(email);
	}

	public List<Patient> getHosReqs (String email , String stateCode){
		List<HospitalPatient> hospitalPatients= hospitalPatientRepo.getHosReqs(email , stateCode);
		List<Patient> patients = new ArrayList<>();

		for(HospitalPatient hospitalPatient : hospitalPatients){
			patients.add(hospitalPatient.getPatient());
		}

		return patients;

	}

	public List<DonorInfoDto> getRecivedReqDonors (String email , String stateCode ){
		List<Patient> patients = getHosReqs(email , stateCode);
		List<DonorInfoDto> donors= new ArrayList<>();

		for(Patient i : patients){
			if(i.getType().equals("user"))
				donors.add(donorService.getDonorByEmail(i.getEmail()));

		}
		return donors;
	}

	public List<Hospital> getRecivedReqHospitals (String email , String stateCode){
		List<Patient> patients = getHosReqs(email , stateCode);
		List<Hospital> hospitals= new ArrayList<>();

		for(Patient i : patients){
			if(i.getType().equals("hospital"))
				hospitals.add(hospitalService.getHospitalByEmail(i.getEmail()));

		}
		return hospitals;
	}


	public void updateStateCode(Long id , String newState) {
		hospitalPatientRepo.updateStateCode(id, newState);
	}


	public HospitalPatient addRequest(String patientEmail , String hospitalEmail , String statCode){

		    Patient patient= patientRepo.findById(patientEmail).orElseThrow();
			Hospital hospital = hospitalRepo.findById(hospitalEmail).orElseThrow();

			HospitalPatient hospitalPatient = new HospitalPatient();
			hospitalPatient.setHospital(hospital);
			hospitalPatient.setPatient(patient);
			hospitalPatient.setStateCode(statCode);

			return hospitalPatientRepo.save(hospitalPatient);
	}

	public void cancleReqest (Long id){
		hospitalPatientRepo.deleteById(id);
	}
	/*
	 * public HospitalDto hospitalAcceptRequest(Long id) {
	 * hospitalPatientRepo.hospitalAcceptRequest(id);
	 * 
	 * HospitalPatient hospitalPatient=new HospitalPatient(id);
	 * hospitalPatient.setStateCode(1); // hospital Accept Request
	 * 
	 * 
	 * HospitalDto hospitalDto=hospitalMapper.map(hospitalPatient.getHospital());
	 * return hospitalDto;
	 * 
	 * }
	 * 
	 * public void hospitalRefusedRequest (Long id) {
	 * hospitalPatientRepo.hospitalRefusedRequest(id); }
	 * 
	 * 
	 * public void tookBlood (Long id) {
	 * 
	 * hospitalPatientRepo.tookBlood(id);
	 * 
	 * HospitalPatient
	 * hospitalPatient=hospitalPatientRepo.findById(id).orElseThrow();
	 * 
	 * hospitalMedicalInfoService.updateHospitalStock(hospitalPatient.getHospital().
	 * getEmail(), hospitalPatient.getPatient().getBloodType()); }
	 */

}
