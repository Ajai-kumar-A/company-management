package com.mitrahsoft.company_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SkillMapping {
    @Id
    @Column(unique = true)
    private String skillMappingId;
    private String proficiencyLevel;
    private Double skillExperienceYears;
}
