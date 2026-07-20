package com.mitrahsoft.company_management.dto.PersonalDetailsDto;

import java.time.LocalDate;

public record PersonalDetailsListResDto (
        Long personalId,
        String personalMail,
        LocalDate dob,
        String bloodGroup,
        String nativeAddress
){
}
