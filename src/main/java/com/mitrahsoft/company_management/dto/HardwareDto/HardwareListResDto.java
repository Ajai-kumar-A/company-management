package com.mitrahsoft.company_management.dto.HardwareDto;

import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeRevResDto;

public record HardwareListResDto(
        Long hardwareId,
        String serialId,
        String deviceName,
        String brand,
        String model,
        EmployeeRevResDto employee
) {
}
