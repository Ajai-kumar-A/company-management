package com.mitrahsoft.company_management.dto.BranchDto;

import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeResponseDto;

import java.util.List;

public record BranchResponseDto(
        Long branchId,
        String branchLocation,
        Long companyId,
        List<EmployeeResponseDto> employeesList
) {
}