package com.mitrahsoft.company_management.dto.microService;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class SalaryDetailsDto {
    private Long id;
    private Long employeeId;
    private BigDecimal basicSalary;
}
