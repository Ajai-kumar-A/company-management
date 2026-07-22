package com.mitrahsoft.company_management.dto.PersonalDetailsDto;

import java.time.LocalDate;

public record PersonalDetailsSummaryDto (
        Long personalId,
        String personalMail,
        LocalDate dob,
        String bloodGroup,
        String nativeAddress
) {}
