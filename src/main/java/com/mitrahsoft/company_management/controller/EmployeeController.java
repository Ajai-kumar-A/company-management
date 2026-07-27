package com.mitrahsoft.company_management.controller;

import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeRequestDto;
import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeResponseDto;
import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeUpdateReqDto;
import com.mitrahsoft.company_management.dto.EmployeeSearchDto.EmployeeSearchRequest;
import com.mitrahsoft.company_management.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    public final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeResponseDto> createEmployee(@Valid @RequestBody EmployeeRequestDto employeeRequestDto) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeRequestDto), HttpStatus.CREATED);
    }

    @PostMapping("/search")
    public List<EmployeeResponseDto> getEmployees(@RequestBody EmployeeSearchRequest request) {
        return employeeService.getEmployees(request);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<EmployeeResponseDto>> findAllEmployees() {
        return new ResponseEntity<>(employeeService.findAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/get/{employeeId}")
    public ResponseEntity<EmployeeResponseDto> getEmployee( @PathVariable Long employeeId) {
        return new ResponseEntity<>(employeeService.getEmployee(employeeId), HttpStatus.OK);
    }

    @GetMapping("/get/rest/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeByRestClient(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getEmployeeByRestClient(id), HttpStatus.OK);
    }

    @GetMapping("/get/feign/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeByFeignClient(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getEmployeeByFeignClient(id), HttpStatus.OK);
    }

    @PutMapping("update/{employeeId}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(@Valid @RequestBody EmployeeUpdateReqDto employeeUpdateReqDto, @PathVariable Long employeeId) {
        return new ResponseEntity<>(employeeService.updateEmployee(employeeUpdateReqDto, employeeId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("Employee Deleted successfully", HttpStatus.OK);
    }
}
