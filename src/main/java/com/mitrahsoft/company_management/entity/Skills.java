package com.mitrahsoft.company_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;
    @Column(unique = true)
    private String skillName;
    private String skillCategory;
    @OneToMany(mappedBy = "skills", fetch = FetchType.LAZY)
    private List<SkillMapping> skillMappings = new ArrayList<>();
}
