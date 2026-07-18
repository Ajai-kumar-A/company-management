package com.mitrahsoft.company_management.controller;

import com.mitrahsoft.company_management.dto.SkillsDto.SkillsRequestDto;
import com.mitrahsoft.company_management.dto.SkillsDto.SkillsResponseDto;
import com.mitrahsoft.company_management.service.SkillsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillsController {
    public final SkillsService skillsService;

    @Autowired
    public SkillsController(SkillsService skillsService) {
        this.skillsService = skillsService;
    }

    @PostMapping("/create-skills")
    public ResponseEntity<SkillsResponseDto> createSkills(@Valid @RequestBody SkillsRequestDto skillsRequestDto) {
        return new ResponseEntity<>(skillsService.createSkills(skillsRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/getall-skills")
    public ResponseEntity<List<SkillsResponseDto>> findAllSkills() {
        return new ResponseEntity<>(skillsService.findAllSkills(), HttpStatus.OK);
    }

    @PutMapping("update-skills/{skillId}")
    public ResponseEntity<SkillsResponseDto> updateSkills(@Valid @RequestBody SkillsRequestDto skillsRequestDto, @PathVariable Long skillId) {
        return new ResponseEntity<>(skillsService.updateSkills(skillsRequestDto, skillId), HttpStatus.OK);
    }

    @DeleteMapping("/delete-skills/{skillId}")
    public ResponseEntity<String> deleteSkills(@PathVariable Long skillId) {
        skillsService.deleteSkills(skillId);
        return new ResponseEntity<>("skill deleted successfully", HttpStatus.OK);
    }
}
