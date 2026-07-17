package com.mitrahsoft.company_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "branch")
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class Branch {

    @Id
    private String branchId;

    private String branchLocation;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
