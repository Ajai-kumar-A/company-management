package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.RestClientSalaryDto.RestClientEmployeeResDto;
import com.mitrahsoft.company_management.dto.RestClientSalaryDto.SalaryDetailsDto;
import com.mitrahsoft.company_management.entity.Employee;
import com.mitrahsoft.company_management.mapper.EmployeeMapper;
import com.mitrahsoft.company_management.openFeign.SalaryService;
import com.mitrahsoft.company_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class OpenFeignSalaryService{
    private final EmployeeRepository employeeRepository;
    private final SalaryService salaryService;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public OpenFeignSalaryService(EmployeeRepository employeeRepository, SalaryService salaryService, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.salaryService = salaryService;
        this.employeeMapper = employeeMapper;
    }

    public RestClientEmployeeResDto getEmployeeWithFeignSalary(Long employeeId){
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new NoSuchElementException("Employee Id not found!"));
        SalaryDetailsDto salaryDetails = salaryService.getEmployeeSalary(employeeId);
        RestClientEmployeeResDto employeeResponse = employeeMapper.toRestClientEmployeeResDto(employee);
        employeeResponse.setSalaryDetails(salaryDetails);
        return employeeResponse;
    }
}
