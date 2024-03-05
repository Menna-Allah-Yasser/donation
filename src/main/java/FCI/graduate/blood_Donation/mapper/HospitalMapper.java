package FCI.graduate.blood_Donation.mapper;

import org.mapstruct.Mapper;

import FCI.graduate.blood_Donation.dto.HospitalDto;
import FCI.graduate.blood_Donation.entity.Hospital;

@Mapper
public interface HospitalMapper {

	HospitalDto map(Hospital hospital);

	Hospital unMap(HospitalDto dto);

}
