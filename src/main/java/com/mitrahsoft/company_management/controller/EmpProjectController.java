package com.mitrahsoft.company_management.controller;

import com.mitrahsoft.company_management.dto.EmpProjectDto.EmpProjectReplaceReqDto;
import com.mitrahsoft.company_management.dto.EmpProjectDto.EmpProjectReqDto;
import com.mitrahsoft.company_management.dto.EmpProjectDto.EmpProjectResDto;
import com.mitrahsoft.company_management.dto.EmpProjectDto.EmpProjectUpdateReq;
import com.mitrahsoft.company_management.service.EmpProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EmpProject")
public class EmpProjectController {
    private final EmpProjectService empProjectService;

    @Autowired
    public EmpProjectController(EmpProjectService empProjectService) {
        this.empProjectService = empProjectService;
    }

    @PostMapping("/add")
    public ResponseEntity<EmpProjectResDto> createEmpProject(@Valid @RequestBody EmpProjectReqDto empProjectReqDto){
        return new ResponseEntity<>(empProjectService.createEmpProject(empProjectReqDto), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EmpProjectResDto>> fetchEmpProject(){
        return new ResponseEntity<>(empProjectService.fetchEmpProject(),HttpStatus.OK);
    }

    @PutMapping("/replace/{employeeProjectId}")
    public ResponseEntity<String> replaceEmpProject(@Valid @RequestBody EmpProjectReplaceReqDto empProjectReplaceReqDto, @PathVariable Long employeeProjectId){
        empProjectService.replaceEmpProject(empProjectReplaceReqDto, employeeProjectId);
        return new ResponseEntity<>("Employee Project details replaced successfully",HttpStatus.OK);
    }

    @PatchMapping("/update/{employeeProjectId}")
    public ResponseEntity<String> updateEmpProject(@Valid @RequestBody EmpProjectUpdateReq empProjectUpdateReq, @PathVariable Long employeeProjectId){
        empProjectService.updateEmpProject(empProjectUpdateReq, employeeProjectId);
        return new ResponseEntity<>("Employee Project details updated successfully",HttpStatus.OK);
    }

    @DeleteMapping("/delete/{employeeProjectId}")
    public ResponseEntity<String> deleteEmpProject(@PathVariable Long employeeProjectId){
        empProjectService.deleteEmpProject(employeeProjectId);
        return new ResponseEntity<>("Employee Project deleted successfully",HttpStatus.OK);
    }
}
