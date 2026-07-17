package com.mitrahsoft.company_management.repository;

import com.mitrahsoft.company_management.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch,String> {
}
