package com.mitrahsoft.company_management.dto.HardwareDto;

import lombok.Data;

@Data
public class HardwareResponseDto {
    private Long id;
    private String serialId;
    private String deviceName;
    private String brand;
    private String model;
}
