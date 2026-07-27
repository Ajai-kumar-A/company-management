package com.mitrahsoft.company_management.dto.EmployeeDto;

import com.mitrahsoft.company_management.dto.HardwareDto.HardwareSummaryDto;
import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsSummaryDto;
import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsSummaryDto;
import com.mitrahsoft.company_management.dto.ProjectDto.EmpProjectListDto;
import com.mitrahsoft.company_management.dto.SalaryDto.SalaryDto;
import com.mitrahsoft.company_management.dto.SkillsMappingDto.SkillsMappingResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDto {

    private Long employeeId;
    private String employeeName;
    private String employeeDesignation;
    private Double employeeSalary;
    private Long branchId;
    private Long stackId;

    private PersonalDetailsSummaryDto personalDetails;
    private OfficialDetailsSummaryDto officialDetails;

    private List<SkillsMappingResponseDto> skillMappings;
    private List<EmpProjectListDto> employeeProjectList;
    private List<HardwareSummaryDto> hardwaresList;

    private SalaryDto salary;
}
