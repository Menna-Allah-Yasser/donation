package FCI.graduate.blood_Donation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import FCI.graduate.blood_Donation.entity.HospitalMedicalInfo;

@Repository
public interface HospitalMedicalInfoRepo extends JpaRepository<HospitalMedicalInfo, String> {

	@Query("SELECT h FROM HospitalMedicalInfo h WHERE (" +
			":bloodType = 'A+' AND h.countABPlus > 0) OR " +
			"(:bloodType = 'A-' AND h.countAMin > 0) OR " +
			"(:bloodType = 'O-' AND h.countOMin > 0) OR " +
			"(:bloodType = 'O+' AND h.countOPlus > 0) OR " +
			"(:bloodType = 'B-' AND h.countBMin > 0) OR " +
			"(:bloodType = 'B+' AND h.countBPlus > 0) OR " +
			"(:bloodType = 'AB-' AND h.countABMin > 0) OR " +
			"(:bloodType = 'AB+' AND h.countABPlus > 0)")
	List<HospitalMedicalInfo> findByBloodType(String bloodType);

	/*
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("UPDATE HospitalMedicalInfo h " + "SET " +
	 * "h.countAPlus = CASE WHEN :bloodType = 'A+' THEN h.countAPlus - :amount ELSE h.countAPlus END, "
	 * +
	 * "h.countAMin = CASE WHEN :bloodType = 'A-' THEN h.countAMin - :amount ELSE h.countAMin END, "
	 * +
	 * "h.countOMin = CASE WHEN :bloodType = 'O-' THEN h.countOMin - :amount ELSE h.countOMin END, "
	 * +
	 * "h.countOPlus = CASE WHEN :bloodType = 'O+' THEN h.countOPlus - :amount ELSE h.countOPlus END, "
	 * +
	 * "h.countBMin = CASE WHEN :bloodType = 'B-' THEN h.countBMin - :amount ELSE h.countBMin END, "
	 * +
	 * "h.countBPlus = CASE WHEN :bloodType = 'B+' THEN h.countBPlus - :amount ELSE h.countBPlus END, "
	 * +
	 * "h.countABMin = CASE WHEN :bloodType = 'AB-' THEN h.countABMin - :amount ELSE h.countABMin END, "
	 * +
	 * "h.countABPlus = CASE WHEN :bloodType = 'AB+' THEN h.countABPlus - :amount ELSE h.countABPlus END "
	 * + "WHERE h.email = :email") void updateHospitalStock( String email, String
	 * bloodType, int amount);
	 */

	/*@Modifying
	@Transactional
	@Query("UPDATE HospitalMedicalInfo h " + "SET "
			+ "h.countAPlus = CASE WHEN :bloodType = 'APlus' AND :amount <= h.countAPlus THEN h.countAPlus + :amount ELSE h.countAPlus END, "
			+ "h.countAMin = CASE WHEN :bloodType = 'AMinus' AND :amount <= h.countAMin THEN h.countAMin - :amount ELSE h.countAMin END, "
			+ "h.countOMin = CASE WHEN :bloodType = 'OMinus' AND :amount <= h.countOMin THEN h.countOMin - :amount ELSE h.countOMin END, "
			+ "h.countOPlus = CASE WHEN :bloodType = 'OPlus' AND :amount <= h.countOPlus THEN h.countOPlus - :amount ELSE h.countOPlus END, "
			+ "h.countBMin = CASE WHEN :bloodType = 'BMinus' AND :amount <= h.countBMin THEN h.countBMin - :amount ELSE h.countBMin END, "
			+ "h.countBPlus = CASE WHEN :bloodType = 'BPlus' AND :amount <= h.countBPlus THEN h.countBPlus - :amount ELSE h.countBPlus END, "
			+ "h.countABMin = CASE WHEN :bloodType = 'ABMinus' AND :amount <= h.countABMin THEN h.countABMin - :amount ELSE h.countABMin END, "
			+ "h.countABPlus = CASE WHEN :bloodType = 'ABPlus' AND :amount <= h.countABPlus THEN h.countABPlus - :amount ELSE h.countABPlus END "
			+ "WHERE h.email = :email")
	void updateHospitalCounters(String email, String bloodType, int amount);*/


	@Modifying
	@Transactional
	@Query("UPDATE HospitalMedicalInfo h " + "SET "
			+ "h.countAPlus  = CASE WHEN :bloodType = 'APlus'   THEN  h.countAPlus  + :amount ELSE h.countAPlus  END, "
			+ "h.countAMin   = CASE WHEN :bloodType = 'AMinus'  THEN  h.countAMin   + :amount ELSE h.countAMin   END, "
			+ "h.countOMin   = CASE WHEN :bloodType = 'OMinus'  THEN  h.countOMin   + :amount ELSE h.countOMin   END, "
			+ "h.countOPlus  = CASE WHEN :bloodType = 'OPlus'   THEN  h.countOPlus  + :amount ELSE h.countOPlus  END, "
			+ "h.countBMin   = CASE WHEN :bloodType = 'BMinus'  THEN  h.countBMin   + :amount ELSE h.countBMin   END, "
			+ "h.countBPlus  = CASE WHEN :bloodType = 'BPlus'   THEN  h.countBPlus  + :amount ELSE h.countBPlus  END, "
			+ "h.countABMin  = CASE WHEN :bloodType = 'ABMinus' THEN  h.countABMin  + :amount ELSE h.countABMin  END, "
			+ "h.countABPlus = CASE WHEN :bloodType = 'ABPlus'  THEN  h.countABPlus + :amount ELSE h.countABPlus END "
			+ "WHERE h.email = :email")
	void incHospitalCounter(String email, String bloodType, int amount);


	@Modifying
	@Transactional
	@Query("UPDATE HospitalMedicalInfo h " + "SET "
			+ "h.countAPlus  = CASE WHEN :bloodType = 'APlus'   AND :amount <= h.countAPlus  THEN  h.countAPlus  - :amount ELSE h.countAPlus  END, "
			+ "h.countAMin   = CASE WHEN :bloodType = 'AMinus'  AND :amount <= h.countAMin   THEN  h.countAMin   - :amount ELSE h.countAMin   END, "
			+ "h.countOMin   = CASE WHEN :bloodType = 'OMinus'  AND :amount <= h.countOMin   THEN  h.countOMin   - :amount ELSE h.countOMin   END, "
			+ "h.countOPlus  = CASE WHEN :bloodType = 'OPlus'   AND :amount <= h.countOPlus  THEN  h.countOPlus  - :amount ELSE h.countOPlus  END, "
			+ "h.countBMin   = CASE WHEN :bloodType = 'BMinus'  AND :amount <= h.countBMin   THEN  h.countBMin   - :amount ELSE h.countBMin   END, "
			+ "h.countBPlus  = CASE WHEN :bloodType = 'BPlus'   AND :amount <= h.countBPlus  THEN  h.countBPlus  - :amount ELSE h.countBPlus  END, "
			+ "h.countABMin  = CASE WHEN :bloodType = 'ABMinus' AND :amount <= h.countABMin  THEN  h.countABMin  - :amount ELSE h.countABMin  END, "
			+ "h.countABPlus = CASE WHEN :bloodType = 'ABPlus'  AND :amount <= h.countABPlus THEN  h.countABPlus - :amount ELSE h.countABPlus END "
			+ "WHERE h.email = :email")
	void decHospitalCounter(String email, String bloodType, int amount);
	
	
	
	

}
