package FCI.graduate.blood_Donation.repository;

import FCI.graduate.blood_Donation.entity.Donate;
import FCI.graduate.blood_Donation.entity.Points;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PointsRepo extends JpaRepository<Points, Long> {

//    @Modifying
//    @Transactional
//    @Query("UPDATE Points p SET p.points =p.points + :point WHERE p.donor.email = :donorEmail AND p.hospital.email= :hospitalEmail")
//    void updatePoints (String donorEmail , String hospitalEmail , int point);

}
