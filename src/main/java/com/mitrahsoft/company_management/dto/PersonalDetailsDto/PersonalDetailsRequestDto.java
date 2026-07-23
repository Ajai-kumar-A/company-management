package com.mitrahsoft.company_management.dto.PersonalDetailsDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonalDetailsRequestDto {

    @NotBlank(message = "Email Required")
    @Email(message = "Invalid Email")
    private String personalMail;
    @NotNull(message = "DOB should not be null")
    private LocalDate dob;
    @NotBlank(message = "Blood Group should not be null")
    private String bloodGroup;
    @NotBlank(message = "Native Address should not be null")
    private String nativeAddress;
    @NotNull(message = "Employee Id should not be null")
    private Long employeeId;
}
