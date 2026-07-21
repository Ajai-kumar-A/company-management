package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.ProjectDto.ProjectReplaceReqDto;
import com.mitrahsoft.company_management.dto.ProjectDto.ProjectRequestDto;
import com.mitrahsoft.company_management.dto.ProjectDto.ProjectResponseDto;
import com.mitrahsoft.company_management.dto.ProjectDto.ProjectUpdateReqDto;
import com.mitrahsoft.company_management.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.lang.annotation.Target;
import java.util.List;

@Mapper(componentModel = "spring", uses = EmployeeProjectMapper.class, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProjectMapper {
    Project toEntity(ProjectRequestDto projectRequestDto);

    ProjectResponseDto toDto(Project project);

    void replaceEntityFromDto(ProjectReplaceReqDto projectReplaceReqDto, @MappingTarget Project project);

    void updateEntityFromDto(ProjectUpdateReqDto projectUpdateReqDto, @MappingTarget Project project);

    List<ProjectResponseDto> toDtoList(List<Project> projectList);
}
