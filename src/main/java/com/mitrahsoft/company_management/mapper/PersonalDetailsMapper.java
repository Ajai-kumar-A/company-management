package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsListResDto;
import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsRequestDto;
import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsResponseDto;
import com.mitrahsoft.company_management.entity.PersonalDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {EmployeeMapper.class})
public interface PersonalDetailsMapper {

    PersonalDetails toEntity(PersonalDetailsRequestDto personalDetailsRequestDto);
//    @Mapping(target = "employeeId",source = "employee.employeeId")
    @Mapping(source = "employee", target = "employeeDetails")
    PersonalDetailsResponseDto toDto(PersonalDetails personalDetails);
    List<PersonalDetailsListResDto> toDtoList(List<PersonalDetails> personalDetailsList);

}
