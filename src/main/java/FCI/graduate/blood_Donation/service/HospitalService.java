package FCI.graduate.blood_Donation.service;

import java.util.ArrayList;
import java.util.List;

import FCI.graduate.blood_Donation.entity.HospitalPatient;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.dto.HospitalInfoDto;
import FCI.graduate.blood_Donation.entity.Hospital;
import FCI.graduate.blood_Donation.entity.HospitalMedicalInfo;
import FCI.graduate.blood_Donation.entity.Login;
import FCI.graduate.blood_Donation.mapper.HospitalInfoMapper;
import FCI.graduate.blood_Donation.repository.HospitalRepo;
import FCI.graduate.blood_Donation.repository.LoginRepo;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class HospitalService {
	
	Logger logger = LoggerFactory.getLogger(HospitalService.class);

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

	public List<Hospital> findAll(){
		return hospitalRepo.findAll();
	}

	public Hospital addHospital(Hospital hospital) {

		Login login = new Login(hospital.getEmail(), hospital.getPassword(),hospital.getType());
		hospital.setUserLogin(login);

		HospitalMedicalInfo hospitalMedicalInfo = new HospitalMedicalInfo(hospital.getEmail(), 0, 0, 0, 0, 0, 0, 0, 0);
		hospital.setHospitalMedicalInfo(hospitalMedicalInfo);

		return hospitalRepo.save(hospital);
	}

	public Hospital updateHospital(Hospital newHospital){
		Hospital oldHospital = getHospitalByEmail(newHospital.getEmail());

		if(newHospital.getType() == null)
			newHospital.setType(oldHospital.getType());

		if(newHospital.getPassword() == null)
			newHospital.setPassword(oldHospital.getPassword());

		if(newHospital.getName()==null)
			newHospital.setName(oldHospital.getName());

		if(newHospital.getCity() == null)
			newHospital.setCity(oldHospital.getCity());

		if(newHospital.getLocation() == null)
			newHospital.setLocation(oldHospital.getLocation());

		if(newHospital.getPhone() == null)
			newHospital.setPhone(oldHospital.getPhone());

		if(newHospital.getZipCode() == null)
			newHospital.setZipCode(oldHospital.getZipCode());

		if(newHospital.getLongitude()== null)
			newHospital.setZipCode(oldHospital.getZipCode());

		if(newHospital.getLatitude() == null)
			newHospital.setZipCode(oldHospital.getZipCode());

		Login login = new Login(newHospital.getEmail() , newHospital.getPassword() , newHospital.getType());
		newHospital.setUserLogin(login);
		newHospital.setHospitalMedicalInfo(oldHospital.getHospitalMedicalInfo());

		logger.info(newHospital.getEmail()+ " "+ newHospital.getName() + newHospital.getPassword()+" "+newHospital.getType()+newHospital.getUserLogin().getType()+" "+newHospital.getUserLogin().getPassword());

		return hospitalRepo.save(newHospital);
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
