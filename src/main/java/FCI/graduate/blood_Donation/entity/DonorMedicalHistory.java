package FCI.graduate.blood_Donation.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
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
public class DonorMedicalHistory {
	
	@Id
	@NonNull
	private String email;
	
	@Column(name = "surgery_last_3_months")
	private String surgery;
	
	@Column(name = "dentist_last_3_months")
	private String dentist;
	
	private String chronicDisease;
	
	private LocalDate lastDonateTime;
	
	private String note;



}
