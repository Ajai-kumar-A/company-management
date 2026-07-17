package com.mitrahsoft.company_management.dto.SkillsMappingDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SkillsMappingRequestDto(
        @NotBlank(message = "Skills Mapping Id should not be null or empty")
        String skillMappingId,
        @NotBlank(message = "proficiency level should not be null or empty")
        String proficiencyLevel,
        @NotNull(message = "skill Experience should not be null or empty")
        Double skillExperienceYears
) {
}
