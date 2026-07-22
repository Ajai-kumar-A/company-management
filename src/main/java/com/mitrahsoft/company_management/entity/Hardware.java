package com.mitrahsoft.company_management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hardware {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hardwareId;
    @Column(unique = true, nullable = false)
    private String serialId;
    @Column(nullable = false)
    private String deviceName;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String model;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;
}




