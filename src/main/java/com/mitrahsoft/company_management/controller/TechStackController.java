package com.mitrahsoft.company_management.controller;

import com.mitrahsoft.company_management.dto.TechStack.TechStackDto;
import com.mitrahsoft.company_management.service.TechStackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stack-info")
@RequiredArgsConstructor
public class TechStackController {
    @Autowired
    private final TechStackService techStackService;

    @PostMapping("/add")
    public ResponseEntity<TechStackDto> createStack(@Valid @RequestBody TechStackDto techStackDto){
        return new ResponseEntity<>(techStackService.createTechStack(techStackDto), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TechStackDto>> getAllTechStack(){
        return new ResponseEntity<>(techStackService.findAllTechStack(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TechStackDto> updateStack( @PathVariable String id, @Valid @RequestBody TechStackDto techStackDto){
        return new ResponseEntity<>(techStackService.updateTechStack(id, techStackDto), HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeStack(@PathVariable String id){
        return new ResponseEntity<>(techStackService.deleteTechStack(id), HttpStatus.OK);
    }
}
