package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeRevResDto;
import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsListResDto;
import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsRequestDto;
import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsResponseDto;
import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsSummaryDto;
import com.mitrahsoft.company_management.entity.Employee;
import com.mitrahsoft.company_management.entity.PersonalDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonalDetailsMapper {

    PersonalDetails toEntity(PersonalDetailsRequestDto personalDetailsRequestDto);

    @Mapping(target = "employee", source = "employee")
    PersonalDetailsResponseDto toDto(PersonalDetails personalDetails);

    @Mapping(target = "employee", source = "employee")
    PersonalDetailsListResDto toListDto(PersonalDetails personalDetails);

    PersonalDetailsSummaryDto toSummaryDto(PersonalDetails personalDetails);

    List<PersonalDetailsListResDto> toDtoList(List<PersonalDetails> personalDetailsList);

    @Mapping(target = "branchId", source = "branch.branchId")
    @Mapping(target = "stackId", source = "techStack.id")
    EmployeeRevResDto toEmployeeDto(Employee employee);
}
