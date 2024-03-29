package FCI.graduate.blood_Donation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import FCI.graduate.blood_Donation.dto.HospitalDto;
import FCI.graduate.blood_Donation.service.HospitalPatientService;

@RestController
@RequestMapping("/api/hospital-patient")
public class HospitalPatientController {

	@Autowired
	private HospitalPatientService hospitalPatientService;

	@PutMapping()
	public void updateStateCode(@RequestParam Long id, @RequestParam String newState) {
		hospitalPatientService.updateStateCode(id, newState);
	}

	/*
	 * @PutMapping("/{id}") public HospitalDto hospitalAcceptRequest(@PathVariable
	 * Long id) { return hospitalPatientService.hospitalAcceptRequest(id); }
	 * 
	 * @PutMapping("/refuse/{id}") public void hospitalRefusedRequest (@PathVariable
	 * Long id) { hospitalPatientService.hospitalRefusedRequest(id); }
	 */

	/*
	 * @PutMapping("/took/Blood/{id}") public void tookBlood (@PathVariable Long id)
	 * { hospitalPatientService.tookBlood(id); }
	 */
}
