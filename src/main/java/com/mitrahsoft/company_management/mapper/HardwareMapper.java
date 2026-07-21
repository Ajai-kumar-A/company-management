package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.HardwareDto.HardwareListResDto;
import com.mitrahsoft.company_management.dto.HardwareDto.HardwareRequestDto;
import com.mitrahsoft.company_management.dto.HardwareDto.HardwareResponseDto;
import com.mitrahsoft.company_management.entity.Hardware;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = EmployeeMapper.class
)
public interface HardwareMapper {

    Hardware toEntity(HardwareRequestDto hardwareDto);

    HardwareResponseDto toDto(Hardware hardware);

    List<HardwareListResDto> toDtoList(List<Hardware> hardwareList);
}
