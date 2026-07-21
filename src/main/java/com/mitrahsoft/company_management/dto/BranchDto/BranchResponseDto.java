package com.mitrahsoft.company_management.dto.BranchDto;

import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeResponseDto;
import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeRevResDto;

import java.util.List;

public record BranchResponseDto(
        Long branchId,
        String branchLocation,
        Long companyId,
        List<EmployeeRevResDto> employeesList
) {
}