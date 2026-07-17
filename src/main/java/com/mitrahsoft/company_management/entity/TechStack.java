package com.mitrahsoft.company_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechStack {
    @Id
    @Column(unique = true, nullable = false)
    private String stackId;
    @Column(unique = true)
    private String stackName;
    private String stackCategory;

}
