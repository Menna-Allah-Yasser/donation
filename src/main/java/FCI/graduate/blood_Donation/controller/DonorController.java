package FCI.graduate.blood_Donation.controller;

import java.util.List;

import FCI.graduate.blood_Donation.dto.DonorDto;
import FCI.graduate.blood_Donation.dto.DonorPersonalInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import FCI.graduate.blood_Donation.dto.DonorInfoDto;
import FCI.graduate.blood_Donation.entity.Donor;
import FCI.graduate.blood_Donation.service.DonorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/donors")
@Tag(name = "Donor")
public class DonorController {

	@Autowired
	private DonorService donorService;

	@GetMapping()
	@Operation(summary = "get all Donors")
	public List<DonorPersonalInfoDto> findAll(){
		return donorService.findAll();
	}

	@PostMapping("")
	@Operation(summary = "Add Donor Personal Information ")
	public Donor addDonor(@RequestBody Donor user) {
		return donorService.addDonor(user);
	}

	
	@GetMapping("/{email}")
	@Operation(summary = "get donor info (personal & medical ) by e-mail")
	public DonorInfoDto getDonorByEmail (@PathVariable String email) {

		return donorService.getDonorByEmail(email);
	}

	@GetMapping("/pi/{email}")
	@Operation(summary = "get donor personal info by e-mail")
	public DonorPersonalInfoDto getDonorPersonalInfoByEmail(@PathVariable String email){
		return donorService.getDonorPersonalInfoByEmail(email);
	}

	@GetMapping("/count-donations/{email}")
	@Operation(summary = "get donor's count_donates")
	public int getCountDonates(@PathVariable String email) {
		return donorService.getCountDonates(email);
	}

	@GetMapping("/bloodtype/{bloodType}")
	@Operation(summary = "find donors by blood_type")
	public List<DonorInfoDto> findByBloodType( @PathVariable  String bloodType) {
		return donorService.findByBloodType(bloodType);
	}

	/*
	 * @PutMapping("/update") public Donor updateDonor(Donor donor) { return
	 * donorService.updateDonor(donor); }
	 */

	@PutMapping()
	@Operation(summary = "Update Donor Presonal Info")
	public void updateDonorPersonalInfo(@RequestBody DonorPersonalInfoDto donorPersonalInfoDto){
		donorService.updateDonorPersonalInfo(donorPersonalInfoDto);
	}

//	//@PutMapping()
//	@Operation(summary = "Update Donor")
//	public Donor updateDonor(@RequestBody Donor newDonor){
//		return donorService.updateDonor(newDonor);
//	}

	@PutMapping("/password")
	@Operation(summary = "Update Donor's Password By E-mail")
	public void updatePassword(@RequestParam String email, @RequestParam String newPass) {
		donorService.updatePassword(email, newPass);
	}

	@PutMapping("/phone")
	@Operation(summary = "Update Donor's Phone By E-mail")
	public void updatePhone(@RequestParam String email, @RequestParam String newPhone) {
		donorService.updatePhone(email, newPhone);
	}

	@PutMapping("/bloodtype")
	@Operation(summary = "Update Donor's Blood_Type By E-mail")
	public void updateBloodType(@RequestParam String email, @RequestParam String newBloodType) {
		donorService.updateBloodType(email, newBloodType);
	}

	@PutMapping("/name")
	@Operation(summary = "Update Donor's Name By E-mail")
	public void updateName(@RequestParam String email, @RequestParam String newFName, @RequestParam String newLName) {
		donorService.updateName(email, newFName, newLName);
	}

	@PutMapping("count-donates")
	@Operation(summary = "donor's count_donates ++ by e-mail")
	public void incCountDonatesByOne(@RequestParam String email) {
		donorService.incCountDonatesByOne(email);
	}
	

	@DeleteMapping("/{email}")
	@Operation(summary = "Delete Donor Personal Information By e-mail")
	public void deleteDonor(@PathVariable String email) {
		donorService.deleteUser(email);
	}


	@GetMapping("/match-blood/{bloodType}")
	@Operation(summary = "get all donors who match input blood-type")
	List<DonorInfoDto> getMatchBloodType (@PathVariable String bloodType){
		return donorService.getMatchBloodType(bloodType);
	}
}
