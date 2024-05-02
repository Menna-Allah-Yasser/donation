package FCI.graduate.blood_Donation.service;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import FCI.graduate.blood_Donation.entity.*;
import FCI.graduate.blood_Donation.repository.DonorRepo;
import FCI.graduate.blood_Donation.repository.PatientRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.mapper.DonorMapper;
import FCI.graduate.blood_Donation.repository.DonorPatientRepo;




@Service
public class DonorPatientService {
	
	Logger logger = LoggerFactory.getLogger(DonorPatientService.class);

	@Autowired
	private DonorPatientRepo donorPatientRepo;
	
	@Autowired
	private DonorMapper donorMapper;

	@Autowired
	private PatientRepo patientRepo;

	@Autowired
	private DonorRepo donorRepo;
	
	/*
	 * @Autowired private DonorService donorService;
	 */
	/*
	 * @Autowired private DonorMedicalHistoryService donorMedicalHistoryService;
	 */
	public List<DonorPatient> findAll(){
		return donorPatientRepo.findAll();
	}

	/*public DonorPatient addRequest(DonorPatient donorPatient) {

		return donorPatientRepo.save(donorPatient);
	}*/

	public List<DonorPatient> getPatientReqs (String email){
		return donorPatientRepo.getPatientReqs(email);
	}

	public List<DonorPatient> getDonorReqs (String email , String stateCode){
		return donorPatientRepo.getDonorReqs(email , stateCode);
	}

	public DonorPatient addRequest(String patientEmail , String donorEmail , String statCode){

		Patient patient= patientRepo.findById(patientEmail).orElseThrow();
		Donor donor = donorRepo.findById(donorEmail).orElseThrow();

		DonorPatient donorPatient = new DonorPatient();
		donorPatient.setDonor(donor);
		donorPatient.setPatient(patient);
		donorPatient.setStateCode(statCode);

		return donorPatientRepo.save(donorPatient);
	}
	
	public void updateStateCode(Long id , String newState) {
		donorPatientRepo.updateStateCode(id, newState);
	}

	public void cancleReqest (Long id){
		donorPatientRepo.deleteById(id);
	}
	/*
	 * public DonorDto donorAcceptRequest(Long id) {
	 * donorPatientRepo.donorAcceptRequest(id);
	 * 
	 * DonorPatient donorPatient=new DonorPatient(id); donorPatient.setStateCode(1);
	 * // Donor Accept Request
	 * 
	 * 
	 * DonorDto donorDto=donorMapper.map(donorPatient.getDonor()); return donorDto;
	 * 
	 * }
	 * 
	 * public void donorRefusedRequest (Long id) {
	 * donorPatientRepo.donorRefusedRequest(id); }
	 * 
	 * public void confirmDonation (Long id) { // update state Code to set = 2
	 * donorPatientRepo.confirmDonation(id);
	 * 
	 * 
	 * // update count Donates DonorPatient
	 * donorPatient=donorPatientRepo.findById(id).orElseThrow(); int count
	 * =donorService.getCountDonates(donorPatient.getDonor().getEmail()); count++;
	 * donorPatient.getDonor().setCountDonates(count);
	 * donorService.updateCountDonates(donorPatient.getDonor().getEmail(), count);
	 * 
	 * // update last Donation time
	 * donorMedicalHistoryService.updateLastDonateTime(donorPatient.getDonor().
	 * getEmail(), LocalDate.now());
	 * 
	 * 
	 * }
	 * 
	 * public void bloodConfirmed(Long id ) { donorPatientRepo.bloodConfirmed(id); }
	 * 
	 * public void bloodRefused(Long id ) { donorPatientRepo.bloodRefused(id);
	 * DonorPatient donorPatient=donorPatientRepo.findById(id).orElseThrow();
	 * 
	 * donorMedicalHistoryService.updateNote(donorPatient.getDonor().getEmail(),
	 * "message"); }
	 */

}
