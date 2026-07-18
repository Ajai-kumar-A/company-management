package com.mitrahsoft.company_management.dto.BranchDto;

public record BranchResponseDto(
        Long branchId,
        String branchLocation,
        Long companyId
) {
}