package FCI.graduate.blood_Donation.repository;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import FCI.graduate.blood_Donation.entity.DonorMedicalHistory;

@Repository
public interface DonorMedicalHistoryRepo extends JpaRepository<DonorMedicalHistory, String>{


	@Modifying
	@Transactional
	@Query("UPDATE DonorMedicalHistory d SET d.lastDonateTime = :date WHERE d.email = :email")
	void updateLastDonateTime (String email , LocalDate date );
	
	

	@Modifying
	@Transactional
	@Query("UPDATE DonorMedicalHistory d SET d.note = :note WHERE d.email = :email")
	void updateNote (String email , String note );
}
