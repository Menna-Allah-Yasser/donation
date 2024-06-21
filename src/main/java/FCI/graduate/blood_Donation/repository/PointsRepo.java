package FCI.graduate.blood_Donation.repository;

import FCI.graduate.blood_Donation.entity.Donate;
import FCI.graduate.blood_Donation.entity.Points;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PointsRepo extends JpaRepository<Points, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Points p SET p.points =p.points + :point WHERE p.email = :donorEmail ")
    void updatePoints (String donorEmail , int point);

    @Query("SELECT p FROM Points p WHERE p.email =:email")
    Points getPointsByEmail(String email);

}
