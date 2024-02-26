package FCI.graduate.blood_Donation.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Hospital {

	@Id
	@NonNull
	private String email;

	private String name;

	private String password;

	private String zipCode;

	private String city;

	private String phone;

	private String type;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Login userLogin;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private HospitalMedicalInfo hospitalMedicalInfo;

}
