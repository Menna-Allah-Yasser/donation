package FCI.graduate.blood_Donation.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import FCI.graduate.blood_Donation.dto.DonorDto;
import FCI.graduate.blood_Donation.dto.DonorPersonalInfoDto;
import FCI.graduate.blood_Donation.mapper.DonorMapper;
import FCI.graduate.blood_Donation.mapper.DonorPersonalInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger logger = LoggerFactory.getLogger(DonorService.class);

	@Autowired
	private DonorRepo donorRepo;

	@Autowired
	private LoginRepo loginRepo;
	
	@Autowired
	private DonorInfoMapper donorInfoMapper;

	@Autowired
	private DonorPersonalInfoMapper donorPersonalInfoMapper;

	@Autowired
	private DonorMapper donorMapper;
	

	public List<DonorPersonalInfoDto> findAll(){
		List<Donor> donor = donorRepo.findAll();
		List<DonorPersonalInfoDto> donorPersonalInfoDto = new ArrayList<>();

		for(Donor i : donor){
			donorPersonalInfoDto.add(donorPersonalInfoMapper.map(i));
		}
		return donorPersonalInfoDto;
	}
	public DonorInfoDto getDonorByEmail(String email) {
		Donor donor= donorRepo.findById(email).orElseThrow();
		DonorInfoDto donorInfoDto=donorInfoMapper.map(donor);
		return donorInfoDto;
	}

	public DonorPersonalInfoDto getDonorPersonalInfoByEmail(String email){
		Donor donor= donorRepo.findById(email).orElseThrow();
		DonorPersonalInfoDto donorPersonalInfoDto=donorPersonalInfoMapper.map(donor);
		return donorPersonalInfoDto;
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

	public Donor updateDonor(Donor newDonor){
		Donor oldDonor=donorRepo.getById(newDonor.getEmail());

		if(newDonor.getAge()==null)
			newDonor.setAge(oldDonor.getAge());

		if(newDonor.getGender()==null)
			newDonor.setGender(oldDonor.getGender());

		if(newDonor.getBloodType()==null)
			newDonor.setBloodType(oldDonor.getBloodType());

		if(newDonor.getLatitude()==null)
			newDonor.setLatitude(oldDonor.getLatitude());

		if(newDonor.getLongitude()==null)
			newDonor.setLongitude(oldDonor.getLongitude());

		if(newDonor.getPhone()==null)
			newDonor.setPhone(oldDonor.getPhone());

		if(newDonor.getCountDonates()==null)
			newDonor.setCountDonates(oldDonor.getCountDonates());

		if(newDonor.getLastName()==null)
			newDonor.setLastName(oldDonor.getLastName());

		if(newDonor.getFirstName()==null)
			newDonor.setFirstName(oldDonor.getFirstName());

		if(newDonor.getNationalID()==null)
			newDonor.setNationalID(oldDonor.getNationalID());

		if(newDonor.getPassword()==null)
			newDonor.setPassword(oldDonor.getPassword());

		if(newDonor.getSerialNumber()==null)
			newDonor.setSerialNumber(oldDonor.getSerialNumber());


		Login login = new Login(newDonor.getEmail() , newDonor.getPassword() , "donor");
		newDonor.setUserLogin(login);

		Patient patient = new Patient(newDonor.getEmail() , newDonor.getBloodType());
		newDonor.setPatient(patient);

		newDonor.setDonorMedicalHistory(oldDonor.getDonorMedicalHistory());

		return donorRepo.save(newDonor);
	}

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
