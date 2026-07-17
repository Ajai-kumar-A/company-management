package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.HardwareDto.HardwareDetailsDto;
import com.mitrahsoft.company_management.entity.Hardware;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface HardwareMapper {
    Hardware toEntity(HardwareDetailsDto HardwareDto);

    HardwareDetailsDto toDto(Hardware hardware);

    List<HardwareDetailsDto> toDto(List<Hardware> hardwareList);
}
