package FCI.graduate.blood_Donation.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
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
public class DonorPatient {
	
	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@SequenceGenerator(name = "Donor_Patient_GENERATOR", sequenceName = "Donor_Patient_id", initialValue = 1000)
	private Long id;
	 
	private String stateCode; // 0 patient request Blood           pending
						      // 1 Donor Accept request            Accept
	                          // -1 Donor refused request          reject
	                         //  2 Donor donated  - checking -     Done       counter++
	                         //  3 blood is confirmed              confirmed
	                        //  -3 blood refused                   refused    send note
	
	@ManyToOne
	private Donor donor;
	
	@ManyToOne()
	@JoinColumn(name = "patient_email")
	private Patient patient;

}
