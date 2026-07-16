package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.CompanyRequestDto;
import com.mitrahsoft.company_management.dto.CompanyUpdateReqDto;
import com.mitrahsoft.company_management.entity.Company;
import com.mitrahsoft.company_management.mapper.CompanyMapper;
import com.mitrahsoft.company_management.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Autowired
    public CompanyService (CompanyRepository companyRepository, CompanyMapper companyMapper){
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }


    public Company createCompany(CompanyRequestDto companyRequestDto){
        Company company = companyMapper.toEntity(companyRequestDto);
        return companyRepository.save(company);
    }


    public List<Company> fetchCompanies(){
        return companyRepository.findAll();
    }


    public Company updateCompany(CompanyUpdateReqDto companyUpdateReqDto, String companyId){
        Optional<Company> companyopt = companyRepository.findById(companyId);
        Company company = companyopt.orElseThrow(() -> new NoSuchElementException("Company Id Not Found!"));

        if(companyUpdateReqDto.companyName() != null && !companyUpdateReqDto.companyName().isEmpty()){
            company.setCompanyName(companyUpdateReqDto.companyName());
        }

        if(companyUpdateReqDto.companyDomain() != null && !companyUpdateReqDto.companyDomain().isEmpty()){
            company.setCompanyDomain(companyUpdateReqDto.companyDomain());
        }

        return companyRepository.save(company);
    }


    public void deleteCompany(String companyId){
        Optional<Company> companyopt = companyRepository.findById(companyId);
        Company company = companyopt.orElseThrow(() -> new NoSuchElementException("Company Id Not Found!"));
        companyRepository.deleteById(companyId);
    }
}
