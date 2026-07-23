package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.EmployeeDto.*;
import com.mitrahsoft.company_management.dto.EmployeeSearchDto.EmployeeSearchRequest;
import com.mitrahsoft.company_management.dto.EmployeeSearchDto.SortCriteria;
import com.mitrahsoft.company_management.entity.*;
import com.mitrahsoft.company_management.exception.RecordsNotFoundException;
import com.mitrahsoft.company_management.mapper.EmployeeMapper;
import com.mitrahsoft.company_management.repository.BranchRepository;
import com.mitrahsoft.company_management.repository.EmployeeRepository;
import com.mitrahsoft.company_management.repository.TechStackRepository;
import jakarta.persistence.EntityNotFoundException;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final TechStackRepository techStackRepository;
    private final BranchRepository branchRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, TechStackRepository techStackRepository, BranchRepository branchRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.branchRepository = branchRepository;
        this.techStackRepository = techStackRepository;
    }

    @Caching(evict = {@CacheEvict(value = "employeeList", allEntries = true), @CacheEvict(value = "employeeSearchList", allEntries = true)})
    public EmployeeResponseDto createEmployee(@NonNull EmployeeRequestDto employeeRequestDto) {
        Branch branch = branchRepository.findById(employeeRequestDto.branchId()).orElseThrow(() -> new NoSuchElementException("Branch Id not found!"));
        TechStack techStack = techStackRepository.findById(employeeRequestDto.techStackId()).orElseThrow(() -> new EntityNotFoundException("Tech Stack not found"));
        Employee employee = employeeMapper.toEntity(employeeRequestDto);
        employee.setBranch(branch);
        employee.setTechStack(techStack);
        OfficialDetails officialDetails = employee.getOfficialDetails();
        if (officialDetails != null) {
            officialDetails.setEmployee(employee);
        }
        PersonalDetails personalDetails = employee.getPersonalDetails();
        if (personalDetails != null) {
            personalDetails.setEmployee(employee);
        }

        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    @Cacheable("employeeList")
    public List<EmployeeResponseDto> findAllEmployees() {
        return employeeMapper.toDtoList(employeeRepository.findAll());
    }

    @Cacheable(value = "employees", key = "#employeeId")
    public EmployeeResponseDto getEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NoSuchElementException("Employee not found"));
        return employeeMapper.toDto(employee);
    }

    @Cacheable("employeeSearchList")
    public List<EmployeeResponseDto> getEmployees(EmployeeSearchRequest request) {
        Sort sort = Sort.unsorted();
        if (request.getSorting() != null && !request.getSorting().isEmpty()) {
            List<Sort.Order> orders = new ArrayList<>();
            for (SortCriteria sortCriteria : request.getSorting()) {
                String direction = sortCriteria.getDirection();
                String column = sortCriteria.getColumnName();

                Sort.Order order = "DESC".equalsIgnoreCase(direction)
                        ? Sort.Order.desc(column)
                        : Sort.Order.by(column);
                orders.add(order);
            }
            sort = Sort.by(orders);
        }

        int page = 0;
        int size = 10;
        if (request.getPagination() != null) {
            page = request.getPagination().getPage();
            size = request.getPagination().getSize();
        }

        Pageable pageable = PageRequest.of(page, size, sort);

        Specification<Employee> spec = EmployeeSpecification.getSearchSpecification(request);
        Page<Employee> employeePage = employeeRepository.findAll(spec, pageable);
        List<EmployeeResponseDto> employeeList =  employeePage.map(employeeMapper::toDto).getContent();
        if(employeeList.isEmpty())
            throw new RecordsNotFoundException("No employee record found!");
        return employeeList;
    }

    @Caching(
            put = @CachePut(value = "employees", key = "#employeeId"),
            evict = {@CacheEvict(value = "employeeList", allEntries = true),@CacheEvict(value = "employeeSearchList", allEntries = true)}
    )
    public EmployeeResponseDto updateEmployee(EmployeeUpdateReqDto employeeUpdateReqDto, Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new NoSuchElementException("Employee Id Not Found"));
        employeeMapper.updateEntityFromDto(employeeUpdateReqDto, employee);
        if(employeeUpdateReqDto.techStackId() != null){
            TechStack techStack = techStackRepository.findById(employeeUpdateReqDto.techStackId()).orElseThrow(() -> new EntityNotFoundException("Tech Stack not found"));
            employee.setTechStack(techStack);
        }
        if(employeeUpdateReqDto.branchId() != null){
            Branch branch = branchRepository.findById(employeeUpdateReqDto.branchId()).orElseThrow(()->new NoSuchElementException("Branch Id not found!"));
            employee.setBranch(branch);
        }
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    @Caching(
            evict = {
                    @CacheEvict(value = "employees", key = "#employeeId"),
                    @CacheEvict(value = "employeeList", allEntries = true),
                    @CacheEvict(value = "employeeSearchList", allEntries = true)
            }
    )
    public void deleteEmployee(Long employeeId) {
        employeeRepository.findById(employeeId).orElseThrow(() -> new NoSuchElementException("Employee Id Not Found"));
        employeeRepository.deleteById(employeeId);
    }
}
