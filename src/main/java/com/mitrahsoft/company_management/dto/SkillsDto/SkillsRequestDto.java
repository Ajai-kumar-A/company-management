package com.mitrahsoft.company_management.dto.SkillsDto;

import jakarta.validation.constraints.NotBlank;


public record SkillsRequestDto (
        @NotBlank(message = "Skill name should not be null or empty")
        String skillName,
        @NotBlank(message = "Skill category should not be null or empty")
        String skillCategory
){
}
