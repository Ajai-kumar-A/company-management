package com.mitrahsoft.company_management.dto.BranchDto;

import jakarta.validation.constraints.Null;

public record BranchUpdateReqDto(
        String branchLocation,
        @Null(message = "Can't change mapped company")
        Long companyId
) {
}
