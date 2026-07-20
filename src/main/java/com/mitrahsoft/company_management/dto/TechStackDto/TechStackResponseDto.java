package com.mitrahsoft.company_management.dto.TechStackDto;

import lombok.Data;

@Data
public class TechStackResponseDto {
    private Long id;
    private String stackId;
    private String stackName;
    private String stackCategory;
}
