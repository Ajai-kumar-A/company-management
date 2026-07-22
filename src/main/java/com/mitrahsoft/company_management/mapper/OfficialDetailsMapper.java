package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeRevResDto;
import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsListResDto;
import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsResponseDto;
import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsRequestDto;
import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsSummaryDto;
import com.mitrahsoft.company_management.entity.Employee;
import com.mitrahsoft.company_management.entity.OfficialDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
@Mapper(componentModel = "spring")
public interface OfficialDetailsMapper {

    OfficialDetails toEntity(OfficialDetailsRequestDto officialDetailsRequestDto);

    @Mapping(target = "employee", source = "employee")
    OfficialDetailsResponseDto toDto(OfficialDetails officialDetails);

    @Mapping(target = "employee", source = "employee")
    OfficialDetailsListResDto toListDto(OfficialDetails officialDetails);

    List<OfficialDetailsListResDto> toDtoList(List<OfficialDetails> officialDetailsList);

    OfficialDetailsSummaryDto toSummaryDto(OfficialDetails officialDetails);

    @Mapping(target = "branchId", source = "branch.branchId")
    @Mapping(target = "stackId", source = "techStack.id")
    EmployeeRevResDto toEmployeeDto(Employee employee);

    void updateEntityFromDto(OfficialDetailsRequestDto officialDetailsRequestDto, @MappingTarget OfficialDetails officialDetails);
}
