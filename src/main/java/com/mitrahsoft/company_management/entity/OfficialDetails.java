package com.mitrahsoft.company_management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfficialDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long officialId;
    @Column(unique = true)
    private String officialMail;
    private String experience;
    private LocalDate joiningDate;
    private String phoneNumber;
    @OneToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;
}
