package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeRequestDto;
import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeResponseDto;

import com.mitrahsoft.company_management.entity.Employee;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee toEntity(EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto toDto(Employee employee);
    void updateEntityFromDto(EmployeeRequestDto employeeRequestDto , @MappingTarget Employee employee);
    List<EmployeeResponseDto> toDtoList(List<Employee> employeeList);
}
