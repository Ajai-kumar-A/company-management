package com.mitrahsoft.company_management.dto.CompanyDto;

import java.util.List;

public record CompanyResponseDto(
        String companyId,
        String companyName,
        String companyDomain,
        List<BranchListResDto> branches
) {
}
