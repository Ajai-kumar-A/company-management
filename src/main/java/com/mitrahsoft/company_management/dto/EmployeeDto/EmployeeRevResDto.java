package com.mitrahsoft.company_management.dto.EmployeeDto;

import lombok.Data;

@Data
public class EmployeeRevResDto {
    Long employeeId;
    String employeeName;
    String employeeDesignation;
    Double employeeSalary;
    Long branchId;
    Long stackId;
}
