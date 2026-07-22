package com.mitrahsoft.company_management.dto.HardwareDto;

import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeRevResDto;
import lombok.Data;

@Data
public class HardwareResponseDto {
    private Long hardwareId;
    private String serialId;
    private String deviceName;
    private String brand;
    private String model;
    private EmployeeRevResDto employee;
}
