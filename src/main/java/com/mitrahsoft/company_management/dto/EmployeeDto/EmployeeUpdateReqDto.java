package com.mitrahsoft.company_management.dto.EmployeeDto;

import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsRequestDto;
import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsRequestDto;

public record EmployeeUpdateReqDto(
        String employeeName,
        String employeeDesignation,
        Double employeeSalary,
        Long branchId,
        Long techStackId,
        OfficialDetailsRequestDto officialDetails,
        PersonalDetailsRequestDto personalDetails
) {
}
