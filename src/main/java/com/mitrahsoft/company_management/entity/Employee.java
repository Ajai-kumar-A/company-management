package com.mitrahsoft.company_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeName;
    private String employeeDesignation;
    private Double employeeSalary;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<SkillMapping> skillMappings = new ArrayList<>();
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private OfficialDetails officialDetails;
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private PersonalDetails personalDetails;
    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Hardware> hardwaresList = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stack_id")
    private TechStack techStack;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<EmployeeProject> employeeProjectList = new ArrayList<>();
}
