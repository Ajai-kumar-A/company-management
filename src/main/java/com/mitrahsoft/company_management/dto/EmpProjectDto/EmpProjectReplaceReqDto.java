package com.mitrahsoft.company_management.dto.EmpProjectDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmpProjectReplaceReqDto (
        @NotBlank(message = "Employee Project Role should not be null or empty")
        String role,
        @NotBlank(message = "Employee Project Status should not be null or empty")
        String status,
        @NotNull(message = "Project Id should not be null or empty")
        Long projectId
){
}
