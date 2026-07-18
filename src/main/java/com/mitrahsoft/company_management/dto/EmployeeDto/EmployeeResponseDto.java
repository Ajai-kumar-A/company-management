package com.mitrahsoft.company_management.dto.EmployeeDto;

public record EmployeeResponseDto(
        String employeeName,
        String employeeDesignation,
        Double employeeSalary
) {
}
