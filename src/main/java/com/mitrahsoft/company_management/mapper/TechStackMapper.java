package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeRevResDto;
import com.mitrahsoft.company_management.dto.TechStackDto.TechStackDetailsDto;
import com.mitrahsoft.company_management.dto.TechStackDto.TechStackRequestDto;
import com.mitrahsoft.company_management.dto.TechStackDto.TechStackResponseDto;
import com.mitrahsoft.company_management.entity.Employee;
import com.mitrahsoft.company_management.entity.TechStack;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TechStackMapper {

    @Autowired
    protected EmployeeMapper employeeMapper;

    public abstract TechStack toEntity(TechStackRequestDto techStackRequestDto);

    public abstract TechStackResponseDto toDto(TechStack techStack);

    public abstract List<TechStackResponseDto> toDtoList(List<TechStack> techStackList);

    @Mapping(target = "employees", source = "employees")
    public abstract TechStackDetailsDto toDetailsDto(TechStack techStack);

    protected List<EmployeeRevResDto> map(List<Employee> employees) {
        return employees.stream().map(employeeMapper::toRevResDto).toList();
    }
}