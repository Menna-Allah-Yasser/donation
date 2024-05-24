package FCI.graduate.blood_Donation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import FCI.graduate.blood_Donation.entity.Donor;
import FCI.graduate.blood_Donation.entity.Patient;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface PatientRepo extends JpaRepository<Patient, String>{

    @Modifying
    @Transactional
    @Query("UPDATE Patient p SET p.bloodType = :bloodType WHERE p.email = :email")
    void updatePatientBloodType(String email, String bloodType);

}
