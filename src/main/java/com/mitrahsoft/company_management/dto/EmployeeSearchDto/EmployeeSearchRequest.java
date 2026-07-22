package com.mitrahsoft.company_management.dto.EmployeeSearchDto;

import lombok.Data;
import java.util.List;

@Data
public class EmployeeSearchRequest {
    private PaginationCriteria pagination;
    private List<SortCriteria> sorting; // Allows multi-field sorting
    private FilterWrapper filters;
}

