package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsListResDto;
import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsResponseDto;
import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsRequestDto;
import com.mitrahsoft.company_management.entity.Employee;
import com.mitrahsoft.company_management.entity.OfficialDetails;
import com.mitrahsoft.company_management.exception.OfficialDetailsAlreadyExistException;
import com.mitrahsoft.company_management.mapper.OfficialDetailsMapper;
import com.mitrahsoft.company_management.repository.EmployeeRepository;
import com.mitrahsoft.company_management.repository.OfficeDetailsRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OfficialDetailsService {
  private final OfficeDetailsRepository officeDetailsRepository;
  private final OfficialDetailsMapper officialDetailsMapper;
  private final EmployeeRepository employeeRepository;

    public OfficialDetailsService(OfficeDetailsRepository officeDetailsRepository, OfficialDetailsMapper officialDetailsMapper, EmployeeRepository employeeRepository) {
        this.officeDetailsRepository = officeDetailsRepository;
        this.officialDetailsMapper = officialDetailsMapper;
        this.employeeRepository = employeeRepository;
    }

    @CacheEvict(value = "officialDetails", allEntries = true)
     public OfficialDetailsResponseDto createOfficialDetails(OfficialDetailsRequestDto officialDetailsRequestDto) {
         if(officeDetailsRepository.existsByOfficialMail(officialDetailsRequestDto.officialMail())){
             throw new OfficialDetailsAlreadyExistException("official details already present");
         }
         Employee employee=employeeRepository.findById(officialDetailsRequestDto.employeeId()).orElseThrow(()->new NoSuchElementException("Employee id not found"));
         OfficialDetails officialDetails =officialDetailsMapper.toEntity(officialDetailsRequestDto);
         officialDetails.setEmployee(employee);
         return officialDetailsMapper.toDto(officeDetailsRepository.save(officialDetails));
     }

     @Cacheable("officialDetails")
    public List<OfficialDetailsListResDto> fetchOfficialDetails(){
        return officialDetailsMapper.toDtoList(officeDetailsRepository.findAll());
    }

    @Caching(evict = {
            @CacheEvict(value = "employees", key = "#OfficialDetailsRequestDto.employeeId"),
            @CacheEvict(value = "employeeList", allEntries = true)
    })
    public OfficialDetailsResponseDto updateOfficialDetails(OfficialDetailsRequestDto officialDetailsRequestDto, Long officialId){
        OfficialDetails officialDetails = officeDetailsRepository.findById(officialId).orElseThrow(() -> new NoSuchElementException("Official details Not Found!"));
        officialDetailsMapper.updateEntityFromDto(officialDetailsRequestDto,officialDetails);
        OfficialDetails updated=officeDetailsRepository.save(officialDetails);
        return officialDetailsMapper.toDto(updated);
    }

    @Caching(evict = {@CacheEvict(value = "employeeList", allEntries = true),
            @CacheEvict(value = "employees", key = "#result")})
    public Long deleteOfficialDetails(Long officialId){
        OfficialDetails officialDetails = officeDetailsRepository.findById(officialId).orElseThrow(() -> new NoSuchElementException("Official details Not Found!"));;
        officeDetailsRepository.deleteById(officialId);
        return officialDetails.getEmployee().getEmployeeId();
    }
}
