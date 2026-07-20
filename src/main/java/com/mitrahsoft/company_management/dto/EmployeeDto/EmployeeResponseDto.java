package com.mitrahsoft.company_management.dto.EmployeeDto;
import java.util.List;

import com.mitrahsoft.company_management.dto.HardwareDto.HardwareResponseDto;
import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsResponseDto;
import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsResponseDto;
import com.mitrahsoft.company_management.dto.ProjectDto.EmpProjectListDto;
import com.mitrahsoft.company_management.dto.SkillsMappingDto.SkillsMappingResponseDto;
import com.mitrahsoft.company_management.dto.TechStackDto.TechStackResponseDto;
import com.mitrahsoft.company_management.entity.OfficialDetails;

public record EmployeeResponseDto(
        String employeeName,
        String employeeDesignation,
        Double employeeSalary,
        Long branchId,
        TechStackResponseDto techStack,
        OfficialDetailsResponseDto officialDetails,
        PersonalDetailsResponseDto personalDetails,
        List<SkillsMappingResponseDto> skillMappings,
        List<EmpProjectListDto> employeeProjectList,
        List<HardwareResponseDto> hardwaresList
) {
}
