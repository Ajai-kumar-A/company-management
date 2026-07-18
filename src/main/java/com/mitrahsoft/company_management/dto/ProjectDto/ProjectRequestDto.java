package com.mitrahsoft.company_management.dto.ProjectDto;

import jakarta.validation.constraints.NotBlank;

public record ProjectRequestDto(
        @NotBlank(message = "Project Name should not be null or empty")
        String projectName,
        @NotBlank(message = "Client Name should not be null or empty")
        String clientName
) {
}
