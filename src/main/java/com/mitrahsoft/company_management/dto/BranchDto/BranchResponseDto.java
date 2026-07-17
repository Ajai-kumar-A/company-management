package com.mitrahsoft.company_management.dto.BranchDto;

public record BranchResponseDto(
        String branchId,
        String branchLocation,
        String companyId
) {
}