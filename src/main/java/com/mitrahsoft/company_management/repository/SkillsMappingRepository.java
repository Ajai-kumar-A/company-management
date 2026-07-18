package com.mitrahsoft.company_management.repository;

import com.mitrahsoft.company_management.entity.SkillMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsMappingRepository extends JpaRepository<SkillMapping,Long> {
}
