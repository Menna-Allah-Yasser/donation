package FCI.graduate.blood_Donation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import FCI.graduate.blood_Donation.entity.Hospital;

@Repository
public interface HospitalRepo extends JpaRepository<Hospital, String> {

	@Modifying
	@Transactional
	@Query("UPDATE Hospital h SET h.password = :newPass WHERE h.email = :email")
	void updatePassword(String email, String newPass);

	@Modifying
	@Transactional
	@Query("UPDATE Hospital h SET h.phone = :newPhone WHERE h.email = :email")
	void updatePhone(String email, String newPhone);
	
	

}
