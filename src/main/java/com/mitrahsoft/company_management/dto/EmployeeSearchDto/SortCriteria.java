package com.mitrahsoft.company_management.dto.EmployeeSearchDto;

import lombok.Data;

@Data
public class SortCriteria {
    private String columnName;
    private String direction = "ASC"; // "ASC" or "DESC"
}
