package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.SalaryDto.SalaryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "salary-service",
        url = "http://localhost:8081"
)
public interface SalaryFeignClientService {
    @GetMapping("/salary/get/{employeeId}")
    SalaryDto getSalary(@PathVariable("employeeId") Long employeeId);
}
