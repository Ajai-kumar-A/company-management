package com.mitrahsoft.company_management.controller;

import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsListResDto;
import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsRequestDto;
import com.mitrahsoft.company_management.dto.PersonalDetailsDto.PersonalDetailsResponseDto;
import com.mitrahsoft.company_management.service.PersonalDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personal-info")
@RequiredArgsConstructor
public class PersonalDetailsController {

    private final PersonalDetailsService personalDetailsService;

    @PostMapping("/add")
    public ResponseEntity<PersonalDetailsResponseDto> addPersonalDetails(@Valid @RequestBody PersonalDetailsRequestDto personalDetailsRequestDto){
        return new ResponseEntity<>(personalDetailsService.createPersonalDetails(personalDetailsRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PersonalDetailsListResDto>> getAllPersonalDetails(){
        return new ResponseEntity<>(personalDetailsService.findAllPersonalDetails(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PersonalDetailsResponseDto> updatePersonalDetails(@PathVariable Long id, @Valid @RequestBody PersonalDetailsRequestDto personalDetailsRequestDto){
        return new ResponseEntity<>(personalDetailsService.updatePersonalDetails(id,personalDetailsRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removePersonalDetails(@PathVariable Long id){
        personalDetailsService.deletePersonalDetails(id);
        return new ResponseEntity<>("Personal Details Deleted Successfully",HttpStatus.OK);
    }
}
