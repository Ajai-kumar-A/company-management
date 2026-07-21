package com.mitrahsoft.company_management.dto.EmpProjectDto;

import com.mitrahsoft.company_management.dto.ProjectDto.ProjectSummaryDto;

public record EmpProjectResDto(
         Long  employeeProjectId,
         String role,
         String status,
         ProjectSummaryDto project
) {
}
