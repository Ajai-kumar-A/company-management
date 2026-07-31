package com.mitrahsoft.company_management.dto.SkillsDto;

import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeRevResDto;
import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class SkillRevResDto {
    Long skillId;
    String skillName;
    String skillCategory;
    List<EmployeeRevResDto> employees;
}
