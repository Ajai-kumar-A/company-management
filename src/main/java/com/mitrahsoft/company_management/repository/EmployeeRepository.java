package com.mitrahsoft.company_management.repository;

import com.mitrahsoft.company_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
//    @EntityGraph(attributePaths = {
//            "skillMappings",
//            "skillMappings.skills",
//            "officialDetails",
//            "techStack",
//            "personalDetails",
//            "hardwaresList"
//
//    })
//    Optional<Employee> findByEmployeeId(Long employeeId);
}
