package FCI.graduate.blood_Donation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FCI.graduate.blood_Donation.entity.Hospital;

@Repository
public interface HospitalRepo extends JpaRepository<Hospital, String>{

}
