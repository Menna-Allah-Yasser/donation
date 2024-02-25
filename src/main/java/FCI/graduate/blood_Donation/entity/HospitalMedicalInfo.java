package FCI.graduate.blood_Donation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class HospitalMedicalInfo {
	
	@Id
	@NonNull
	private String email;
	
	@Column(name = "O-")
	private int countOMin;
	
	@Column(name = "O+")
	private int countOPlus;
	
	@Column(name = "A+")
	private int countAPlus;
	
	@Column(name = "A-")
	private int countAMin;
	
	@Column(name = "B-")
	private int countBMin;
	
	@Column(name = "B+")
	private int countBPlus;
	
	@Column(name = "AB-")
	private int countABMin;
	
	@Column(name = "AB+")
	private int countABPlus;
		
	

}
