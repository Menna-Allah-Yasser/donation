package FCI.graduate.blood_Donation.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
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

	private String location;

	private String type;
	
	private Double longitude;

	private Double latitude;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@MapsId
	@JoinColumn(name = "email")
	private Login userLogin;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@MapsId
	@JoinColumn(name = "email")
	private HospitalMedicalInfo hospitalMedicalInfo;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@MapsId
	@JoinColumn(name = "email")
	private Patient patient;

}
