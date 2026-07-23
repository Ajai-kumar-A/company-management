package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.ProjectDto.*;
import com.mitrahsoft.company_management.entity.Project;
import com.mitrahsoft.company_management.mapper.ProjectMapper;
import com.mitrahsoft.company_management.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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

    @CacheEvict(value = "projectList", allEntries = true)
    public ProjectResponseDto createProject(ProjectRequestDto projectRequestDto){
        Project project = projectMapper.toEntity(projectRequestDto);
        return projectMapper.toDto(projectRepository.save(project));
    }

    @Cacheable("projectList")
    public List<ProjectResponseDto> fetchProjects(){
        return projectMapper.toDtoList(projectRepository.findAll());
    }

    @Cacheable(value = "project", key = "#projectId")
    public ProjectDetailsDto getProject(Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new NoSuchElementException("Project Id Not Found"));
        return projectMapper.toDetailsDto(project);
    }

    @Caching(put = @CachePut(value = "project", key = "#projectId"),
            evict = @CacheEvict(value = "projectList", allEntries = true))
    public void replaceProject(ProjectReplaceReqDto projectReplaceReqDto, Long projectId){
        Project existingProject = projectRepository.findById(projectId).orElseThrow(() -> new NoSuchElementException("Project Id Not Found!"));
        projectMapper.replaceEntityFromDto(projectReplaceReqDto, existingProject);
        projectRepository.save(existingProject);
    }

    @Caching(put = @CachePut(value = "project", key = "#projectId"),
            evict = @CacheEvict(value = "projectList", allEntries = true))
    public void updateProject(ProjectUpdateReqDto projectUpdateReqDto, Long projectId){
        Project existingProject = projectRepository.findById(projectId).orElseThrow(() -> new NoSuchElementException("Project Id Not Found!"));
        projectMapper.updateEntityFromDto(projectUpdateReqDto,existingProject);
        projectRepository.save(existingProject);
    }


    @Caching(evict = {@CacheEvict(value = "project", key = "#projectId"),
             @CacheEvict(value = "projectList", allEntries = true)})
    public void deleteProject(Long projectId){
        Project existingProject= projectRepository.findById(projectId).orElseThrow(() -> new NoSuchElementException("Project Id Not Found!"));
        projectRepository.deleteById(projectId);
    }
}
