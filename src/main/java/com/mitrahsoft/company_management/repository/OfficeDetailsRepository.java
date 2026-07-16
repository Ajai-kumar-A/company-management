package com.mitrahsoft.company_management.repository;

import com.mitrahsoft.company_management.entity.OfficialDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeDetailsRepository extends JpaRepository<OfficialDetails,Long> {
    boolean existsByOfficialMail(String officialMail);
}
