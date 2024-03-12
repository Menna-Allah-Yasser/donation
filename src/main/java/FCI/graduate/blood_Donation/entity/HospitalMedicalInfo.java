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
	
	@Column(name = "OMinus")
	private int countOMin;
	
	@Column(name = "OPlus")
	private int countOPlus;
	
	@Column(name = "APlus")
	private int countAPlus;
	
	@Column(name = "AMinus")
	private int countAMin;
	
	@Column(name = "BMinus")
	private int countBMin;
	
	@Column(name = "BPlus")
	private int countBPlus;
	
	@Column(name = "ABMinus")
	private int countABMin;
	
	@Column(name = "ABPlus")
	private int countABPlus;
		
	

}
