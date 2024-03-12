package FCI.graduate.blood_Donation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import FCI.graduate.blood_Donation.entity.HospitalPatient;

@Repository
public interface HospitalPatientRepo extends JpaRepository<HospitalPatient, Long> {

	
	@Modifying
	@Transactional
	@Query("UPDATE HospitalPatient h SET h.stateCode = :newState WHERE h.id = :id")
	void updateStateCode(Long id , String newState);

	/*
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("UPDATE HospitalPatient h SET h.stateCode = 1 WHERE h.id = :id") void
	 * hospitalAcceptRequest (Long id );
	 * 
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("UPDATE HospitalPatient h SET h.stateCode = -1 WHERE h.id = :id") void
	 * hospitalRefusedRequest (Long id );
	 * 
	 * 
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("UPDATE HospitalPatient h SET h.stateCode = 2 WHERE h.id = :id") void
	 * tookBlood (Long id);
	 */
}
