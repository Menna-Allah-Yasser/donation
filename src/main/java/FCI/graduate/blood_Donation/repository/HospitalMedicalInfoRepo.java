package FCI.graduate.blood_Donation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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

}
