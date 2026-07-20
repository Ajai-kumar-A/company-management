package com.mitrahsoft.company_management.dto.EmployeeDto;


import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsRequestDto;
import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsRequestDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeeRequestDto(
        @NotBlank(message = "Employee name should not be null or empty")
        String employeeName,
        @NotBlank(message = "Employee Designation should not be null or empty")
        String employeeDesignation,
        @NotNull(message = "Employee Salary Should not be null")
        Double employeeSalary,
        @NotNull(message = "Branch Id Should not be null")
        Long branchId,
        Long hardwareId,
        Long techStackId,
        Long skillMappingId,
        OfficialDetailsRequestDto officialDetails,
        PersonalDetailsRequestDto personalDetails

) {
}

