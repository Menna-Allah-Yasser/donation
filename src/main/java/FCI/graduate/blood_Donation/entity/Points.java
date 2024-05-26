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
public class Points {
//
//	@Id
//	@NonNull
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//
//
//	@ManyToOne
//	private Donor donor;
//
//
//	@ManyToOne
//	private Hospital hospital;
//

	@Id
	@NonNull
	private String email;

	private int points;
}
