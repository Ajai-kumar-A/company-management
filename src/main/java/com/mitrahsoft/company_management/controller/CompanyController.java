package com.mitrahsoft.company_management.controller;

import com.mitrahsoft.company_management.dto.CompanyReplaceReqDto;
import com.mitrahsoft.company_management.dto.CompanyRequestDto;
import com.mitrahsoft.company_management.dto.CompanyResponseDto;
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
    public ResponseEntity<CompanyResponseDto> createCompany(@Valid @RequestBody CompanyRequestDto companyRequestDto){
        return new ResponseEntity<>(companyService.createCompany(companyRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/companies")
    public ResponseEntity<List<CompanyResponseDto>> fetchCompanies(){
        return new ResponseEntity<>(companyService.fetchCompanies(),HttpStatus.OK);
    }

    @PutMapping("/admin/replace-company/{companyId}")
    public ResponseEntity<String> replaceCompany(@Valid @RequestBody CompanyReplaceReqDto companyReplaceReqDto, @PathVariable String companyId){
        companyService.replaceCompany(companyReplaceReqDto, companyId);
        return new ResponseEntity<>("Company details replaced successfully",HttpStatus.OK);
    }

    @PatchMapping("/admin/update-company/{companyId}")
    public ResponseEntity<String> updateCompany(@Valid @RequestBody CompanyUpdateReqDto companyUpdateReqDto, @PathVariable String companyId){
        companyService.updateCompany(companyUpdateReqDto, companyId);
        return new ResponseEntity<>("Company details updated successfully",HttpStatus.OK);
    }

    @DeleteMapping("/admin/delete-company/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable String companyId){
        companyService.deleteCompany(companyId);
        return new ResponseEntity<>("Company deleted successfully",HttpStatus.OK);
    }
}
