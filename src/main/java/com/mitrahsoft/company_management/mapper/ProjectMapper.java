package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeRevResDto;
import com.mitrahsoft.company_management.dto.ProjectDto.*;
import com.mitrahsoft.company_management.entity.EmployeeProject;
import com.mitrahsoft.company_management.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Target;
import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class ProjectMapper {
    @Autowired
    protected EmployeeMapper employeeMapper;

    public abstract Project toEntity(ProjectRequestDto projectRequestDto);

    public abstract ProjectResponseDto toDto(Project project);

    @Mapping(target = "employees", source = "employeeProjectList")
    public abstract ProjectDetailsDto toDetailsDto(Project project);

    public abstract void replaceEntityFromDto(ProjectReplaceReqDto projectReplaceReqDto, @MappingTarget Project project);

    public abstract void updateEntityFromDto(ProjectUpdateReqDto projectUpdateReqDto, @MappingTarget Project project);

    public abstract List<ProjectResponseDto> toDtoList(List<Project> projectList);

    protected List<EmployeeRevResDto> map(List<EmployeeProject> employeeProjects) {
        return employeeProjects.stream().map(ep -> employeeMapper.toRevResDto(ep.getEmployee())).toList();
    }
}
