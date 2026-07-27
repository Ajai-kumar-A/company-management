package com.mitrahsoft.company_management.controller;

import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeResponseDto;
import com.mitrahsoft.company_management.dto.RestClientSalaryDto.RestClientEmployeeResDto;
import com.mitrahsoft.company_management.service.EmployeeService;
import com.mitrahsoft.company_management.service.RestClientSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestClientSalaryController {
    public final RestClientSalaryService restClientSalaryService;

    @Autowired
    public RestClientSalaryController(RestClientSalaryService restClientSalaryService) {
        this.restClientSalaryService = restClientSalaryService;
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<RestClientEmployeeResDto> getEmployeeWithRestClientSalary(@PathVariable Long employeeId) {
        return new ResponseEntity<>(restClientSalaryService.getEmployeeWithRestClientSalary(employeeId), HttpStatus.OK);
    }
}
