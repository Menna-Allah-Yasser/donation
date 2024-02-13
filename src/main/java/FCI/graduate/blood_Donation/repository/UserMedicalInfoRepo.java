package FCI.graduate.blood_Donation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FCI.graduate.blood_Donation.entity.UserMedicalInfo;

@Repository
public interface UserMedicalInfoRepo extends JpaRepository<UserMedicalInfo, String>{

}
