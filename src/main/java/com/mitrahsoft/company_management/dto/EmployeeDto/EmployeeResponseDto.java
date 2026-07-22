package com.mitrahsoft.company_management.dto.EmployeeDto;
import java.util.List;

import com.mitrahsoft.company_management.dto.HardwareDto.HardwareSummaryDto;
import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsSummaryDto;
import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsSummaryDto;
import com.mitrahsoft.company_management.dto.ProjectDto.EmpProjectListDto;
import com.mitrahsoft.company_management.dto.SkillsMappingDto.SkillsMappingResponseDto;

public record EmployeeResponseDto(
        Long employeeId,
        String employeeName,
        String employeeDesignation,
        Double employeeSalary,
        Long branchId,
        Long stackId,
        PersonalDetailsSummaryDto personalDetails,
        OfficialDetailsSummaryDto officialDetails,
        List<SkillsMappingResponseDto> skillMappings,
        List<EmpProjectListDto> employeeProjectList,
        List<HardwareSummaryDto> hardwaresList
) {
}
