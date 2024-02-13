package FCI.graduate.blood_Donation.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class UserSignUp {
	
	@Id
	private String email;
	
	@Column(name = "pass")
	private String password;
	
	@Column(name = "FName")
	private String firstName;
	
	@Column(name = "LName")
	private String lastName;
	
	@Column(name = "SSN")
	private String nationalID;
	
	private String gender;
	
	private int age;
	
	private String phone;
	
	@OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
	@JoinColumn(name="medical_email")
	private UserMedicalInfo userMedicalInfo;
	
	public UserSignUp() {
		
	}

	public UserSignUp(String email, String password, String firstName, String lastName, String nationalID,
			String gender, int age, String phone) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalID = nationalID;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationalID() {
		return nationalID;
	}

	public void setNationalID(String nationalID) {
		this.nationalID = nationalID;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public UserMedicalInfo getUserMedicalInfo() {
		return userMedicalInfo;
	}

	public void setUserMedicalInfo(UserMedicalInfo userMedicalInfo) {
		this.userMedicalInfo = userMedicalInfo;
	}
	
	
	

}
