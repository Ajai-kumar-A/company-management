package com.mitrahsoft.company_management.dto.BranchDto;

import jakarta.validation.constraints.NotBlank;

public record BranchReplaceReqDto(
        @NotBlank(message = "Branch location should not be null or empty")
        String branchLocation,
        @NotBlank(message = "Company Id should not be null or empty")
        String companyId
) {
}
