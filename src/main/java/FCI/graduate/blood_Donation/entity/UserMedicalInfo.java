package FCI.graduate.blood_Donation.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
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

	public UserMedicalInfo() {
		
	}

	public UserMedicalInfo(String email, String surgery, String dentist, String chronicDisease, String bloodType,
			LocalDate lastDonateTime, String note) {
		super();
		this.email = email;
		this.surgery = surgery;
		this.dentist = dentist;
		this.chronicDisease = chronicDisease;
		this.bloodType = bloodType;
		this.lastDonateTime = lastDonateTime;
		this.note = note;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSurgery() {
		return surgery;
	}

	public void setSurgery(String surgery) {
		this.surgery = surgery;
	}

	public String getDentist() {
		return dentist;
	}

	public void setDentist(String dentist) {
		this.dentist = dentist;
	}

	public String getChronicDisease() {
		return chronicDisease;
	}

	public void setChronicDisease(String chronicDisease) {
		this.chronicDisease = chronicDisease;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public LocalDate getLastDonateTime() {
		return lastDonateTime;
	}

	public void setLastDonateTime(LocalDate lastDonateTime) {
		this.lastDonateTime = lastDonateTime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	

}
