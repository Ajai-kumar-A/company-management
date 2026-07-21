package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsResponseDto;
import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsRequestDto;
import com.mitrahsoft.company_management.entity.OfficialDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
//uses = {SkillsMapper.class,EmployeeMapper.class}
@Mapper(componentModel = "spring",uses = {EmployeeMapper.class})
public interface OfficialDetailsMapper {
    OfficialDetails toEntity(OfficialDetailsRequestDto officeDetailsRequestDto);

    //    @Mapping(target = "employee",source = "employee.employee")
    @Mapping(source = "employee", target = "employeeDetails")
    OfficialDetailsResponseDto toDto(OfficialDetails officialDetails);

    void updateEntityFromDto(OfficialDetailsRequestDto dto, @MappingTarget OfficialDetails entity);

    List<OfficialDetailsResponseDto> toDtoList(List<OfficialDetails> officialDetailsList);
}
