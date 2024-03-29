package FCI.graduate.blood_Donation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

	private String stateCode;// 0 patient request Blood     pending
						   //   1 Hospital Accept request   accept
    					   //  -1 Hospital refused request  refused
						   //   2 Patient takes blood   	done     counter--					

	@ManyToOne
	private Hospital hospital;

	@ManyToOne
	@JoinColumn(name = "patient_email")
	private Patient patient;

}
