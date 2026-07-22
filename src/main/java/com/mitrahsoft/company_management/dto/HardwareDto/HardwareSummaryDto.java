package com.mitrahsoft.company_management.dto.HardwareDto;

public record HardwareSummaryDto(
        Long hardwareId,
        String serialId,
        String deviceName,
        String brand,
        String model
)
{}
