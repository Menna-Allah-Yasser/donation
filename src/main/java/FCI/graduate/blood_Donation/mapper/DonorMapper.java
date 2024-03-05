package FCI.graduate.blood_Donation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import FCI.graduate.blood_Donation.dto.DonorDto;
import FCI.graduate.blood_Donation.entity.Donor;

@Mapper
public interface DonorMapper {
	
	//@Mapping(source = "firstName" , target = "name")
	DonorDto map (Donor donor);
	
	
	//@Mapping(target = "firstName" , source = "name")
	Donor unMap (DonorDto donorDto);

}
