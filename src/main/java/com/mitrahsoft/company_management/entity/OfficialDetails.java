package com.mitrahsoft.company_management.entity;

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
    public Long officialId;
    public String officialMail;
    public String experience;
    public LocalDate joiningDate;
    public String phoneNumber;
}
