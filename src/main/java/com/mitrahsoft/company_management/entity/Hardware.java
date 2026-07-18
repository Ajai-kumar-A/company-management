package com.mitrahsoft.company_management.entity;

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
    private String serialId;
    @Column(nullable = false)
    private String deviceName;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String model;

}

