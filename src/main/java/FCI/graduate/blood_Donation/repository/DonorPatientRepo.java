package FCI.graduate.blood_Donation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import FCI.graduate.blood_Donation.entity.DonorPatient;

import java.util.List;

@Repository
public interface DonorPatientRepo extends JpaRepository<DonorPatient, Long> {
	
	
	@Modifying
	@Transactional
	@Query("UPDATE DonorPatient d SET d.stateCode = :newState WHERE d.id = :id")
	void updateStateCode (Long id , String newState);

	@Query("SELECT d FROM DonorPatient d WHERE d.patient.email = :email")
	List<DonorPatient> getPatientReqs (String email);

	@Query("SELECT d FROM DonorPatient d WHERE d.donor.email = :email AND d.stateCode = :stateCode")
	List<DonorPatient> getDonorReqs (String email , String stateCode);



	/*
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("UPDATE DonorPatient d SET d.stateCode = 1 WHERE d.id = :id") void
	 * donorAcceptRequest (Long id );
	 * 
	 * 
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("UPDATE DonorPatient d SET d.stateCode = -1 WHERE d.id = :id") void
	 * donorRefusedRequest (Long id );
	 * 
	 * 
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("UPDATE DonorPatient d SET d.stateCode = 2 WHERE d.id = :id") void
	 * confirmDonation (Long id );
	 * 
	 * 
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("UPDATE DonorPatient d SET d.stateCode = 3 WHERE d.id = :id") void
	 * bloodConfirmed(Long id );
	 * 
	 * 
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("UPDATE DonorPatient d SET d.stateCode = -3 WHERE d.id = :id") void
	 * bloodRefused(Long id );
	 */

}
