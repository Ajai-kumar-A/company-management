package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsRequestDto;
import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsResponseDto;
import com.mitrahsoft.company_management.entity.PersonalDetails;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonalDetailsMapper {

    PersonalDetails toEntity(PersonalDetailsRequestDto personalDetailsRequestDto);
    PersonalDetailsResponseDto toDto(PersonalDetails personalDetails);
    List<PersonalDetailsResponseDto> toDtoList(List<PersonalDetails> personalDetailsList);

}
