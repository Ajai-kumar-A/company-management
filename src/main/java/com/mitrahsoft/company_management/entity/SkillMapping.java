package com.mitrahsoft.company_management.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillMappingId;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skills skills;
    private String proficiencyLevel;
    private Double skillExperienceYears;
}
