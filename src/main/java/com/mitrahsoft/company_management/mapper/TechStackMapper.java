package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.TechStack.TechStackDto;
import com.mitrahsoft.company_management.entity.TechStack;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface TechStackMapper {
    TechStack toEntity(TechStackDto techStackDto);
    TechStackDto toDto(TechStack techStack);
    List<TechStackDto> toDtoList(List<TechStack> techStackList);
}
