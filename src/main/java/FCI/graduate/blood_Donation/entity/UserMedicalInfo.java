package FCI.graduate.blood_Donation.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserMedicalInfo {
	
	@Id
	private String email;
	
	@Column(name = "surgery_last_3_months")
	private String surgery;
	
	@Column(name = "dentist_last_3_months")
	private String dentist;
	
	private String chronicDisease;
	
	private String bloodType;
	
	private LocalDate lastDonateTime;
	
	private String note;



}
