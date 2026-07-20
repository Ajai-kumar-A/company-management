package com.mitrahsoft.company_management.controller;

import com.mitrahsoft.company_management.dto.HardwareDto.HardwareRequestDto;
import com.mitrahsoft.company_management.dto.HardwareDto.HardwareResponseDto;
import com.mitrahsoft.company_management.service.HardwareService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hardware-info")
@RequiredArgsConstructor
public class HardwareController {

    private final HardwareService hardwareService;

    @PostMapping("/add")
    public ResponseEntity<HardwareResponseDto> addHardware(@Valid @RequestBody HardwareRequestDto hardwareRequestDto) {
        return new ResponseEntity<>(hardwareService.createHardware(hardwareRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<HardwareResponseDto>> getAllHardware(){
        return new ResponseEntity<>(hardwareService.findAllHardware(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<HardwareResponseDto>  updateHardware(@PathVariable Long id, @Valid @RequestBody HardwareRequestDto hardwareRequestDto){
        return new ResponseEntity<>(hardwareService.updateHardware(id, hardwareRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeHardware(@PathVariable Long id){
        return new ResponseEntity<>(hardwareService.deleteHardware(id), HttpStatus.OK);
    }
}
