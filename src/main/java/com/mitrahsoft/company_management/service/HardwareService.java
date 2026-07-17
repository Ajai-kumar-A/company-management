package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.HardwareDto.HardwareDetailsDto;
import com.mitrahsoft.company_management.entity.Hardware;
import com.mitrahsoft.company_management.mapper.HardwareMapper;
import com.mitrahsoft.company_management.repository.HardwareRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HardwareService {

    private final HardwareRepository hardwareRepository;
    private  final HardwareMapper hardwareMapper;

    public HardwareDetailsDto createHardware(HardwareDetailsDto hardwareDetailsDto) {
        Hardware hardware = hardwareMapper.toEntity(hardwareDetailsDto);
        if (hardware.getSerialId().equals(hardwareDetailsDto.getSerialId())) {
            throw new EntityExistsException("Hardware already exists");
        }
        return hardwareMapper.toDto(hardwareRepository.save(hardware));
    }

    public List<HardwareDetailsDto> findAllHardware() {
        return hardwareMapper.toDto(hardwareRepository.findAll());
    }

    public HardwareDetailsDto updateHardware(String serialId, HardwareDetailsDto hardwareDetailsDto) {
        Optional<Hardware> hardwareOptional = hardwareRepository.findById(serialId);
        if (hardwareOptional.isEmpty()) {
            throw new NoSuchElementException("No Hardware found with serial id " + serialId);
        }
        Hardware hardware =  hardwareOptional.get();
        hardware.setSerialId(hardwareDetailsDto.getSerialId());
        hardware.setDeviceName(hardwareDetailsDto.getDeviceName());
        hardware.setModel(hardwareDetailsDto.getModel());
        hardware.setBrand(hardwareDetailsDto.getBrand());
        return  hardwareMapper.toDto(hardwareRepository.save(hardware));
    }

    public String  deleteHardware(String serialId) {
        Optional<Hardware> hardwareOptional = hardwareRepository.findById(serialId);
        if (hardwareOptional.isEmpty()) {
            throw new NoSuchElementException("No Hardware found with serial id " + serialId);
        }
        hardwareRepository.deleteById(serialId);
        return "Hardware Details has been Deleted!";
    }
}
