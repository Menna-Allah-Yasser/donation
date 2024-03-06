package FCI.graduate.blood_Donation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import FCI.graduate.blood_Donation.entity.DonorPatient;

@Repository
public interface DonorPatientRepo extends JpaRepository<DonorPatient, Long> {
	
	@Modifying
	@Transactional
	@Query("UPDATE DonorPatient d SET d.stateCode = 1 WHERE d.id = :id")
	void donorAcceptRequest (Long id );
	
	
	@Modifying
	@Transactional
	@Query("UPDATE DonorPatient d SET d.stateCode = -1 WHERE d.id = :id")
	void donorRefusedRequest (Long id );
	
	
	@Modifying
	@Transactional
	@Query("UPDATE DonorPatient d SET d.stateCode = 2 WHERE d.id = :id")
	void confirmDonation (Long id );
	
	
	@Modifying
	@Transactional
	@Query("UPDATE DonorPatient d SET d.stateCode = 3 WHERE d.id = :id")
	void  bloodConfirmed(Long id );
	

	@Modifying
	@Transactional
	@Query("UPDATE DonorPatient d SET d.stateCode = -3 WHERE d.id = :id")
	void  bloodRefused(Long id );
	

}
