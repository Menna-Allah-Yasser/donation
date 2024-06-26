package FCI.graduate.blood_Donation.dto;

import FCI.graduate.blood_Donation.entity.DonorMedicalHistory;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DonorInfoDto {
	
	private String email;

	private String password;

	private String serialNumber;

	private String firstName;

	private String lastName;

	private String nationalID;

	private String gender;

	private Integer age;

	private String phone;

	private Double longitude;

	private Double latitude;

	private Integer countDonates;

	private String bloodType;

	private DonorMedicalHistory donorMedicalHistory;

}
