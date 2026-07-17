package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.CompanyDto.CompanyReplaceReqDto;
import com.mitrahsoft.company_management.dto.CompanyDto.CompanyRequestDto;
import com.mitrahsoft.company_management.dto.CompanyDto.CompanyResponseDto;
import com.mitrahsoft.company_management.dto.CompanyDto.CompanyUpdateReqDto;
import com.mitrahsoft.company_management.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel= "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CompanyMapper {
    Company toEntity(CompanyRequestDto companyRequestDto);
    CompanyResponseDto toDto(Company company);
    void replaceEntityFromDto(CompanyReplaceReqDto companyReplaceReqDto, @MappingTarget Company company);
    void updateEntityFromDto(CompanyUpdateReqDto companyUpdateReqDto, @MappingTarget Company company);
    List<CompanyResponseDto> toDtoList(List<Company> companyList);
}
