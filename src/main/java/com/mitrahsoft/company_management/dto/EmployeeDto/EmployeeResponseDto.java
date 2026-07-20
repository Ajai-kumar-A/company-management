package com.mitrahsoft.company_management.dto.EmployeeDto;
import java.util.List;

import com.mitrahsoft.company_management.dto.HardwareDto.HardwareListResDto;
import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsListResDto;
import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsListResDto;
import com.mitrahsoft.company_management.dto.ProjectDto.EmpProjectListDto;
import com.mitrahsoft.company_management.dto.SkillsMappingDto.SkillsMappingResponseDto;

public record EmployeeResponseDto(
        Long employeeId,
        String employeeName,
        String employeeDesignation,
        Double employeeSalary,
        Long branchId,
        Long stackId,
        PersonalDetailsListResDto personalDetails,
        OfficialDetailsListResDto officialDetails,
        List<SkillsMappingResponseDto> skillMappings,
        List<EmpProjectListDto> employeeProjectList,
        List<HardwareListResDto> hardwaresList
) {
}
