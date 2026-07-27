package com.mitrahsoft.company_management.dto.SalaryDto;

public record SalaryDto(
        Long salaryId,
        Double basicPay,
        Double pfAmount,
        Double takeHomeSalary
) {}
