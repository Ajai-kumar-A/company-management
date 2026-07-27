package com.mitrahsoft.company_management.dto.RestClientSalaryDto;

import com.mitrahsoft.company_management.dto.HardwareDto.HardwareSummaryDto;
import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsSummaryDto;
import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsSummaryDto;
import com.mitrahsoft.company_management.dto.ProjectDto.EmpProjectListDto;
import com.mitrahsoft.company_management.dto.SkillsMappingDto.SkillsMappingResponseDto;
import lombok.Data;

import java.util.List;

@Data
public class RestClientEmployeeResDto {
    Long employeeId;
    String employeeName;
    String employeeDesignation;
    Double employeeSalary;
    Long branchId;
    Long stackId;
    SalaryDetailsDto salaryDetails;
    PersonalDetailsSummaryDto personalDetails;
    OfficialDetailsSummaryDto officialDetails;
    List<SkillsMappingResponseDto> skillMappings;
    List<EmpProjectListDto> employeeProjectList;
    List<HardwareSummaryDto> hardwaresList;
}
