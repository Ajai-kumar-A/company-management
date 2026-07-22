package com.mitrahsoft.company_management.dto.EmployeeSearchDto;

import lombok.Data;

import java.util.List;

@Data
public class FilterWrapper {
    private String operator;
    private List<SearchCondition> conditions;
}
