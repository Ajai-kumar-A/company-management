package com.mitrahsoft.company_management.dto.OfficeDetailsDto;


import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeRevResDto;

import java.time.LocalDate;

public record OfficialDetailsResponseDto(
        String officialMail,
        String experience,
        LocalDate joiningDate,
        String phoneNumber,
        EmployeeRevResDto employee
) {
}
