package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsResponseDto;
import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsRequestDto;
import com.mitrahsoft.company_management.entity.OfficialDetails;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OfficialDetailsMapper {
    OfficialDetails toEntity(OfficialDetailsRequestDto officeDetailsRequestDto);
    OfficialDetailsResponseDto toDto(OfficialDetails officialDetails);
    void updateEntityFromDto(
            OfficialDetailsRequestDto dto,
            @MappingTarget OfficialDetails entity);
}
