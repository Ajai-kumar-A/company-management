package com.mitrahsoft.company_management.dto.SkillsDto;

import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeRevResDto;

import java.util.List;

public record SkillRevResDto(
        Long skillId,
        String skillName,
        String skillCategory,
        List<EmployeeRevResDto> employees
) {}
