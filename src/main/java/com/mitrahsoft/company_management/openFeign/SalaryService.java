package com.mitrahsoft.company_management.openFeign;

import com.mitrahsoft.company_management.dto.RestClientSalaryDto.SalaryDetailsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "salaryService", url = "http://localhost:8081", path = "/salary")
public interface SalaryService {
    @GetMapping("/employee/{employeeId}")
    SalaryDetailsDto getEmployeeSalary(@PathVariable Long employeeId);
}
