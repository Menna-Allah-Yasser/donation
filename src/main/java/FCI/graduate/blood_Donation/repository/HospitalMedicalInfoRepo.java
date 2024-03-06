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
	
	
	 @Query("SELECT h FROM HospitalMedicalInfo h WHERE " +
	            "CASE WHEN :bloodType = 'A+' THEN h.countAPlus > 0 " +
	            "     WHEN :bloodType = 'A-' THEN h.countAMin  > 0 " +
	            
	            "     WHEN :bloodType = 'O-' THEN h.countOMin  > 0 " +
	            "     WHEN :bloodType = 'O+' THEN h.countOPlus  > 0 " +
	            
	            "     WHEN :bloodType = 'B-' THEN h.countBMin  > 0 " +
	            "     WHEN :bloodType = 'B+' THEN h.countBPlus  > 0 " +
	            
	            "     WHEN :bloodType = 'AB-' THEN h.countABMin  > 0 " +
	            "     WHEN :bloodType = 'AB+' THEN h.countABPlus  > 0 " +
	            
	          
	            
	            "     ELSE false END")
	List<HospitalMedicalInfo> findByBloodType(String bloodType);
	 

	
		
	    @Modifying
		@Transactional
		@Query("UPDATE HospitalMedicalInfo h " +
		       "SET " +
		       "h.countAPlus = CASE WHEN :bloodType = 'A+' THEN h.countAPlus - :amount ELSE h.countAPlus END, " +
		       "h.countAMin = CASE WHEN :bloodType = 'A-' THEN h.countAMin - :amount ELSE h.countAMin END, " +
		       "h.countOMin = CASE WHEN :bloodType = 'O-' THEN h.countOMin - :amount ELSE h.countOMin END, " +
		       "h.countOPlus = CASE WHEN :bloodType = 'O+' THEN h.countOPlus - :amount ELSE h.countOPlus END, " +
		       "h.countBMin = CASE WHEN :bloodType = 'B-' THEN h.countBMin - :amount ELSE h.countBMin END, " +
		       "h.countBPlus = CASE WHEN :bloodType = 'B+' THEN h.countBPlus - :amount ELSE h.countBPlus END, " +
		       "h.countABMin = CASE WHEN :bloodType = 'AB-' THEN h.countABMin - :amount ELSE h.countABMin END, " +
		       "h.countABPlus = CASE WHEN :bloodType = 'AB+' THEN h.countABPlus - :amount ELSE h.countABPlus END " +
		       "WHERE h.email = :email")
		void updateHospitalStock( String email,  String bloodType,  int amount);

}
