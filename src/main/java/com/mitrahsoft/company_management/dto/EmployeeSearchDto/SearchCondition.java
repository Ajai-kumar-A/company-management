package com.mitrahsoft.company_management.dto.EmployeeSearchDto;

import lombok.Data;

@Data
public class SearchCondition {
    private String columnName;
    private String operator;
    private String value;
}
