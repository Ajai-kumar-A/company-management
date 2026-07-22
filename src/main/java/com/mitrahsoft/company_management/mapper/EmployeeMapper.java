package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeRequestDto;
import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeResponseDto;

import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeUpdateReqDto;
import com.mitrahsoft.company_management.entity.Employee;

import org.mapstruct.*;
import org.springframework.data.domain.Page;

import java.util.List;
@Mapper(componentModel = "spring",uses = {EmployeeProjectMapper.class, PersonalDetailsMapper.class, OfficialDetailsMapper.class, TechStackMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EmployeeMapper {
    Employee toEntity(EmployeeRequestDto employeeRequestDto);
    @Mapping(target = "branchId", source = "branch.branchId")
    @Mapping(target = "stackId" ,source = "techStack.id")
    EmployeeResponseDto toDto(Employee employee);
    void updateEntityFromDto(EmployeeUpdateReqDto employeeUpdateReqDto , @MappingTarget Employee employee);
    List<EmployeeResponseDto> toDtoList(List<Employee> employeeList);;
}

