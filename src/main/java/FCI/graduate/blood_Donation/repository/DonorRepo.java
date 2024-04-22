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
	
	@Modifying
	@Transactional
	@Query("UPDATE Donor d SET d.countDonates = :count  WHERE d.email = :email")
	void updateCountDonates(String email, int count);

	/*UPDATE HospitalMedicalInfo h " + "SET "
			+ "h.countAPlus  = CASE WHEN :bloodType = 'APlus'   AND :amount <= h.countAPlus  THEN  h.countAPlus  - :amount ELSE h.countAPlus  END, "
			+ "h.countAMin   = CASE WHEN :bloodType = 'AMinus'  AND :amount <= h.countAMin   THEN  h.countAMin   - :amount ELSE h.countAMin   END, "
			+ "h.countOMin   = CASE WHEN :bloodType = 'OMinus'  AND :amount <= h.countOMin   THEN  h.countOMin   - :amount ELSE h.countOMin   END, "
			+ "h.countOPlus  = CASE WHEN :bloodType = 'OPlus'   AND :amount <= h.countOPlus  THEN  h.countOPlus  - :amount ELSE h.countOPlus  END, "
			+ "h.countBMin   = CASE WHEN :bloodType = 'BMinus'  AND :amount <= h.countBMin   THEN  h.countBMin   - :amount ELSE h.countBMin   END, "
			+ "h.countBPlus  = CASE WHEN :bloodType = 'BPlus'   AND :amount <= h.countBPlus  THEN  h.countBPlus  - :amount ELSE h.countBPlus  END, "
			+ "h.countABMin  = CASE WHEN :bloodType = 'ABMinus' AND :amount <= h.countABMin  THEN  h.countABMin  - :amount ELSE h.countABMin  END, "
			+ "h.countABPlus = CASE WHEN :bloodType = 'ABPlus'  AND :amount <= h.countABPlus THEN  h.countABPlus - :amount ELSE h.countABPlus END "
			+ "WHERE h.email = :email"*/

	@Query("SELECT d FROM Donor d WHERE " +
			   "(:bloodType = 'APlus'   AND (d.bloodType = 'APlus'   OR d.bloodType = 'AMinus'   OR d.bloodType = 'OMinus' OR d.bloodType = 'OPlus')) " +
			"OR (:bloodType = 'AMinus'  AND (d.bloodType = 'AMinus'  OR d.bloodType = 'OMinus')) " +
			"OR (:bloodType = 'OMinus'  AND (d.bloodType = 'OMinus')) " +
			"OR (:bloodType = 'OPlus'   AND (d.bloodType = 'OPlus'   OR d.bloodType = 'OMinus')) " +
			"OR (:bloodType = 'BMinus'  AND (d.bloodType = 'BMinus'  OR d.bloodType = 'OMinus')) " +
			"OR (:bloodType = 'BPlus'   AND (d.bloodType = 'BPlus'   OR d.bloodType = 'OMinus'   OR d.bloodType = 'BMinus' OR d.bloodType = 'OPlus')) " +
			"OR (:bloodType = 'ABMinus' AND (d.bloodType = 'ABMinus' OR d.bloodType = 'OMinus'   OR d.bloodType = 'AMinus' OR d.bloodType = 'BMinus' )) " +
			"OR (:bloodType = 'ABPlus'  AND (d.bloodType = 'ABPlus'  OR d.bloodType = 'OMinus'   OR d.bloodType = 'ABMinus'OR d.bloodType = 'OPlus' " +
			                                                       " OR d.bloodType = 'BMinus'   OR d.bloodType = 'BPlus'  OR d.bloodType = 'APlus'   OR d.bloodType = 'AMinus' ))")
	List<Donor> getMatchBloodType (String bloodType);

}
