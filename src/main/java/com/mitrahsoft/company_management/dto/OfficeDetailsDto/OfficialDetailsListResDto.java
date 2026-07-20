package com.mitrahsoft.company_management.dto.OfficeDetailsDto;

import java.time.LocalDate;

public record OfficialDetailsListResDto(
        String officialMail,
        String experience,
        LocalDate joiningDate,
        String phoneNumber
) {
}
