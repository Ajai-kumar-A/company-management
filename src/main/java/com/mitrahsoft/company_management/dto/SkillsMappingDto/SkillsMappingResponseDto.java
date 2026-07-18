package com.mitrahsoft.company_management.dto.SkillsMappingDto;

import com.mitrahsoft.company_management.dto.SkillsDto.SkillsResponseDto;

public record SkillsMappingResponseDto(
        Long skillMappingId,
        String proficiencyLevel,
        Double skillExperienceYears,
        SkillsResponseDto skills
)  {
}
