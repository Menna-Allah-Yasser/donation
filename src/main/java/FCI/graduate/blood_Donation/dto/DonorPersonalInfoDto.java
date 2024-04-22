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

    private Integer age;

    private String phone;

    private Double longitude;

    private Double latitude;

    private Integer countDonates;

    private String bloodType;
}
