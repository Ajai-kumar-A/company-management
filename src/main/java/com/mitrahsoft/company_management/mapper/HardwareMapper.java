package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.HardwareDto.HardwareRequestDto;
import com.mitrahsoft.company_management.dto.HardwareDto.HardwareResponseDto;
import com.mitrahsoft.company_management.entity.Hardware;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface HardwareMapper {

    Hardware toEntity(HardwareRequestDto HardwareDto);
    HardwareResponseDto toDto(Hardware hardware);
    List<HardwareResponseDto> toDto(List<Hardware> hardwareList);

}
