package com.mitrahsoft.company_management.dto.SkillsMappingDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SkillsMappingUpdateDto(
        @NotBlank(message = "Skills Mapping proficiency should not be null or empty")
        String proficiencyLevel,
        @NotNull(message = "Skills Mapping Experience should not be null or empty")
        Double skillExperienceYears
){
}
