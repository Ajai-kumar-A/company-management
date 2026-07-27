package com.mitrahsoft.company_management.dto.microService;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mitrahsoft.company_management.dto.HardwareDto.HardwareSummaryDto;
import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsSummaryDto;
import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsSummaryDto;
import com.mitrahsoft.company_management.dto.ProjectDto.EmpProjectListDto;
import com.mitrahsoft.company_management.dto.SkillsMappingDto.SkillsMappingResponseDto;
import lombok.Data;

import java.util.List;
@JsonPropertyOrder({
        "employeeId",
        "employeeName",
        "employeeDesignation",
        "employeeSalary",
        "branchId",
        "stackId",
        "personalDetails",
        "officialDetails",
        "skillMappings",
        "employeeProjectList",
        "hardwaresList",
        "salaryDetails"
})
@Data
public class RestClientEmployeeDto {
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
    private SalaryDetailsDto salaryDetails;
}
