package com.mitrahsoft.company_management.service;


import com.mitrahsoft.company_management.dto.SkillsMappingDto.SkillsMappingRequestDto;
import com.mitrahsoft.company_management.dto.SkillsMappingDto.SkillsMappingResponseDto;
import com.mitrahsoft.company_management.dto.SkillsMappingDto.SkillsMappingUpdateDto;
import com.mitrahsoft.company_management.entity.SkillMapping;
import com.mitrahsoft.company_management.mapper.SkillsMappingMapper;
import com.mitrahsoft.company_management.repository.SkillsMappingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class SkillsMappingService {
    private final SkillsMappingRepository skillsMappingRepository;
    private final SkillsMappingMapper skillsMappingMapper;

    public SkillsMappingService(SkillsMappingRepository skillsMappingRepository, SkillsMappingMapper skillsMappingMapper) {
        this.skillsMappingRepository = skillsMappingRepository;
        this.skillsMappingMapper = skillsMappingMapper;
    }


    public SkillsMappingResponseDto createSkillsMapping(SkillsMappingRequestDto skillsMappingRequestDto) {
        SkillMapping skillMapping = skillsMappingMapper.toEntity(skillsMappingRequestDto);
        return skillsMappingMapper.toDto(skillsMappingRepository.save(skillMapping));
    }

    public List<SkillsMappingResponseDto> findAllSkillsMapping() {
        return skillsMappingMapper.toDtoList(skillsMappingRepository.findAll());
    }

    public SkillsMappingResponseDto updateSkillsMapping(SkillsMappingUpdateDto skillsMappingUpdateDto, String skillMappingId) {
        SkillMapping skillMapping = skillsMappingRepository.findById(skillMappingId).orElseThrow(() -> new NoSuchElementException("Skill Mapping Id Not Found"));
        skillsMappingMapper.updateEntityFromDto(skillsMappingUpdateDto,skillMapping);
        SkillMapping updatedSkill = skillsMappingRepository.save(skillMapping);
        return skillsMappingMapper.toDto(updatedSkill);
    }

    public void deleteSkillsMapping(String skillMappingId) {
        SkillMapping skillMapping = skillsMappingRepository.findById(skillMappingId).orElseThrow(() -> new NoSuchElementException("Skill Mapping Id Not Found"));
        skillsMappingRepository.deleteById(skillMappingId);
    }
}
