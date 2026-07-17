package com.mitrahsoft.company_management.dto.BranchDto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BranchRequestDto(
        @NotBlank(message = "Branch Id should not be null or empty")
        String branchId,
        @NotBlank(message = "Branch location should not be null or empty")
        String branchLocation,
        @NotBlank(message = "Company Id should not be null or empty")
        String companyId
) {
}
