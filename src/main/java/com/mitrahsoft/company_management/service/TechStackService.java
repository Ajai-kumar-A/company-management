package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.TechStackDto.TechStackDetailsDto;
import com.mitrahsoft.company_management.dto.TechStackDto.TechStackRequestDto;
import com.mitrahsoft.company_management.dto.TechStackDto.TechStackResponseDto;
import com.mitrahsoft.company_management.entity.TechStack;
import com.mitrahsoft.company_management.mapper.TechStackMapper;
import com.mitrahsoft.company_management.repository.TechStackRepository;
import jakarta.persistence.EntityExistsException;
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

    public TechStackResponseDto createTechStack(TechStackRequestDto techStackRequestDto) {
        TechStack techStack = techStackMapper.toEntity(techStackRequestDto);
        if (techStackRepository.existsByStackId(techStackRequestDto.getStackId())) {
            throw new EntityExistsException("Stack already exists");
        }
        return techStackMapper.toDto(techStackRepository.save(techStack));
    }

    public List<TechStackResponseDto> findAllTechStack() {
        return techStackMapper.toDtoList(techStackRepository.findAll());
    }

    public TechStackDetailsDto getTechStack(Long id) {
        TechStack techStack = techStackRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Tech Stack Not Found!"));
        return techStackMapper.toDetailsDto(techStack);
    }

    public TechStackResponseDto updateTechStack(Long id, TechStackRequestDto techStackRequestDto) {
        Optional<TechStack> techStackOptional = techStackRepository.findById(id);
        if (techStackOptional.isEmpty()) {
            throw new EntityNotFoundException("Tech Stack Not Found!");
        }
        if (techStackRepository.existsByStackId(techStackRequestDto.getStackId()) || techStackRepository.existsByStackName(techStackRequestDto.getStackName())) {
            throw new EntityExistsException("Stack already exists");
        }
        TechStack techStack = techStackOptional.get();
        techStack.setStackId(techStackRequestDto.getStackId());
        techStack.setStackName(techStackRequestDto.getStackName());
        techStack.setStackCategory(techStackRequestDto.getStackCategory());
        return techStackMapper.toDto(techStackRepository.save(techStack));
    }

    public String deleteTechStack(Long id) {
        Optional<TechStack> techStackOptional = techStackRepository.findById(id);
        if (techStackOptional.isEmpty()) {
            throw new EntityNotFoundException("Tech Stack Not Found!");
        }
        techStackRepository.deleteById(id);
        return "Tech Stack Deleted!";
    }
}
