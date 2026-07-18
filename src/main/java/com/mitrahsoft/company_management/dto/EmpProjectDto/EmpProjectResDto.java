package com.mitrahsoft.company_management.dto.EmpProjectDto;

public record EmpProjectResDto(
         Long  employeeProjectId,
         String role,
         String status,
         Long projectId
) {
}
