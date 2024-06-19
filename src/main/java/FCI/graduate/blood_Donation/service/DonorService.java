package FCI.graduate.blood_Donation.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import FCI.graduate.blood_Donation.dto.DonorDto;
import FCI.graduate.blood_Donation.dto.DonorPersonalInfoDto;
import FCI.graduate.blood_Donation.entity.*;
import FCI.graduate.blood_Donation.mapper.DonorMapper;
import FCI.graduate.blood_Donation.mapper.DonorPersonalInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.mapper.DonorInfoMapper;
import FCI.graduate.blood_Donation.dto.DonorInfoDto;
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

	public Donor getDonor(String email) {
		return donorRepo.findById(email).orElseThrow();
	}

	public DonorPersonalInfoDto getDonorPersonalInfoByEmail(String email){
		Donor donor= donorRepo.findById(email).orElseThrow();
		DonorPersonalInfoDto donorPersonalInfoDto=donorPersonalInfoMapper.map(donor);
		return donorPersonalInfoDto;
	}

	public Donor addDonor(Donor donor) {

		if(donor.getCountDonates()==null)
			donor.setCountDonates(0);
		if(donor.getLongitude()==null)
			donor.setLongitude(0.0);
		if(donor.getLatitude()==null)
			donor.setLatitude(0.0);
		if(donor.getAge()==null)
			donor.setAge(18);


		Login login = new Login(donor.getEmail(), donor.getPassword() , "donor");
		donor.setUserLogin(login);

		DonorMedicalHistory donorMedicalHistory = new DonorMedicalHistory(donor.getEmail());
		donor.setDonorMedicalHistory(donorMedicalHistory);

		Patient patient = new Patient(donor.getEmail());
		patient.setType("user");
		patient.setBloodType(donor.getBloodType());
		donor.setPatient(patient);

		Points point = new Points(donor.getEmail() , 100);
		donor.setPoints(point);

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


//		Login login = new Login(newDonor.getEmail() , newDonor.getPassword() , "donor");
//		newDonor.setUserLogin(login);
//
//		Patient patient = new Patient(newDonor.getEmail() , newDonor.getBloodType());
//		newDonor.setPatient(patient);
//
//		newDonor.setDonorMedicalHistory(oldDonor.getDonorMedicalHistory());

		return donorRepo.save(newDonor);
	}

	public void updateDonorPersonalInfo(DonorPersonalInfoDto donorPersonalInfoDto){
		Donor oldDonor=donorRepo.getById(donorPersonalInfoDto.getEmail());
		if(donorPersonalInfoDto.getAge()==null)
			donorPersonalInfoDto.setAge(oldDonor.getAge());

		if(donorPersonalInfoDto.getGender()==null)
			donorPersonalInfoDto.setGender(oldDonor.getGender());

		if(donorPersonalInfoDto.getBloodType()==null)
			donorPersonalInfoDto.setBloodType(oldDonor.getBloodType());

		if(donorPersonalInfoDto.getLatitude()==null)
			donorPersonalInfoDto.setLatitude(oldDonor.getLatitude());

		if(donorPersonalInfoDto.getLongitude()==null)
			donorPersonalInfoDto.setLongitude(oldDonor.getLongitude());

		if(donorPersonalInfoDto.getPhone()==null)
			donorPersonalInfoDto.setPhone(oldDonor.getPhone());

		if(donorPersonalInfoDto.getCountDonates()==null)
			donorPersonalInfoDto.setCountDonates(oldDonor.getCountDonates());

		if(donorPersonalInfoDto.getLastName()==null)
			donorPersonalInfoDto.setLastName(oldDonor.getLastName());

		if(donorPersonalInfoDto.getFirstName()==null)
			donorPersonalInfoDto.setFirstName(oldDonor.getFirstName());

		if(donorPersonalInfoDto.getNationalID()==null)
			donorPersonalInfoDto.setNationalID(oldDonor.getNationalID());

		if(donorPersonalInfoDto.getPassword()==null)
			donorPersonalInfoDto.setPassword(oldDonor.getPassword());

		if(donorPersonalInfoDto.getSerialNumber()==null)
			donorPersonalInfoDto.setSerialNumber(oldDonor.getSerialNumber());

		donorRepo.updateDonorPersonalInfo(donorPersonalInfoDto);
		loginRepo.updatePassword(donorPersonalInfoDto.getEmail() , donorPersonalInfoDto.getPassword());
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

	public List<DonorInfoDto> getMatchBloodType (String bloodType){
		List<Donor> donors= donorRepo.getMatchBloodType(bloodType);
		List <DonorInfoDto> donorInfoDtos = new ArrayList<>();

		for(Donor i : donors){
			donorInfoDtos.add(donorInfoMapper.map(i));
		}
		return donorInfoDtos;
	}
}
