package com.mitrahsoft.company_management.repository;

import com.mitrahsoft.company_management.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,String> {
}
