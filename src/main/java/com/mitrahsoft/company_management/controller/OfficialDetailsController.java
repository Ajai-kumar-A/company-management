package com.mitrahsoft.company_management.controller;


import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsListResDto;
import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsRequestDto;
import com.mitrahsoft.company_management.dto.OfficeDetailsDto.OfficialDetailsResponseDto;
import com.mitrahsoft.company_management.service.OfficialDetailsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/official-details")
public class OfficialDetailsController {

    public final OfficialDetailsService officialDetailsService;
    @Autowired
    public OfficialDetailsController(OfficialDetailsService officialDetailsService) {
        this.officialDetailsService = officialDetailsService;
    }

    @PostMapping("/create-official-details")
    public ResponseEntity<OfficialDetailsResponseDto> createOfficialDetails(@Valid @RequestBody OfficialDetailsRequestDto officialDetailsRequestDto){
        return new ResponseEntity<>(officialDetailsService.createOfficialDetails(officialDetailsRequestDto), HttpStatus.CREATED);
    }
    @GetMapping("/all-details")
    public ResponseEntity<List<OfficialDetailsListResDto>> fetchOfficialDetails(){
        return new ResponseEntity<>(officialDetailsService.fetchOfficialDetails(),HttpStatus.OK);
    }
    @PutMapping("/update-offical-details/{officialId}")
    public ResponseEntity<OfficialDetailsResponseDto> updateOfficialDetails(@Valid @RequestBody OfficialDetailsRequestDto officialDetailsRequestDto, @PathVariable Long officialId){
        return new ResponseEntity<>(officialDetailsService.updateOfficialDetails(officialDetailsRequestDto, officialId),HttpStatus.OK);
    }
    @DeleteMapping("/delete-official-details/{officialId}")
    public ResponseEntity<String> deleteOfficialDetails(@PathVariable Long officialId){
        officialDetailsService.deleteOfficialDetails(officialId);
        return new ResponseEntity<>("official detail deleted successfully",HttpStatus.OK);
    }

}
