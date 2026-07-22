package com.mitrahsoft.company_management.dto.TechStackDto;

import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeRevResDto;

import java.util.List;

public record TechStackDetailsDto(
        Long id,
        String stackId,
        String stackName,
        String stackCategory,
        List<EmployeeRevResDto> employees
) {
}