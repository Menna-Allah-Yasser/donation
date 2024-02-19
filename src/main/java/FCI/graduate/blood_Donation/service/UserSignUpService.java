package FCI.graduate.blood_Donation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FCI.graduate.blood_Donation.entity.Login;
import FCI.graduate.blood_Donation.entity.UserSignUp;
import FCI.graduate.blood_Donation.repository.LoginRepo;
import FCI.graduate.blood_Donation.repository.UserSignUpRepo;

@Service
public class UserSignUpService {
	
	@Autowired
	private UserSignUpRepo userSignUpRepo;
	
	@Autowired
	private  LoginRepo loginRepo;
	
	
	public UserSignUp getUserByEmail(String email) {
		return userSignUpRepo.findById(email).orElseThrow();
	}
	
	public UserSignUp addUser(UserSignUp user) {

		Login login = new Login(user.getEmail(), user.getPassword());
		user.setUserLogin(login);

		return userSignUpRepo.save(user);

	}
	
	public UserSignUp updateUser(UserSignUp user) {
		
		UserSignUp oldUser=getUserByEmail(user.getEmail());
		
		if(user.getFirstName()==null) {
			user.setFirstName(oldUser.getFirstName());
		}
		
		if(user.getLastName()==null) {
			user.setLastName(oldUser.getLastName());
		}
		
		if(user.getGender()==null) {
			user.setGender(oldUser.getGender());
		}
		
		if(user.getNationalID()==null) {
			user.setNationalID(oldUser.getNationalID());
		}
		
		if(user.getPassword()==null) {
			user.setPassword(oldUser.getPassword());
		}
		
		if(Integer.compare(user.getAge(), 0)==0) {
			user.setAge(oldUser.getAge());
		}
		
		if(user.getPhone()==null) {
			user.setPhone(oldUser.getPhone());
		}
		
		if(user.getUserLogin()==null) {
			user.setUserLogin(oldUser.getUserLogin());
		}
		return userSignUpRepo.save(user);
	}
	
	public void deleteUser(String email) {
		userSignUpRepo.deleteById(email);
	}
	
	

}
