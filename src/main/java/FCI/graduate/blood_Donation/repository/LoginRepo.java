package FCI.graduate.blood_Donation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import FCI.graduate.blood_Donation.entity.Login;

import java.util.List;

@Repository
public interface LoginRepo extends JpaRepository<Login, String>{

	@Modifying
	@Transactional
	@Query("UPDATE Login l SET l.password = :newPass WHERE l.email = :email")
	void updatePassword(String email , String newPass);
	
	
	@Query("SELECT l FROM Login l WHERE l.email = :email AND l.password=:password")
	Login authentication(String email , String password);

	@Query("SELECT l.email FROM Login l ")
	List<String> getAllEmails ();

	@Query("SELECT l.email FROM Login l WHERE l.type='donor'")
	List<String> getDonorsEmails ();

	@Query("SELECT l.email FROM Login l WHERE l.type='hospital'")
	List<String> getHospitalsEmails ();

	@Query("SELECT l.email FROM Login l WHERE l.type='bank'")
	List<String> getBanksEmails ();


}
