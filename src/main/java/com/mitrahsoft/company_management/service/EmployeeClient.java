package com.mitrahsoft.company_management.service;


import com.mitrahsoft.company_management.dto.microService.SalaryDetailsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "salary-details",url = "http://localhost:8082")
public interface EmployeeClient {
    @GetMapping("/Salary-details/get/{id}")
    SalaryDetailsDto findById(@PathVariable Long id);
}
