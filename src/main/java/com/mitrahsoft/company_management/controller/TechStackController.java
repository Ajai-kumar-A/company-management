package com.mitrahsoft.company_management.controller;

import com.mitrahsoft.company_management.dto.TechStackDto.TechStackDetailsDto;
import com.mitrahsoft.company_management.dto.TechStackDto.TechStackRequestDto;
import com.mitrahsoft.company_management.dto.TechStackDto.TechStackResponseDto;
import com.mitrahsoft.company_management.service.TechStackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stack-info")
@RequiredArgsConstructor
public class TechStackController {

    private final TechStackService techStackService;

    @PostMapping("/add")
    public ResponseEntity<TechStackResponseDto> createStack(@Valid @RequestBody TechStackRequestDto techStackRequestDto) {
        return new ResponseEntity<>(techStackService.createTechStack(techStackRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TechStackResponseDto>> getAllTechStack() {
        return new ResponseEntity<>(techStackService.findAllTechStack(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TechStackDetailsDto> getTechStack(@PathVariable Long id) {
        return new ResponseEntity<>(techStackService.getTechStack(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TechStackResponseDto> updateStack(@PathVariable Long id, @Valid @RequestBody TechStackRequestDto techStackRequestDto) {
        return new ResponseEntity<>(techStackService.updateTechStack(id, techStackRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeStack(@PathVariable Long id) {
        return new ResponseEntity<>(techStackService.deleteTechStack(id), HttpStatus.OK);
    }
}
