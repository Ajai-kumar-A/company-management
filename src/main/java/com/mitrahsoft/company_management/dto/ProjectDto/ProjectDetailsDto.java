package com.mitrahsoft.company_management.dto.ProjectDto;

import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeRevResDto;

import java.util.List;

public record ProjectDetailsDto(
        Long projectId,
        String projectName,
        String clientName,
        List<EmployeeRevResDto> employees
) {
}
