package FCI.graduate.blood_Donation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FCI.graduate.blood_Donation.entity.Donor;

@Repository
public interface DonorRepo extends JpaRepository<Donor, String>{

}
