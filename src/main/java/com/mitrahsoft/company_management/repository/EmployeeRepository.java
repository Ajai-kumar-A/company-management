package com.mitrahsoft.company_management.repository;

import com.mitrahsoft.company_management.entity.Employee;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @EntityGraph(attributePaths = {
            "skillMappings",
            "skillMappings.skills",
            "officialDetails",
            "techStack",
            "officialDetails",
            "personalDetails",
            "hardwaresList"

    })
    Optional<Employee> findByEmployeeId(Long employeeId);
}
