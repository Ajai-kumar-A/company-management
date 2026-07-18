package com.mitrahsoft.company_management.repository;

import com.mitrahsoft.company_management.entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository<Skills,Long> {
}
