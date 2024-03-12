package FCI.graduate.blood_Donation.dto;

import FCI.graduate.blood_Donation.entity.HospitalMedicalInfo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HospitalInfoDto {
	
	private String email;

	private String name;

	private String password;

	private String zipCode;

	private String city;

	private String phone;

	private String location;

	private String type;
	
	private int longitude;

	private int latitude;
	
	private HospitalMedicalInfo hospitalMedicalInfo;

}
