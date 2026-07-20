package com.mitrahsoft.company_management.dto.PersonalDetailsDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonalDetailsRequestDto {

    @NotBlank(message = "Email Required")
    @Email(message = "Invalid Email")
    private String personalMail;
    private LocalDate dob;
    private String bloodGroup;
    private String nativeAddress;
    private Long employeeId;
}
