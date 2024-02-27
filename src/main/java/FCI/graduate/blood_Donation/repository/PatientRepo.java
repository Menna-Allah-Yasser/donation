package FCI.graduate.blood_Donation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FCI.graduate.blood_Donation.entity.Donor;
import FCI.graduate.blood_Donation.entity.Patient;


@Repository
public interface PatientRepo extends JpaRepository<Patient, String>{

}
