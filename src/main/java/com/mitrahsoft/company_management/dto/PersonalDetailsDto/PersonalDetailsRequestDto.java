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
    @NotBlank(message = "DOB should not be null")
    private LocalDate dob;
    @NotBlank(message = "Blood Group should not be null")
    private String bloodGroup;
    @NotBlank(message = "Native Address should not be null")
    private String nativeAddress;
    @NotBlank(message = "Employee Id should not be null")
    private Long employeeId;
}
