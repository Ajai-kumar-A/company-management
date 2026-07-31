package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.BranchDto.BranchReplaceReqDto;
import com.mitrahsoft.company_management.dto.BranchDto.BranchRequestDto;
import com.mitrahsoft.company_management.dto.BranchDto.BranchResponseDto;
import com.mitrahsoft.company_management.dto.BranchDto.BranchUpdateReqDto;
import com.mitrahsoft.company_management.entity.Branch;
import com.mitrahsoft.company_management.entity.Company;
import com.mitrahsoft.company_management.mapper.BranchMapper;
import com.mitrahsoft.company_management.repository.BranchRepository;
import com.mitrahsoft.company_management.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BranchService {
    private final BranchRepository branchRepository;
    private final CompanyRepository companyRepository;
    private final BranchMapper branchMapper;

    @Autowired
    public BranchService(BranchRepository branchRepository, BranchMapper branchMapper, CompanyRepository companyRepository) {
        this.branchRepository = branchRepository;
        this.companyRepository = companyRepository;
        this.branchMapper = branchMapper;
    }

    @CacheEvict(value = "branchList", allEntries = true)
    public BranchResponseDto createBranch(BranchRequestDto branchRequestDto) {
        Company company = companyRepository.findById(branchRequestDto.companyId()).orElseThrow(() -> new NoSuchElementException("Company Id not found!"));
        Branch branch = branchMapper.toEntity(branchRequestDto);
        branch.setCompany(company);
        return branchMapper.toDto(branchRepository.save(branch));
    }

    @Cacheable("branchList")
    public List<BranchResponseDto> fetchBranches() {
        return branchMapper.toDtoList(branchRepository.findAll());
    }

    @CacheEvict(value = "branchList", allEntries = true)
    public void replaceBranch(BranchReplaceReqDto branchReplaceReqDto, Long branchId) {
        Branch existingBranch = branchRepository.findById(branchId).orElseThrow(() -> new NoSuchElementException("Branch Id Not Found!"));
        Company company = companyRepository.findById(branchReplaceReqDto.companyId()).orElseThrow(() -> new NoSuchElementException("Company Id not found!"));
        branchMapper.replaceEntityFromDto(branchReplaceReqDto, existingBranch);
        existingBranch.setCompany(company);
        company.getBranches().add(existingBranch);
        branchRepository.save(existingBranch);
    }

    @CacheEvict(value = "branchList", allEntries = true)
    public void updateBranch(BranchUpdateReqDto branchUpdateReqDto, Long branchId) {
        Branch existingBranch = branchRepository.findById(branchId).orElseThrow(() -> new NoSuchElementException("Branch Id Not Found!"));
        branchMapper.updateEntityFromDto(branchUpdateReqDto, existingBranch);
        existingBranch.getCompany().getBranches().forEach(each -> {
            if (each.getBranchId().equals(existingBranch.getBranchId())) {
                each.setBranchLocation(existingBranch.getBranchLocation());
            }
        });
        branchRepository.save(existingBranch);
    }


    @CacheEvict(value = "branchList", allEntries = true)
    public void deleteBranch(Long branchId) {
        Branch existingBranch = branchRepository.findById(branchId).orElseThrow(() -> new NoSuchElementException("Branch Id Not Found!"));
        existingBranch.getCompany().getBranches().remove(existingBranch);
        branchRepository.deleteById(branchId);
    }
}
