package FCI.graduate.blood_Donation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Donate {
	
	@Id
	@NonNull
	private String id;
	
	private int stateCode;
	
	@ManyToOne
	private Donor donor;
	
	
	@ManyToOne
	private Hospital hospital;
	
	

}
