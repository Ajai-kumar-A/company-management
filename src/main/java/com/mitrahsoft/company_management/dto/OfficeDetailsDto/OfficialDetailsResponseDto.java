package com.mitrahsoft.company_management.dto.OfficeDetailsDto;


import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeReturnDto;

import java.time.LocalDate;

public record OfficialDetailsResponseDto(
        Long officialId,
        String officialMail,
        String experience,
        LocalDate joiningDate,
        String phoneNumber,
        EmployeeReturnDto employeeDetails
) {
}
