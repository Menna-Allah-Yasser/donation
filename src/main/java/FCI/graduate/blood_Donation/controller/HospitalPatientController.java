package FCI.graduate.blood_Donation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FCI.graduate.blood_Donation.dto.HospitalDto;
import FCI.graduate.blood_Donation.service.HospitalPatientService;

@RestController
@RequestMapping("/Hospital/patient")
public class HospitalPatientController {
	
	@Autowired
	private HospitalPatientService hospitalPatientService;
	
	
	@PutMapping("/{id}")
	public HospitalDto hospitalAcceptRequest(@PathVariable Long id) {
		return hospitalPatientService.hospitalAcceptRequest(id);
	}

	@PutMapping("/refuse/{id}")
	public void hospitalRefusedRequest (@PathVariable Long id) {
		hospitalPatientService.hospitalRefusedRequest(id);
	}
}
