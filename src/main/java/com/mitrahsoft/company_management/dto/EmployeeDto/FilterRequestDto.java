package com.mitrahsoft.company_management.dto.EmployeeDto;

import lombok.*;

import java.util.List;

@Data
public class FilterRequestDto {
    private String operator;
    private List<ConditionDto> conditions;
}
