package FCI.graduate.blood_Donation.mapper;

import org.mapstruct.Mapper;

import FCI.graduate.blood_Donation.dto.HospitalInfoDto;
import FCI.graduate.blood_Donation.entity.Hospital;

@Mapper
public interface HospitalInfoMapper {
	
	HospitalInfoDto map (Hospital hospital);
	
	Hospital unMap (HospitalInfoDto dto);

}
