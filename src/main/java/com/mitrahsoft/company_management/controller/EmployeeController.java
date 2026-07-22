package com.mitrahsoft.company_management.controller;

import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeRequestDto;
import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeResponseDto;
import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeUpdateReqDto;
import com.mitrahsoft.company_management.dto.EmployeeDto.FilterRequestDto;
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

    @PostMapping("/add")
    public ResponseEntity<EmployeeResponseDto> createEmployee(@Valid @RequestBody EmployeeRequestDto employeeRequestDto) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeRequestDto), HttpStatus.CREATED);
    }

    @PostMapping("/search")
    public List<EmployeeResponseDto> search(@RequestBody FilterRequestDto request) {
        return employeeService.searchEmployee(request);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeResponseDto>> findAllEmployees() {
        return new ResponseEntity<>(employeeService.findAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/get/{employeeId}")
    public ResponseEntity<EmployeeResponseDto> getEmployee(@PathVariable Long employeeId) {
        return new ResponseEntity<>(employeeService.getEmployee(employeeId), HttpStatus.OK);
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
