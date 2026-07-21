package com.mitrahsoft.company_management.dto.EmployeeDto;

import lombok.*;

@Data
public class ConditionDto {
    private String columnName;
    private String operator;
    private String value;
}
