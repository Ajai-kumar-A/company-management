package com.mitrahsoft.company_management.service;


import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeRequestDto;
import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeResponseDto;
import com.mitrahsoft.company_management.entity.Employee;
import com.mitrahsoft.company_management.entity.OfficialDetails;
import com.mitrahsoft.company_management.entity.PersonalDetails;
import com.mitrahsoft.company_management.entity.TechStack;
import com.mitrahsoft.company_management.mapper.EmployeeMapper;
import com.mitrahsoft.company_management.repository.EmployeeRepository;
import com.mitrahsoft.company_management.repository.TechStackRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final TechStackRepository techStackRepository;

    public EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto) {
        Employee employee = employeeMapper.toEntity(employeeRequestDto);
        OfficialDetails officialDetails = employee.getOfficialDetails();
        if (officialDetails != null) {
            officialDetails.setEmployee(employee);
        }
        PersonalDetails personalDetails = employee.getPersonalDetails();
        if (personalDetails != null) {
            personalDetails.setEmployee(employee);
        }
        TechStack techStack = employee.getTechStack();
        if (techStack != null) {
            employee.setTechStack(techStack);
        }
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDto(savedEmployee);
    }

    public List<EmployeeResponseDto> findAllEmployees() {
        return employeeMapper.toDtoList(employeeRepository.findAll());
    }

    public EmployeeResponseDto getEmployee(Long employeeId) {

        Employee employee = employeeRepository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        return employeeMapper.toDto(employee);
    }

    public EmployeeResponseDto updateEmployee(EmployeeRequestDto dto, Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NoSuchElementException("Employee Id Not Found"));
        employeeMapper.updateEntityFromDto(dto, employee);
        TechStack techStack = techStackRepository.findById(dto.techStackId())
                .orElseThrow(() -> new EntityNotFoundException("Tech Stack not found"));
        employee.setTechStack(techStack);
        Employee updatedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDto(updatedEmployee);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.findById(employeeId).orElseThrow(() -> new NoSuchElementException("Employee Id Not Found"));
        employeeRepository.deleteById(employeeId);
    }
}
