package com.mitrahsoft.company_management.controller;

import com.mitrahsoft.company_management.dto.SkillsDto.SkillRevResDto;
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

    @PostMapping("/add")
    public ResponseEntity<SkillsResponseDto> createSkills(@Valid @RequestBody SkillsRequestDto skillsRequestDto) {
        return new ResponseEntity<>(skillsService.createSkills(skillsRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<SkillsResponseDto>> findAllSkills() {
        return new ResponseEntity<>(skillsService.findAllSkills(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<SkillRevResDto> getSkill(@PathVariable Long id) {
        return new ResponseEntity<>(skillsService.getSkill(id), HttpStatus.OK);
    }

    @PutMapping("update/{skillId}")
    public ResponseEntity<SkillsResponseDto> updateSkills(@Valid @RequestBody SkillsRequestDto skillsRequestDto, @PathVariable Long skillId) {
        return new ResponseEntity<>(skillsService.updateSkills(skillsRequestDto, skillId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{skillId}")
    public ResponseEntity<String> deleteSkills(@PathVariable Long skillId) {
        skillsService.deleteSkills(skillId);
        return new ResponseEntity<>("skill deleted successfully", HttpStatus.OK);
    }
}
