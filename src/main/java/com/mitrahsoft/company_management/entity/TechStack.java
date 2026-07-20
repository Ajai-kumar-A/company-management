package com.mitrahsoft.company_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechStack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String stackId;
    @Column(unique = true)
    private String stackName;
    private String stackCategory;

    @OneToMany(mappedBy = "techStack", fetch = FetchType.LAZY)
    private List<Employee> employees = new ArrayList<>();

}
