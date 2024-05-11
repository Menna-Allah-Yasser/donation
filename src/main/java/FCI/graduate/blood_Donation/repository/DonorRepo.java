package FCI.graduate.blood_Donation.repository;

import java.util.List;

import FCI.graduate.blood_Donation.dto.DonorPersonalInfoDto;
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
	@Query("UPDATE Donor d SET d.age= :#{#donorPersonalInfoDto.age}," +
			" d.bloodType=:#{#donorPersonalInfoDto.bloodType}  , d.countDonates = :#{#donorPersonalInfoDto.countDonates}" +
			" , d.firstName = :#{#donorPersonalInfoDto.firstName} " +
			", d.lastName=:#{#donorPersonalInfoDto.lastName}" +
			" , d.gender = :#{#donorPersonalInfoDto.gender}" +
			" , d.latitude=:#{#donorPersonalInfoDto.latitude} " +
			", d.longitude= :#{#donorPersonalInfoDto.longitude} " +
			", d.nationalID=:#{#donorPersonalInfoDto.nationalID} " +
			", d.password=:#{#donorPersonalInfoDto.password} " +
			", d.phone=:#{#donorPersonalInfoDto.phone} " +
			", d.serialNumber=:#{#donorPersonalInfoDto.serialNumber}" +
			" WHERE d.email = :#{#donorPersonalInfoDto.email}")
	void updateDonorPersonalInfo(DonorPersonalInfoDto donorPersonalInfoDto);

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
