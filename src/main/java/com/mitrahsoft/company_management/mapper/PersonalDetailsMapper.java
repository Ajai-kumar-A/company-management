package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsListResDto;
import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsRequestDto;
import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsResponseDto;
import com.mitrahsoft.company_management.entity.PersonalDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonalDetailsMapper {

    PersonalDetails toEntity(PersonalDetailsRequestDto personalDetailsRequestDto);
    @Mapping(target = "employee")
    PersonalDetailsResponseDto toDto(PersonalDetails personalDetails);
    List<PersonalDetailsListResDto> toDtoList(List<PersonalDetails> personalDetailsList);

}
