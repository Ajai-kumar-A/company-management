package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.EmpProjectDto.EmpProjectReplaceReqDto;
import com.mitrahsoft.company_management.dto.EmpProjectDto.EmpProjectReqDto;
import com.mitrahsoft.company_management.dto.EmpProjectDto.EmpProjectResDto;
import com.mitrahsoft.company_management.dto.EmpProjectDto.EmpProjectUpdateReq;
import com.mitrahsoft.company_management.entity.Employee;
import com.mitrahsoft.company_management.entity.EmployeeProject;
import com.mitrahsoft.company_management.entity.Project;
import com.mitrahsoft.company_management.mapper.EmployeeProjectMapper;
import com.mitrahsoft.company_management.repository.EmpProjectRepository;
import com.mitrahsoft.company_management.repository.EmployeeRepository;
import com.mitrahsoft.company_management.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmpProjectService {
    private final ProjectRepository projectRepository;
    private final EmpProjectRepository empProjectRepository;
    private final EmployeeProjectMapper employeeProjectMapper;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmpProjectService(ProjectRepository projectRepository, EmployeeProjectMapper employeeProjectMapper, EmpProjectRepository empProjectRepository, EmployeeRepository employeeRepository) {
        this.projectRepository = projectRepository;
        this.empProjectRepository = empProjectRepository;
        this.employeeProjectMapper = employeeProjectMapper;
        this.employeeRepository = employeeRepository;
    }

@CacheEvict(value = "employeeProjectList", allEntries = true)
    public EmpProjectResDto createEmpProject(EmpProjectReqDto empProjectReqDto) {
        Project project = projectRepository.findById(empProjectReqDto.projectId()).orElseThrow(() -> new NoSuchElementException("Project Id not found!"));
        Employee employee = employeeRepository.findById(empProjectReqDto.employeeId()).orElseThrow(() -> new NoSuchElementException("Employee Id not found!"));
        EmployeeProject employeeProject = employeeProjectMapper.toEntity(empProjectReqDto);
        employeeProject.setProject(project);
        employeeProject.setEmployee(employee);
        return employeeProjectMapper.toDto(empProjectRepository.save(employeeProject));
    }

    @Cacheable("employeeProjectList")
    public List<EmpProjectResDto> fetchEmpProject() {
        return employeeProjectMapper.toDtoList(empProjectRepository.findAll());
    }

    public void replaceEmpProject(EmpProjectReplaceReqDto empProjectReplaceReqDto, Long employeeProjectId) {
        EmployeeProject existingEmpProject = empProjectRepository.findById(employeeProjectId).orElseThrow(() -> new NoSuchElementException("Employee Project Id Not Found!"));
        Project project = projectRepository.findById(empProjectReplaceReqDto.projectId()).orElseThrow(() -> new NoSuchElementException("Project Id not found!"));
        Employee employee = employeeRepository.findById(empProjectReplaceReqDto.employeeId()).orElseThrow(() -> new NoSuchElementException("Employee Id not found!"));

        employeeProjectMapper.replaceEntityFromDto(empProjectReplaceReqDto, existingEmpProject);
        existingEmpProject.setProject(project);
        existingEmpProject.setEmployee(employee);
        empProjectRepository.save(existingEmpProject);
    }

    public void updateEmpProject(EmpProjectUpdateReq empProjectUpdateReq, Long employeeProjectId) {
        EmployeeProject existingEmpProject = empProjectRepository.findById(employeeProjectId).orElseThrow(() -> new NoSuchElementException("Employee Project Id Not Found!"));
        employeeProjectMapper.updateEntityFromDto(empProjectUpdateReq, existingEmpProject);
        existingEmpProject.getProject().getEmployeeProjectList().forEach(each -> {
            if (each.getEmployeeProjectId().equals(existingEmpProject.getEmployeeProjectId())) {
                each.setRole(existingEmpProject.getRole());
                each.setStatus(existingEmpProject.getStatus());
            }
        });
        empProjectRepository.save(existingEmpProject);
    }


    public void deleteEmpProject(Long employeeProjectId) {
        EmployeeProject existingEmpProject = empProjectRepository.findById(employeeProjectId).orElseThrow(() -> new NoSuchElementException("Employee Project Id Not Found!"));
        existingEmpProject.getProject().getEmployeeProjectList().remove(existingEmpProject);
        empProjectRepository.deleteById(employeeProjectId);
    }
}
