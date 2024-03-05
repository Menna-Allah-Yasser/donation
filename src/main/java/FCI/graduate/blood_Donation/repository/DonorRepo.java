package FCI.graduate.blood_Donation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import FCI.graduate.blood_Donation.entity.Donor;

@Repository
public interface DonorRepo extends JpaRepository<Donor, String> {

	@Modifying
	@Transactional
	@Query("UPDATE Donor d SET d.password = :newPass WHERE d.email = :email")
	void updatePassword(String email, String newPass);

	@Modifying
	@Transactional
	@Query("UPDATE Donor d SET d.phone = :newPhone WHERE d.email = :email")
	void updatePhone(String email, String newPhone);

	@Modifying
	@Transactional
	@Query("UPDATE Donor d SET d.bloodType = :newBloodType WHERE d.email = :email")
	void updateBloodType(String email, String newBloodType);

	@Modifying
	@Transactional
	@Query("UPDATE Donor d SET d.firstName = :newFName , d.lastName = :newLName WHERE d.email = :email")
	void updateName(String email, String newFName, String newLName);
	
	
	List<Donor> findByBloodType(String bloodType);
	
	

}
