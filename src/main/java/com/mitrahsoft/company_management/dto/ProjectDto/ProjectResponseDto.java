package com.mitrahsoft.company_management.dto.ProjectDto;

import java.util.List;

public record ProjectResponseDto(
        Long projectId,
        String projectName,
        String clientName,
        List<EmpProjectListDto> employeeProjectList
) {
}
