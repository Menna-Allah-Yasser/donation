package FCI.graduate.blood_Donation.repository;

import FCI.graduate.blood_Donation.entity.Donate;
import FCI.graduate.blood_Donation.entity.DonorMedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface DonateRepo extends JpaRepository<Donate, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Donate d SET d.stateCode = :newState WHERE d.id = :id")
    void updateStateCode (Long id , String newState);
}
