package FCI.graduate.blood_Donation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class HospitalSignUp {
	
	@Id
	private String email;
	
	private String name;
	
	private String password;
	
	private String zipCode;
	
	private String city;
	
	private String phone;
	
	private String type;
	
	public HospitalSignUp() {
		
	}

	public HospitalSignUp(String email, String name, String password, String zipCode, String city, String phone,
			String type) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.zipCode = zipCode;
		this.city = city;
		this.phone = phone;
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
