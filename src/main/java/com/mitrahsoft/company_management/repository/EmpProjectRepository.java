package com.mitrahsoft.company_management.repository;

import com.mitrahsoft.company_management.entity.EmployeeProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpProjectRepository extends JpaRepository<EmployeeProject,Long> {
}
