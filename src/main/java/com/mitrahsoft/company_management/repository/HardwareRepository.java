package com.mitrahsoft.company_management.repository;

import com.mitrahsoft.company_management.entity.Hardware;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HardwareRepository extends JpaRepository<Hardware, Long> {
    boolean existsBySerialId(String id);
}
