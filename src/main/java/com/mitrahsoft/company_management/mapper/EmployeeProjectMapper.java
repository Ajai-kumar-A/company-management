package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.EmpProjectDto.EmpProjectReplaceReqDto;
import com.mitrahsoft.company_management.dto.EmpProjectDto.EmpProjectReqDto;
import com.mitrahsoft.company_management.dto.EmpProjectDto.EmpProjectResDto;
import com.mitrahsoft.company_management.dto.EmpProjectDto.EmpProjectUpdateReq;
import com.mitrahsoft.company_management.entity.EmployeeProject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel= "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EmployeeProjectMapper{
    EmployeeProject toEntity(EmpProjectReqDto empProjectReqDto);
    @Mapping(target = "projectId", source = "project.projectId")
    EmpProjectResDto toDto(EmployeeProject employeeProject);
    void replaceEntityFromDto(EmpProjectReplaceReqDto empProjectReplaceReqDto, @MappingTarget EmployeeProject employeeProject);
    void updateEntityFromDto(EmpProjectUpdateReq empProjectUpdateReq, @MappingTarget EmployeeProject employeeProject);
    List<EmpProjectResDto> toDtoList(List<EmployeeProject> employeeProjectList);
}
