package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.TechStack.TechStackDto;
import com.mitrahsoft.company_management.entity.TechStack;
import com.mitrahsoft.company_management.mapper.TechStackMapper;
import com.mitrahsoft.company_management.repository.TechStackRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TechStackService {
    private final TechStackRepository techStackRepository;
    private final TechStackMapper techStackMapper;

    public TechStackDto createTechStack(TechStackDto techStackDto) {
        TechStack techStack =  techStackMapper.toEntity(techStackDto);
        return  techStackMapper.toDto(techStackRepository.save(techStack));
    }

    public List<TechStackDto> findAllTechStack() {
        return techStackMapper.toDtoList(techStackRepository.findAll());
    }

    public TechStackDto updateTechStack(String id, TechStackDto techStackDto) {
        Optional<TechStack> techStackOptional = techStackRepository.findById(id);
        if (techStackOptional.isEmpty()) {
            throw new EntityNotFoundException("Tech Stack Not Found!");
        }
        TechStack techStack = techStackOptional.get();
        techStack.setStackName(techStackDto.getStackName());
        techStack.setStackCategory(techStackDto.getStackCategory());
        return  techStackMapper.toDto(techStackRepository.save(techStack));
    }

    public String deleteTechStack(String id) {
        Optional<TechStack> techStackOptional = techStackRepository.findById(id);
        if (techStackOptional.isEmpty()) {
            throw new EntityNotFoundException("Tech Stack Not Found!");
        }
        techStackRepository.deleteById(id);
        return "Tech Stack Deleted!";
    }
}
