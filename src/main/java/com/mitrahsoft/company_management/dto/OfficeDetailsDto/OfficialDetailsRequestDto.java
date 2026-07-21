package com.mitrahsoft.company_management.dto.OfficeDetailsDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record OfficialDetailsRequestDto(
        @NotBlank(message = "email should not be null or empty")
        @Email
        String officialMail,
        @NotBlank(message = "Experience domain should not be null or empty")
        String experience,
        @NotNull(message = "Joining date should not be null ")
        LocalDate joiningDate,
        @NotBlank(message = "Phone Number should not be null or empty")
        String phoneNumber,
        @NotNull(message = "Employee Id should not be null")
        Long employeeId
) {
}
