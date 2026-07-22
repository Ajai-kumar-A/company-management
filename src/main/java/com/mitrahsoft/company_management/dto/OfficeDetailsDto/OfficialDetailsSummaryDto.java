package com.mitrahsoft.company_management.dto.OfficeDetailsDto;

import java.time.LocalDate;

public record OfficialDetailsSummaryDto (
        Long officialId,
        String officialMail,
        String experience,
        LocalDate joiningDate,
        String phoneNumber
) {}
