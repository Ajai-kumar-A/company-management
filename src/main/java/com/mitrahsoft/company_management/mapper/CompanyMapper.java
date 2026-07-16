package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.CompanyRequestDto;
import com.mitrahsoft.company_management.entity.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel= "spring")
public interface CompanyMapper {
    Company toEntity(CompanyRequestDto companyRequestDto);
}
