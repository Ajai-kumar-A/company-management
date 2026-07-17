package com.mitrahsoft.company_management.dto.EmployeeDto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeeRequestDto(
        @NotBlank(message = "Employee name should not be null or empty")
        String employeeName,
        @NotBlank(message = "Employee Designation should not be null or empty")
        String employeeDesignation,
        @NotNull(message = "Employee Salary Should not be null")
        Double employeeSalary
) {
}

