package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.SkillsDto.SkillsRequestDto;
import com.mitrahsoft.company_management.dto.SkillsDto.SkillsResponseDto;
import com.mitrahsoft.company_management.entity.Skills;
import com.mitrahsoft.company_management.mapper.SkillsMapper;
import com.mitrahsoft.company_management.repository.SkillsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SkillsService {
    private final SkillsRepository skillsRepository;
    private final SkillsMapper skillsMapper;

    public SkillsService(SkillsRepository skillsRepository, SkillsMapper skillsMapper) {
        this.skillsRepository = skillsRepository;
        this.skillsMapper = skillsMapper;
    }

    public SkillsResponseDto createSkills(SkillsRequestDto skillsRequestDto) {
        Skills skills = skillsMapper.toEntity(skillsRequestDto);
        return skillsMapper.toDto(skillsRepository.save(skills));
    }

    public List<SkillsResponseDto> findAllSkills() {
        return skillsMapper.toDtoList(skillsRepository.findAll());
    }

    public SkillsResponseDto updateSkills(SkillsRequestDto skillsRequestDto, Long skillId) {
        Skills skills = skillsRepository.findById(skillId).orElseThrow(() -> new NoSuchElementException("Skill Id Not Found"));
        skillsMapper.updateEntityFromDto(skillsRequestDto, skills);
        Skills updatedSkill = skillsRepository.save(skills);
        return skillsMapper.toDto(updatedSkill);
    }

    public void deleteSkills(Long skillId) {
        Skills skills = skillsRepository.findById(skillId).orElseThrow(() -> new NoSuchElementException("Skill Id Not Found"));
        skillsRepository.deleteById(skillId);
    }
}
