package com.mitrahsoft.company_management.dto.HardwareDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HardwareRequestDto {
    @NotBlank(message = "Serial ID Required")
    private String serialId;
    @NotBlank(message = "Device Name Required")
    private String deviceName;
    @NotBlank(message = "Brand is Required")
    private String brand;
    @NotBlank(message = "Model is Required")
    private String model;
}
