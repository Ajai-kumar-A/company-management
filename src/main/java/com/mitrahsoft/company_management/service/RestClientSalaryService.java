package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.microService.RestClientEmployeeDto;
import com.mitrahsoft.company_management.dto.microService.SalaryDetailsDto;
import com.mitrahsoft.company_management.entity.*;
import com.mitrahsoft.company_management.exception.SalaryDetailsNotFound;
import com.mitrahsoft.company_management.mapper.EmployeeMapper;
import com.mitrahsoft.company_management.repository.EmployeeRepository;
import feign.FeignException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;


import java.net.ConnectException;
import java.util.NoSuchElementException;

@Service
public class RestClientSalaryService {

    private final EmployeeMapper employeeMapper;
    private final RestClient restClient;
    private final EmployeeRepository employeeRepository;
    private final EmployeeClient employeeClient;

    public RestClientSalaryService(EmployeeMapper employeeMapper, RestClient restClient, EmployeeRepository employeeRepository, EmployeeClient employeeClient) {
        this.employeeMapper = employeeMapper;
        this.restClient = restClient;
        this.employeeRepository = employeeRepository;
        this.employeeClient = employeeClient;
    }

    @Cacheable(value = "RestEmployees", key = "#employeeId")
    public RestClientEmployeeDto getEmployeeRest(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NoSuchElementException("Employee not found"));
        RestClientEmployeeDto response = employeeMapper.toRestDto(employee);
        try{
            SalaryDetailsDto salary = restClient.get()
                    .uri("http://localhost:8082/Salary-details/get/{id}", employeeId)
                    .retrieve()
                    .body(SalaryDetailsDto.class);
            response.setSalaryDetails(salary);
        }
        catch (HttpClientErrorException ex){
            throw new SalaryDetailsNotFound("Salary details not found for this id");
        }
        return response;
    }
    @Cacheable(value = "RestEmployees", key = "#employeeId")
    public RestClientEmployeeDto getEmployeeOpenFeign(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NoSuchElementException("Employee not found"));
        RestClientEmployeeDto response = employeeMapper.toRestDto(employee);
        try{
            SalaryDetailsDto salaryDetailsDto=employeeClient.findById(employeeId);
            response.setSalaryDetails(salaryDetailsDto);
        } catch (FeignException.FeignClientException e) {
            throw new SalaryDetailsNotFound("Salary details not found for this id");
        }
        return response;
    }

}
