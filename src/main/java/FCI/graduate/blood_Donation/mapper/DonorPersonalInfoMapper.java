package FCI.graduate.blood_Donation.mapper;

import FCI.graduate.blood_Donation.dto.DonorDto;
import FCI.graduate.blood_Donation.dto.DonorPersonalInfoDto;
import FCI.graduate.blood_Donation.entity.Donor;
import org.mapstruct.Mapper;

@Mapper
public interface DonorPersonalInfoMapper {
    DonorPersonalInfoDto map (Donor donor);

    Donor unMap (DonorPersonalInfoDto donorPersonalInfoDto);

}
