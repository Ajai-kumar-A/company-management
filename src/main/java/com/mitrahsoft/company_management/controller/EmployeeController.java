package com.mitrahsoft.company_management.controller;

import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeRequestDto;
import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeResponseDto;
import com.mitrahsoft.company_management.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/create-employee")
    public ResponseEntity<EmployeeResponseDto> createEmployee(@Valid @RequestBody EmployeeRequestDto employeeRequestDto) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/getall-employee")
    public ResponseEntity<List<EmployeeResponseDto>> findAllEmployees() {
        return new ResponseEntity<>(employeeService.findAllEmployees(), HttpStatus.OK);
    }
    @GetMapping("/getby-id{employeeId}")
    public ResponseEntity<EmployeeResponseDto> getEmployee(@Valid @PathVariable Long employeeId) {
        return new ResponseEntity<>(employeeService.getEmployee(employeeId), HttpStatus.OK);
    }

    @PutMapping("update-employee/{employeeId}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(@Valid @RequestBody EmployeeRequestDto employeeRequestDto, @PathVariable Long employeeId) {
        return new ResponseEntity<>(employeeService.updateEmployee(employeeRequestDto, employeeId), HttpStatus.OK);
    }

    @DeleteMapping("/delete-employee/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("Employee Deleted successfully", HttpStatus.OK);
    }
}
