package com.mitrahsoft.company_management.dto.EmployeeDto;


import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsRequestDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeeRequestDto(
        @NotBlank(message = "Employee name should not be null or empty")
        String employeeName,
        @NotBlank(message = "Employee Designation should not be null or empty")
        String employeeDesignation,
        @NotNull(message = "Employee Salary Should not be null")
        Double employeeSalary,
        OfficialDetailsRequestDto officialDetails,
        Long skillMappingId,
        Long techStackId
) {
}

