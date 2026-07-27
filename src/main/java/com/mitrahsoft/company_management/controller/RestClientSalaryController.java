package com.mitrahsoft.company_management.controller;

import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeResponseDto;
import com.mitrahsoft.company_management.dto.microService.RestClientEmployeeDto;
import com.mitrahsoft.company_management.service.RestClientSalaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class RestClientSalaryController {
    private final RestClientSalaryService salaryService;

    public RestClientSalaryController(RestClientSalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping("/rest-client/get/{employeeId}")
    public ResponseEntity<RestClientEmployeeDto> getEmployeeRest(@PathVariable Long employeeId) {
        return new ResponseEntity<>(salaryService.getEmployeeRest(employeeId), HttpStatus.OK);
    }
    @GetMapping("/open-feign/get/{employeeId}")
    public ResponseEntity<RestClientEmployeeDto> getEmployeeOpenFeign(@PathVariable Long employeeId) {
        return new ResponseEntity<>(salaryService.getEmployeeOpenFeign(employeeId), HttpStatus.OK);
    }
}
