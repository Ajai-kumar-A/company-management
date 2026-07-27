package com.mitrahsoft.company_management.dto.RestClientSalaryDto;

import java.math.BigDecimal;

public record SalaryDetailsDto(
        Long salaryId,
        Long employeeId,
        BigDecimal basicSalary,
        BigDecimal grossSalary,
        BigDecimal netSalary
) {
}
