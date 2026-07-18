package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.CompanyDto.CompanyReplaceReqDto;
import com.mitrahsoft.company_management.dto.CompanyDto.CompanyRequestDto;
import com.mitrahsoft.company_management.dto.CompanyDto.CompanyResponseDto;
import com.mitrahsoft.company_management.dto.CompanyDto.CompanyUpdateReqDto;
import com.mitrahsoft.company_management.entity.Company;
import com.mitrahsoft.company_management.entity.EmployeeProject;
import com.mitrahsoft.company_management.mapper.CompanyMapper;
import com.mitrahsoft.company_management.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Autowired
    public CompanyService (CompanyRepository companyRepository, CompanyMapper companyMapper){
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }


    public CompanyResponseDto createCompany(CompanyRequestDto companyRequestDto){
        Company company = companyMapper.toEntity(companyRequestDto);
        return companyMapper.toDto(companyRepository.save(company));
    }

    public List<CompanyResponseDto> fetchCompanies(){
        return companyMapper.toDtoList(companyRepository.findAll());
    }

    public void replaceCompany(CompanyReplaceReqDto companyReplaceReqDto, Long companyId){
        Company existingCompany = companyRepository.findById(companyId).orElseThrow(() -> new NoSuchElementException("Company Id Not Found!"));
        companyMapper.replaceEntityFromDto(companyReplaceReqDto, existingCompany);
        companyRepository.save(existingCompany);
    }

    public void updateCompany(CompanyUpdateReqDto companyUpdateReqDto, Long companyId){
        Company existingCompany = companyRepository.findById(companyId).orElseThrow(() -> new NoSuchElementException("Company Id Not Found!"));
        companyMapper.updateEntityFromDto(companyUpdateReqDto,existingCompany);
        companyRepository.save(existingCompany);
    }


    public void deleteCompany(Long companyId){
        Company existingCompany = companyRepository.findById(companyId).orElseThrow(() -> new NoSuchElementException("Company Id Not Found!"));
        companyRepository.deleteById(companyId);
    }
}
