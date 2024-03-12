package FCI.graduate.blood_Donation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.dto.HospitalInfoDto;
import FCI.graduate.blood_Donation.entity.Hospital;
import FCI.graduate.blood_Donation.entity.HospitalMedicalInfo;
import FCI.graduate.blood_Donation.entity.Login;
import FCI.graduate.blood_Donation.mapper.HospitalInfoMapper;
import FCI.graduate.blood_Donation.repository.HospitalRepo;
import FCI.graduate.blood_Donation.repository.LoginRepo;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepo hospitalRepo;

	@Autowired
	private LoginRepo loginRepo;
	
	@Autowired
	private HospitalInfoMapper hospitalInfoMapper;

	public Hospital getHospitalByEmail(String email) {
		return hospitalRepo.findById(email).orElseThrow();
	}

	public List<HospitalInfoDto> getAllHospitals() {
		List<Hospital> hospitals= hospitalRepo.findAll();
		
		List <HospitalInfoDto> hospitalInfoDtos=new ArrayList<>();
		
		for(Hospital h : hospitals) {
			hospitalInfoDtos.add(hospitalInfoMapper.map(h));
		}
		
		return hospitalInfoDtos;
	}

	public Hospital addHospital(Hospital hospital) {

		Login login = new Login(hospital.getEmail(), hospital.getPassword(),hospital.getType());
		hospital.setUserLogin(login);

		HospitalMedicalInfo hospitalMedicalInfo = new HospitalMedicalInfo(hospital.getEmail(), 0, 0, 0, 0, 0, 0, 0, 0);
		hospital.setHospitalMedicalInfo(hospitalMedicalInfo);

		return hospitalRepo.save(hospital);
	}

	public void updatePassword(String email, String newPass) {
		loginRepo.updatePassword(email, newPass);
		hospitalRepo.updatePassword(email, newPass);
	}

	public void updatePhone(String email, String newPhone) {
		hospitalRepo.updatePhone(email, newPhone);
	}

	public void deleteHospital(String email) {
		hospitalRepo.deleteById(email);
	}

}
