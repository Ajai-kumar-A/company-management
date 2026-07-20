package com.mitrahsoft.company_management.dto.HardwareDto;

public record HardwareListResDto(
        Long hardwareId,
        String serialId,
        String deviceName,
        String brand,
        String model
) {
}
