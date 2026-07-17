package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.PersonalDetails.PersonalDetailsRequestDto;
import com.mitrahsoft.company_management.entity.PersonalDetails;
import com.mitrahsoft.company_management.mapper.PersonalDetailsMapper;
import com.mitrahsoft.company_management.repository.PersonalDetailsRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonalDetailsService {
    private final PersonalDetailsRepository personalDetailsRepository;
    private final PersonalDetailsMapper personalDetailsMapper;

    public PersonalDetails createPersonalDetails(PersonalDetailsRequestDto personalDetailsRequestDto) {
        PersonalDetails personalDetails = personalDetailsMapper.toEntity(personalDetailsRequestDto);
        if (personalDetails.getPersonalMail().equals(personalDetailsRequestDto.getPersonalMail())){
            throw new EntityExistsException("Personal details already exists");
        }
        return personalDetailsRepository.save(personalDetails);
    }

    public List<PersonalDetails> findAllPersonalDetails() {
        return personalDetailsRepository.findAll();
    }

    public PersonalDetails updatePersonalDetails(Long personalId, PersonalDetailsRequestDto personalDetailsRequestDto) {
        Optional<PersonalDetails> optionalPersonalDetails = personalDetailsRepository.findById(personalId);
        if (optionalPersonalDetails.isEmpty()) {
            throw new EntityNotFoundException("No person found with id: " + personalId);
        }
        PersonalDetails personalDetails = optionalPersonalDetails.get();
        personalDetails.setPersonalMail(personalDetailsRequestDto.getPersonalMail());
        personalDetails.setDob(personalDetailsRequestDto.getDob());
        personalDetails.setBloodGroup(personalDetailsRequestDto.getBloodGroup());
        personalDetails.setNativeAddress(personalDetailsRequestDto.getNativeAddress());
        return personalDetailsRepository.save(personalDetails);
    }

    public void deletePersonalDetails(Long personalId) {
        Optional<PersonalDetails> optionalPersonalDetails = personalDetailsRepository.findById(personalId);
        if (optionalPersonalDetails.isEmpty()) {
            throw new EntityNotFoundException("No person found with id: " + personalId);
        }
        personalDetailsRepository.deleteById(personalId);
    }
}
