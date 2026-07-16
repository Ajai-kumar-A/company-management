package com.mitrahsoft.company_management.dto;

import jakarta.validation.constraints.NotBlank;

public record CompanyReplaceReqDto(
        @NotBlank(message = "Company location should not be null or empty")
        String companyName,
        @NotBlank(message = "Company domain should not be null or empty")
        String companyDomain
) {
}
