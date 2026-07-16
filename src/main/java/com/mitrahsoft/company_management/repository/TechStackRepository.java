package com.mitrahsoft.company_management.repository;

import com.mitrahsoft.company_management.entity.TechStack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechStackRepository extends JpaRepository<TechStack, String> {
}
