package com.mitrahsoft.company_management.controller;

import com.mitrahsoft.company_management.dto.RestClientSalaryDto.RestClientEmployeeResDto;
import com.mitrahsoft.company_management.service.OpenFeignSalaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class OpenFeignSalaryController {
    private final OpenFeignSalaryService openFeignSalaryService;

    public OpenFeignSalaryController(OpenFeignSalaryService openFeignSalaryService) {
        this.openFeignSalaryService = openFeignSalaryService;
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<RestClientEmployeeResDto> getEmployeeWithFeignSalary(@PathVariable Long employeeId){
        return new ResponseEntity<>(openFeignSalaryService.getEmployeeWithFeignSalary(employeeId), HttpStatus.OK);
    }

}
