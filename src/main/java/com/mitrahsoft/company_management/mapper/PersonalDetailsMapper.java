package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.PersonalDetails.PersonalDetailsRequestDto;
import com.mitrahsoft.company_management.entity.PersonalDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonalDetailsMapper {
    PersonalDetails toEntity(PersonalDetailsRequestDto personalDetailsRequestDto);
}
