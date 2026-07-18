package com.mitrahsoft.company_management.dto.EmployeeDto;
import java.util.List;
import com.mitrahsoft.company_management.dto.SkillsMappingDto.SkillsMappingResponseDto;
import com.mitrahsoft.company_management.entity.OfficialDetails;

public record EmployeeResponseDto(
        String employeeName,
        String employeeDesignation,
        Double employeeSalary,
        OfficialDetails officialDetails,
        List<SkillsMappingResponseDto> skillMappings
) {
}
