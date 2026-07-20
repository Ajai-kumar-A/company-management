package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeRequestDto;
import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeResponseDto;
import com.mitrahsoft.company_management.entity.*;
import com.mitrahsoft.company_management.mapper.EmployeeMapper;
import com.mitrahsoft.company_management.repository.BranchRepository;
import com.mitrahsoft.company_management.repository.EmployeeRepository;
import com.mitrahsoft.company_management.repository.TechStackRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final TechStackRepository techStackRepository;
    private final BranchRepository branchRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository,TechStackRepository techStackRepository,BranchRepository branchRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.branchRepository = branchRepository;
        this.techStackRepository = techStackRepository;
    }

    public EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto) {
        Branch branch = branchRepository.findById(employeeRequestDto.branchId()).orElseThrow(()-> new NoSuchElementException("Branch Id not found!"));
        TechStack techStack = techStackRepository.findById(employeeRequestDto.techStackId()).orElseThrow(() -> new EntityNotFoundException("Tech Stack not found"));
        Employee employee = employeeMapper.toEntity(employeeRequestDto);
        OfficialDetails officialDetails = employee.getOfficialDetails();
        employee.setBranch(branch);
        employee.setTechStack(techStack);
        if (officialDetails != null) {
            officialDetails.setEmployee(employee);
        }
        PersonalDetails personalDetails = employee.getPersonalDetails();
        if (personalDetails != null) {
            personalDetails.setEmployee(employee);
        }
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    public List<EmployeeResponseDto> findAllEmployees() {
        return employeeMapper.toDtoList(employeeRepository.findAll());
    }

    public EmployeeResponseDto getEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return employeeMapper.toDto(employee);
    }

    public EmployeeResponseDto updateEmployee(EmployeeRequestDto employeeRequestDto, Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new NoSuchElementException("Employee Id Not Found"));
        Branch branch = branchRepository.findById(employeeRequestDto.branchId()).orElseThrow(()-> new NoSuchElementException("Branch Id not found!"));
        TechStack techStack = techStackRepository.findById(employeeRequestDto.techStackId()).orElseThrow(() -> new EntityNotFoundException("Tech Stack not found"));
        employeeMapper.updateEntityFromDto(employeeRequestDto, employee);
        employee.setBranch(branch);
        employee.setTechStack(techStack);
        Employee updatedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDto(updatedEmployee);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.findById(employeeId).orElseThrow(() -> new NoSuchElementException("Employee Id Not Found"));
        employeeRepository.deleteById(employeeId);
    }
}
