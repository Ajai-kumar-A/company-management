package com.mitrahsoft.company_management.dto.PersonalDetails;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonalDetailsResponseDto {
    private Long personalId;
    private String personalMail;
    private LocalDate dob;
    private String bloodGroup;
    private String nativeAddress;
}
