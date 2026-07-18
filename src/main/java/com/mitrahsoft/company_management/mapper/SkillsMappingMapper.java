package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.SkillsMappingDto.SkillsMappingRequestDto;
import com.mitrahsoft.company_management.dto.SkillsMappingDto.SkillsMappingResponseDto;
import com.mitrahsoft.company_management.dto.SkillsMappingDto.SkillsMappingUpdateDto;
import com.mitrahsoft.company_management.entity.SkillMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SkillsMappingMapper {
    SkillMapping toEntity(SkillsMappingRequestDto skillsMappingRequestDto);
    SkillsMappingResponseDto toDto(SkillMapping skillMapping);
    void updateEntityFromDto(SkillsMappingUpdateDto skillsMappingUpdateDto, @MappingTarget SkillMapping skillMapping);
    List<SkillsMappingResponseDto> toDtoList(List<SkillMapping> skillMappingList);
}
