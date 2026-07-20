package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.TechStackDto.TechStackRequestDto;
import com.mitrahsoft.company_management.dto.TechStackDto.TechStackResponseDto;
import com.mitrahsoft.company_management.entity.TechStack;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface TechStackMapper {
    TechStack toEntity(TechStackRequestDto techStackRequestDto);
    TechStackResponseDto toDto(TechStack techStack);
    List<TechStackResponseDto> toDtoList(List<TechStack> techStackList);
}
