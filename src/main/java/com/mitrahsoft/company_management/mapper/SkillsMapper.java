package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.SkillsDto.SkillsRequestDto;
import com.mitrahsoft.company_management.dto.SkillsDto.SkillsResponseDto;
import com.mitrahsoft.company_management.entity.Skills;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SkillsMapper {
    Skills toEntity(SkillsRequestDto skillsRequestDto);

    SkillsResponseDto toDto(Skills Skills);

    void updateEntityFromDto(SkillsRequestDto skillsRequestDto, @MappingTarget Skills skills);

    List<SkillsResponseDto> toDtoList(List<Skills> skillsList);
}
