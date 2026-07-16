package com.mitrahsoft.company_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    private String companyId;

    private String companyName;

    private String companyDomain;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Branch> branches;
}
