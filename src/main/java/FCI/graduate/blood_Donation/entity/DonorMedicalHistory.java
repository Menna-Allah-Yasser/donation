package FCI.graduate.blood_Donation.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@EntityListeners({ AuditingEntityListener.class })
public class DonorMedicalHistory {

	@Id
	@NonNull
	private String email;

	@Column(name = "surgery_last_3_months")
	private String surgery /* = "false" */;

	@Column(name = "dentist_last_3_months")
	private String dentist /* = "false" */;

	@Column(name = "chronic_disease")
	private String chronicDisease /* = "false" */;

	private LocalDate lastDonateTime = LocalDate.now();

	@LastModifiedDate
	private LocalDate lastModifiedDate;

	private String note;

	private String legalToDonate ;

}
