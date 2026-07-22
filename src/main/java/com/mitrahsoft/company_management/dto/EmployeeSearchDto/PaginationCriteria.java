package com.mitrahsoft.company_management.dto.EmployeeSearchDto;

import lombok.Data;

@Data
public class PaginationCriteria {
    private int page = 0;
    private int size = 10;
}
