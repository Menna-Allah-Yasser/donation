package FCI.graduate.blood_Donation.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Donor {
	
	@Id
	@NonNull
	private String email;
	
	@Column(name = "pass")
	private String password;
	
	private String serialNumber;
	
	@Column(name = "FName")
	private String firstName;
	
	@Column(name = "LName")
	private String lastName;
	
	@Column(name = "SSN")
	private String nationalID;
	
	private String gender;
	
	private int age;
	
	private String phone;
	
	private String address;
	
	private int countDonates;
	
	private String bloodType;
	
	
	
	
	@OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
	@JoinColumn(name="medical_email")
	private DonorMedicalHistory donorMedicalHistory;
	

	@OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
	private Login userLogin;
	

}
