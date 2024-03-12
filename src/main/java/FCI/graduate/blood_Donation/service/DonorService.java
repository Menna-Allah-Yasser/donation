package FCI.graduate.blood_Donation.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.entity.Login;
import FCI.graduate.blood_Donation.entity.Patient;
import FCI.graduate.blood_Donation.mapper.DonorInfoMapper;
import FCI.graduate.blood_Donation.dto.DonorInfoDto;
import FCI.graduate.blood_Donation.entity.Donor;
import FCI.graduate.blood_Donation.entity.DonorMedicalHistory;
import FCI.graduate.blood_Donation.repository.LoginRepo;
import FCI.graduate.blood_Donation.repository.DonorRepo;

@Service
public class DonorService {

	@Autowired
	private DonorRepo donorRepo;

	@Autowired
	private LoginRepo loginRepo;
	
	@Autowired
	private DonorInfoMapper donorInfoMapper;

	public DonorInfoDto getDonorByEmail(String email) {
		Donor donor= donorRepo.findById(email).orElseThrow();
		DonorInfoDto donorInfoDto=donorInfoMapper.map(donor);
		return donorInfoDto;
	}

	public Donor addDonor(Donor donor) {

		Login login = new Login(donor.getEmail(), donor.getPassword() , "donor");
		donor.setUserLogin(login);

		DonorMedicalHistory donorMedicalHistory = new DonorMedicalHistory(donor.getEmail());
		donor.setDonorMedicalHistory(donorMedicalHistory);

		Patient patient = new Patient(donor.getEmail());
		donor.setPatient(patient);

		return donorRepo.save(donor);

	}
	
	/*
	 * public Donor updateDonor(Donor donor) {
	 * loginRepo.updatePassword(donor.getEmail(), donor.getPassword()); return
	 * donorRepo.save(donor); }
	 */

	public void updatePassword(String email, String newPass) {
		loginRepo.updatePassword(email, newPass);
		donorRepo.updatePassword(email, newPass);
	}

	public void updatePhone(String email, String newPhone) {
		donorRepo.updatePhone(email, newPhone);
	}

	public void updateBloodType(String email, String newBloodType) {
		donorRepo.updateBloodType(email, newBloodType);
	}

	public void updateName(String email, String newFName, String newLName) {
		donorRepo.updateName(email, newFName, newLName);
	}

	public void deleteUser(String email) {
		donorRepo.deleteById(email);
	}

	public List<DonorInfoDto> findByBloodType(String bloodType) {
		List<Donor> donors= donorRepo.findByBloodType(bloodType);
		 List<DonorInfoDto> donorInfoDtos = new ArrayList<>();
		for(Donor donor : donors) {
			
		 donorInfoDtos.add(donorInfoMapper.map(donor));
		}
		return donorInfoDtos;
	}

	public int getCountDonates(String email) {
		DonorInfoDto donorInfoDto = getDonorByEmail(email);
		return donorInfoDto.getCountDonates();
	}
	
	public void incCountDonatesByOne(String email) {
		donorRepo.updateCountDonates(email, getCountDonates(email)+1);
	}

}
