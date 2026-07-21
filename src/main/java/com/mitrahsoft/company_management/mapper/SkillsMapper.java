package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.EmployeeDto.EmployeeRevResDto;
import com.mitrahsoft.company_management.dto.SkillsDto.SkillRevResDto;
import com.mitrahsoft.company_management.dto.SkillsDto.SkillsRequestDto;
import com.mitrahsoft.company_management.dto.SkillsDto.SkillsResponseDto;
import com.mitrahsoft.company_management.entity.SkillMapping;
import com.mitrahsoft.company_management.entity.Skills;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = EmployeeMapper.class)
public abstract class SkillsMapper {
    public abstract Skills toEntity(SkillsRequestDto skillsRequestDto);

    public abstract SkillsResponseDto toDto(Skills skills);

    public abstract void updateEntityFromDto(SkillsRequestDto skillsRequestDto , @MappingTarget Skills skills);

    public abstract List<SkillsResponseDto> toDtoList(List<Skills> skillsList);

    @Autowired
    protected EmployeeMapper employeeMapper;

    @Mapping(target = "employees", source = "skillMappings")
    public abstract SkillRevResDto toDetailsDto(Skills skills);

    protected List<EmployeeRevResDto> map(List<SkillMapping> skillMappings) {
        return skillMappings.stream()
                .map(sm -> employeeMapper.toRevResDto(sm.getEmployee()))
                .toList();
    }
}
