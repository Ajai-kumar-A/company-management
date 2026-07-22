package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsResponseDto;
import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsRequestDto;
import com.mitrahsoft.company_management.entity.OfficialDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
@Mapper(componentModel = "spring",uses = {EmployeeMapper.class})
public interface OfficialDetailsMapper {
    OfficialDetails toEntity(OfficialDetailsRequestDto officeDetailsRequestDto);
    @Mapping(target = "employee")
    OfficialDetailsResponseDto toDto(OfficialDetails officialDetails);

    void updateEntityFromDto(OfficialDetailsRequestDto dto, @MappingTarget OfficialDetails entity);

    List<OfficialDetailsResponseDto> toDtoList(List<OfficialDetails> officialDetailsList);
}
