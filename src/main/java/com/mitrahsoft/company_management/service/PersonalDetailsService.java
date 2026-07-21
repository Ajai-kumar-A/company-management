package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsListResDto;
import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsRequestDto;
import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsResponseDto;
import com.mitrahsoft.company_management.entity.Employee;
import com.mitrahsoft.company_management.entity.PersonalDetails;
import com.mitrahsoft.company_management.mapper.PersonalDetailsMapper;
import com.mitrahsoft.company_management.repository.EmployeeRepository;
import com.mitrahsoft.company_management.repository.PersonalDetailsRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonalDetailsService {
    private final PersonalDetailsRepository personalDetailsRepository;
    private final PersonalDetailsMapper personalDetailsMapper;
    private final EmployeeRepository employeeRepository;

    public PersonalDetailsResponseDto createPersonalDetails(PersonalDetailsRequestDto personalDetailsRequestDto) {
        PersonalDetails personalDetails = personalDetailsMapper.toEntity(personalDetailsRequestDto);
        Employee employee = employeeRepository.findById(personalDetailsRequestDto.getEmployeeId()).orElseThrow(() -> new NoSuchElementException("Employee id not found"));
        if (personalDetailsRepository.existsByPersonalMail(personalDetailsRequestDto.getPersonalMail())) {
            throw new EntityExistsException("Personal details already exists");
        }
        personalDetails.setEmployee(employee);
        return personalDetailsMapper.toDto(personalDetailsRepository.save(personalDetails));
    }

    public List<PersonalDetailsListResDto> findAllPersonalDetails() {
        return personalDetailsMapper.toDtoList(personalDetailsRepository.findAll());
    }

    public PersonalDetailsResponseDto updatePersonalDetails(Long personalId, PersonalDetailsRequestDto personalDetailsRequestDto) {
        Optional<PersonalDetails> optionalPersonalDetails = personalDetailsRepository.findById(personalId);
        if (optionalPersonalDetails.isEmpty()) {
            throw new EntityNotFoundException("No person found with id: " + personalId);
        }
        PersonalDetails personalDetails = optionalPersonalDetails.get();
        personalDetails.setPersonalMail(personalDetailsRequestDto.getPersonalMail());
        personalDetails.setDob(personalDetailsRequestDto.getDob());
        personalDetails.setBloodGroup(personalDetailsRequestDto.getBloodGroup());
        personalDetails.setNativeAddress(personalDetailsRequestDto.getNativeAddress());
        return personalDetailsMapper.toDto(personalDetailsRepository.save(personalDetails));
    }

    public void deletePersonalDetails(Long personalId) {
        Optional<PersonalDetails> optionalPersonalDetails = personalDetailsRepository.findById(personalId);
        if (optionalPersonalDetails.isEmpty()) {
            throw new EntityNotFoundException("No person found with id: " + personalId);
        }
        personalDetailsRepository.deleteById(personalId);
    }
}
