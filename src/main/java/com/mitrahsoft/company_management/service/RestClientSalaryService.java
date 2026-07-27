package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.RestClientSalaryDto.RestClientEmployeeResDto;
import com.mitrahsoft.company_management.dto.RestClientSalaryDto.SalaryDetailsDto;
import com.mitrahsoft.company_management.entity.Employee;
import com.mitrahsoft.company_management.mapper.EmployeeMapper;
import com.mitrahsoft.company_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.NoSuchElementException;

@Service
public class RestClientSalaryService {
    private final EmployeeRepository employeeRepository;
    private final RestClient restClient;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public RestClientSalaryService(EmployeeRepository employeeRepository, RestClient restClient, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.restClient = restClient;
        this.employeeMapper = employeeMapper;
    }

    public RestClientEmployeeResDto getEmployeeWithRestClientSalary(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NoSuchElementException("Employee not found"));
        SalaryDetailsDto salaryDetails = restClient.get()
                .uri("/employee/{employeeId}",employee.getEmployeeId())
                .retrieve()
                .body(SalaryDetailsDto.class);
        RestClientEmployeeResDto employeeResponse = employeeMapper.toRestClientEmployeeResDto(employee);
        employeeResponse.setSalaryDetails(salaryDetails);
        return employeeResponse;
    }
}
