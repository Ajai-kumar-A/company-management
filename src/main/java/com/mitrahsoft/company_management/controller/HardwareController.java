package com.mitrahsoft.company_management.controller;

import com.mitrahsoft.company_management.dto.HardwareDto.HardwareDetailsDto;
import com.mitrahsoft.company_management.service.HardwareService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hardware-info")
@RequiredArgsConstructor
public class HardwareController {
    @Autowired
    private final HardwareService hardwareService;

    @PostMapping("/add")
    public ResponseEntity<HardwareDetailsDto> addHardware(@Valid @RequestBody HardwareDetailsDto hardwareDetailsDto) {
        return new ResponseEntity<>(hardwareService.createHardware(hardwareDetailsDto), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<HardwareDetailsDto>> getAllHardware(){
        return new ResponseEntity<>(hardwareService.findAllHardware(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<HardwareDetailsDto>  updateHardware(@PathVariable String id,@Valid @RequestBody HardwareDetailsDto hardwareDetailsDto){
        return new ResponseEntity<>(hardwareService.updateHardware(id,hardwareDetailsDto), HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeHardware(@PathVariable String id){
        return new ResponseEntity<>(hardwareService.deleteHardware(id), HttpStatus.OK);
    }
}
