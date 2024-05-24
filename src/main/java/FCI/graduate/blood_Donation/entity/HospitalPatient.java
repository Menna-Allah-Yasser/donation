package FCI.graduate.blood_Donation.entity;

import jakarta.persistence.*;
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
public class HospitalPatient {

	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String stateCode;

	@ManyToOne
	private Hospital hospital;

	@ManyToOne
	@JoinColumn(name = "patient_email")
	private Patient patient;

}
