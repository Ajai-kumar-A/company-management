package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.ProjectDto.ProjectReplaceReqDto;
import com.mitrahsoft.company_management.dto.ProjectDto.ProjectRequestDto;
import com.mitrahsoft.company_management.dto.ProjectDto.ProjectResponseDto;
import com.mitrahsoft.company_management.dto.ProjectDto.ProjectUpdateReqDto;
import com.mitrahsoft.company_management.entity.Project;
import com.mitrahsoft.company_management.mapper.ProjectMapper;
import com.mitrahsoft.company_management.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectService (ProjectRepository projectRepository, ProjectMapper projectMapper){
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    public ProjectResponseDto createProject(ProjectRequestDto projectRequestDto){
        Project project = projectMapper.toEntity(projectRequestDto);
        return projectMapper.toDto(projectRepository.save(project));
    }

    public List<ProjectResponseDto> fetchProjects(){
        return projectMapper.toDtoList(projectRepository.findAll());
    }

    public void replaceProject(ProjectReplaceReqDto projectReplaceReqDto, Long projectId){
        Project existingProject = projectRepository.findById(projectId).orElseThrow(() -> new NoSuchElementException("Project Id Not Found!"));
        projectMapper.replaceEntityFromDto(projectReplaceReqDto, existingProject);
        projectRepository.save(existingProject);
    }

    public void updateProject(ProjectUpdateReqDto projectUpdateReqDto, Long projectId){
        Project existingProject = projectRepository.findById(projectId).orElseThrow(() -> new NoSuchElementException("Project Id Not Found!"));
        projectMapper.updateEntityFromDto(projectUpdateReqDto,existingProject);
        projectRepository.save(existingProject);
    }


    public void deleteProject(Long projectId){
        Project existingProject= projectRepository.findById(projectId).orElseThrow(() -> new NoSuchElementException("Project Id Not Found!"));
        projectRepository.deleteById(projectId);
    }
}
