package com.mitrahsoft.company_management.dto.ProjectDto;

public record EmpProjectListDto(
        Long  employeeProjectId,
        String role,
        String status,
        ProjectSummaryDto project
) {
}
