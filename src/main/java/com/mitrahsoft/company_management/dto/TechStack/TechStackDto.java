package com.mitrahsoft.company_management.dto.TechStack;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TechStackDto {
    @NotBlank(message = "Stack Id is Required")
    private String stackId;
    @NotBlank(message = "Stack Name is Required")
    private String stackName;
    @NotBlank(message = "Stack Category is Required")
    private String stackCategory;
}
