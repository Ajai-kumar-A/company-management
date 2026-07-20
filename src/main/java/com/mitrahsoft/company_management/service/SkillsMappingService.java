package com.mitrahsoft.company_management.service;


import com.mitrahsoft.company_management.dto.SkillsMappingDto.SkillsMappingRequestDto;
import com.mitrahsoft.company_management.dto.SkillsMappingDto.SkillsMappingResponseDto;
import com.mitrahsoft.company_management.dto.SkillsMappingDto.SkillsMappingUpdateDto;
import com.mitrahsoft.company_management.entity.Employee;
import com.mitrahsoft.company_management.entity.SkillMapping;
import com.mitrahsoft.company_management.entity.Skills;
import com.mitrahsoft.company_management.mapper.SkillsMappingMapper;
import com.mitrahsoft.company_management.repository.EmployeeRepository;
import com.mitrahsoft.company_management.repository.SkillsMappingRepository;
import com.mitrahsoft.company_management.repository.SkillsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SkillsMappingService {
    private final SkillsMappingRepository skillsMappingRepository;
    private final SkillsMappingMapper skillsMappingMapper;
    private final EmployeeRepository employeeRepository;
    private final SkillsRepository skillsRepository;

    public SkillsMappingService(SkillsMappingRepository skillsMappingRepository, SkillsMappingMapper skillsMappingMapper, EmployeeRepository employeeRepository, SkillsRepository skillsRepository) {
        this.skillsMappingRepository = skillsMappingRepository;
        this.skillsMappingMapper = skillsMappingMapper;
        this.employeeRepository = employeeRepository;
        this.skillsRepository = skillsRepository;
    }

    public SkillsMappingResponseDto createSkillsMapping(SkillsMappingRequestDto skillsMappingRequestDto) {
        Employee employee = employeeRepository.findById(skillsMappingRequestDto.employeeId()).orElseThrow(() -> new NoSuchElementException("Employee not found"));
        Skills skills = skillsRepository.findById(skillsMappingRequestDto.skillId()).orElseThrow(() -> new NoSuchElementException("skills id not found"));
        SkillMapping skillMapping = skillsMappingMapper.toEntity(skillsMappingRequestDto);
        return skillsMappingMapper.toDto(skillsMappingRepository.save(skillMapping));
    }

    public List<SkillsMappingResponseDto> findAllSkillsMapping() {
        return skillsMappingMapper.toDtoList(skillsMappingRepository.findAll());
    }

    public SkillsMappingResponseDto updateSkillsMapping(SkillsMappingUpdateDto skillsMappingUpdateDto, Long skillMappingId) {
        SkillMapping skillMapping = skillsMappingRepository.findById(skillMappingId).orElseThrow(() -> new NoSuchElementException("Skill Mapping Id Not Found"));
        skillsMappingMapper.updateEntityFromDto(skillsMappingUpdateDto, skillMapping);
        SkillMapping updatedSkill = skillsMappingRepository.save(skillMapping);
        return skillsMappingMapper.toDto(updatedSkill);
    }

    public void deleteSkillsMapping(Long skillMappingId) {
        SkillMapping skillMapping = skillsMappingRepository.findById(skillMappingId).orElseThrow(() -> new NoSuchElementException("Skill Mapping Id Not Found"));
        skillsMappingRepository.deleteById(skillMappingId);
    }
}
