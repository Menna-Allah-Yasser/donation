package FCI.graduate.blood_Donation.mapper;

import org.mapstruct.Mapper;

import FCI.graduate.blood_Donation.dto.DonorInfoDto;
import FCI.graduate.blood_Donation.entity.Donor;

@Mapper
public interface DonorInfoMapper {
	
	DonorInfoDto map (Donor donor);
	
	Donor unMap (DonorInfoDto donorInfoDto);

}
