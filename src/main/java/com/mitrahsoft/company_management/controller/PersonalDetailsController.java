package com.mitrahsoft.company_management.controller;

import com.mitrahsoft.company_management.dto.PersonalDetails.PersonalDetailsRequestDto;
import com.mitrahsoft.company_management.entity.PersonalDetails;
import com.mitrahsoft.company_management.service.PersonalDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personal-info")
@RequiredArgsConstructor
public class PersonalDetailsController {
    @Autowired
    private PersonalDetailsService personalDetailsService;

    @PostMapping("/add")
    public ResponseEntity<PersonalDetails> addPersonalDetails(@Valid @RequestBody PersonalDetailsRequestDto personalDetailsRequestDto){
        return new ResponseEntity<>(personalDetailsService.createPersonalDetails(personalDetailsRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<PersonalDetails>> getAllPersonalDetails(){
        return new ResponseEntity<>(personalDetailsService.findAllPersonalDetails(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PersonalDetails> updatePersonalDetails(@PathVariable Long id, @Valid @RequestBody PersonalDetailsRequestDto personalDetailsRequestDto){
        return new ResponseEntity<>(personalDetailsService.updatePersonalDetails(id,personalDetailsRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removePersonalDetails(@PathVariable Long id){
        personalDetailsService.deletePersonalDetails(id);
        return new ResponseEntity<>("Personal Details Deleted Successfully",HttpStatus.OK);
    }
}
