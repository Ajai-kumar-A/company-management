package com.mitrahsoft.company_management.repository;

import com.mitrahsoft.company_management.entity.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long> {
}
