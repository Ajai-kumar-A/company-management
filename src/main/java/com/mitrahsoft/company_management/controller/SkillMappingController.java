package com.mitrahsoft.company_management.controller;

import com.mitrahsoft.company_management.dto.SkillsMappingDto.SkillsMappingRequestDto;
import com.mitrahsoft.company_management.dto.SkillsMappingDto.SkillsMappingResponseDto;
import com.mitrahsoft.company_management.dto.SkillsMappingDto.SkillsMappingUpdateDto;
import com.mitrahsoft.company_management.service.SkillsMappingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill-mapping")
public class SkillMappingController {
    public SkillMappingController(SkillsMappingService skillsMappingService) {
        this.skillsMappingService = skillsMappingService;
    }

    @Autowired
    public final SkillsMappingService skillsMappingService;

    @PostMapping("/create-skill-mapping")
    public ResponseEntity<SkillsMappingResponseDto> createSkillsMapping(@Valid @RequestBody SkillsMappingRequestDto skillsMappingRequestDto) {
        return new ResponseEntity<>(skillsMappingService.createSkillsMapping(skillsMappingRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/getall-skill-mapping")
    public ResponseEntity <List<SkillsMappingResponseDto>> findAllSkillsMapping() {
        return new ResponseEntity<>(skillsMappingService.findAllSkillsMapping(), HttpStatus.OK);
    }

    @PutMapping("update-skill-mapping/{skillMappingId}")
    public ResponseEntity<SkillsMappingResponseDto> updateSkills(@Valid @RequestBody SkillsMappingUpdateDto skillsMappingUpdateDto, @PathVariable String skillMappingId) {
        return new ResponseEntity<>(skillsMappingService.updateSkillsMapping(skillsMappingUpdateDto, skillMappingId), HttpStatus.OK);
    }

    @DeleteMapping("/delete-skill-mapping/{skillMappingId}")
    public ResponseEntity<String> deleteSkillsMapping(@PathVariable String skillMappingId) {
        skillsMappingService.deleteSkillsMapping(skillMappingId);
        return new ResponseEntity<>("skill mapping deleted successfully", HttpStatus.OK);
    }
}





























































































































