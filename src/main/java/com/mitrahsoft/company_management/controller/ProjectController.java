package com.mitrahsoft.company_management.controller;

import com.mitrahsoft.company_management.dto.ProjectDto.*;
import com.mitrahsoft.company_management.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/add")
    public ResponseEntity<ProjectResponseDto> createProject(@Valid @RequestBody ProjectRequestDto projectRequestDto){
        return new ResponseEntity<>(projectService.createProject(projectRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProjectResponseDto>> fetchProjects(){
        return new ResponseEntity<>(projectService.fetchProjects(),HttpStatus.OK);
    }

    @GetMapping("/get/{projectId}")
    public ResponseEntity<ProjectDetailsDto> getProject(@PathVariable Long projectId) {
        return new ResponseEntity<>(projectService.getProject(projectId), HttpStatus.OK);
    }

    @PutMapping("/modify/{projectId}")
    public ResponseEntity<String> replaceProject(@Valid @RequestBody ProjectReplaceReqDto projectReplaceReqDto, @PathVariable Long projectId){
        projectService.replaceProject(projectReplaceReqDto, projectId);
        return new ResponseEntity<>("Project replaced successfully",HttpStatus.OK);
    }

    @PatchMapping("/update/{projectId}")
    public ResponseEntity<String> updateProject(@Valid @RequestBody ProjectUpdateReqDto projectUpdateReqDto, @PathVariable Long projectId){
        projectService.updateProject(projectUpdateReqDto, projectId);
        return new ResponseEntity<>("Project updated successfully",HttpStatus.OK);
    }

    @DeleteMapping("/delete/{projectId}")
    public ResponseEntity<String> deleteProject(@PathVariable Long projectId){
        projectService.deleteProject(projectId);
        return new ResponseEntity<>("Project deleted successfully",HttpStatus.OK);
    }
}
