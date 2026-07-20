package com.mitrahsoft.company_management.dto.EmployeeDto;
import java.util.List;

import com.mitrahsoft.company_management.dto.HardwareDto.HardwareResponseDto;
import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsResponseDto;

import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsResponseDto;
import com.mitrahsoft.company_management.dto.ProjectDto.EmpProjectListDto;
import com.mitrahsoft.company_management.dto.SkillsMappingDto.SkillsMappingResponseDto;

public record EmployeeResponseDto(
        Long employeeId,
        String employeeName,
        String employeeDesignation,
        Double employeeSalary,
        Long branchId,
        Long stackId,
        PersonalDetailsResponseDto personalDetails,
        OfficialDetailsResponseDto officialDetails,
        List<SkillsMappingResponseDto> skillMappings,
        List<EmpProjectListDto> employeeProjectList,
        List<HardwareResponseDto> hardwaresList
) {
}
