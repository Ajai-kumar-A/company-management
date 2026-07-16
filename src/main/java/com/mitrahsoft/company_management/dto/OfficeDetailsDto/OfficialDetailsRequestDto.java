package com.mitrahsoft.company_management.dto.OfficeDetailsDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record OfficialDetailsRequestDto(
        @NotBlank(message = "Company location should not be null or empty")
        String officialMail,
        @NotBlank(message = "Company domain should not be null or empty")
        String experience,
        @NotNull(message = "Company domain should not be null or empty")
        LocalDate joiningDate,
        @NotBlank(message = "Company domain should not be null or empty")
        String phoneNumber

) {
}
