package com.mitrahsoft.company_management.dto.ProjectDto;

public record ProjectSummaryDto(
        Long projectId,
        String projectName,
        String clientName
) {}
