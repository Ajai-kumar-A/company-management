package com.mitrahsoft.company_management.dto.OfficeDetailsDto;


import java.time.LocalDate;

public record OfficialDetailsResponseDto(
        Long officialId,
        String officialMail,
        String experience,
        LocalDate joiningDate,
        String phoneNumber,
        Long employeeId
) {
}
