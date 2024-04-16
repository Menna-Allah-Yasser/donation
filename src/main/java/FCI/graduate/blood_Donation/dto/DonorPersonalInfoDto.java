package FCI.graduate.blood_Donation.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DonorPersonalInfoDto {

    private String email;

    private String password;

    private String serialNumber;

    private String firstName;

    private String lastName;

    private String nationalID;

    private String gender;

    private int age;

    private String phone;

    private int longitude;

    private int latitude;

    private int countDonates;

    private String bloodType;
}
