package com.mitrahsoft.company_management.controller;

import com.mitrahsoft.company_management.dto.CompanyRequestDto;
import com.mitrahsoft.company_management.dto.CompanyUpdateReqDto;
import com.mitrahsoft.company_management.entity.Company;
import com.mitrahsoft.company_management.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/admin/create-company")
    public ResponseEntity<Company> createCompany(@Valid @RequestBody CompanyRequestDto companyRequestDto){
        return new ResponseEntity<>(companyService.createCompany(companyRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/companies")
    public ResponseEntity<List<Company>> fetchCompanies(){
        return new ResponseEntity<>(companyService.fetchCompanies(),HttpStatus.OK);
    }

    @PutMapping("/admin/update-company/{companyId}")
    public ResponseEntity<Company> updateCompany(@Valid @RequestBody CompanyUpdateReqDto companyUpdateReqDto, @PathVariable String companyId){
        return new ResponseEntity<>(companyService.updateCompany(companyUpdateReqDto, companyId),HttpStatus.OK);
    }

    @DeleteMapping("/admin/delete-company/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable String companyId){
        companyService.deleteCompany(companyId);
        return new ResponseEntity<>("Company deleted successfully",HttpStatus.OK);
    }
}
