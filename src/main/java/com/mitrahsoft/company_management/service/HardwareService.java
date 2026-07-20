package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.HardwareDto.HardwareRequestDto;
import com.mitrahsoft.company_management.dto.HardwareDto.HardwareResponseDto;
import com.mitrahsoft.company_management.entity.Employee;
import com.mitrahsoft.company_management.entity.Hardware;
import com.mitrahsoft.company_management.mapper.HardwareMapper;
import com.mitrahsoft.company_management.repository.EmployeeRepository;
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
    private final EmployeeRepository employeeRepository;

    public HardwareResponseDto createHardware(HardwareRequestDto hardwareRequestDto) {
        Employee employee = employeeRepository.findById(hardwareRequestDto.getEmployeeId()).orElseThrow(() -> new RuntimeException("Employee not found"));
        Hardware hardware = hardwareMapper.toEntity(hardwareRequestDto);
        if (hardwareRepository.existsBySerialId(hardwareRequestDto.getSerialId())) {
            throw new EntityExistsException("Hardware already exists");
        }
        hardware.setEmployee(employee);
        employee.getHardwaresList().add(hardware);
        return hardwareMapper.toDto(hardwareRepository.save(hardware));
    }
    public List<HardwareResponseDto> findAllHardware() {
        return hardwareMapper.toDto(hardwareRepository.findAll());
    }

    public HardwareResponseDto updateHardware(Long id, HardwareRequestDto hardwareRequestDto) {
        Optional<Hardware> hardwareOptional = hardwareRepository.findById(id);
        if (hardwareOptional.isEmpty()) {
            throw new NoSuchElementException("No Hardware found with id " + id);
        }
        Hardware hardware =  hardwareOptional.get();
        hardware.setSerialId(hardwareRequestDto.getSerialId());
        hardware.setDeviceName(hardwareRequestDto.getDeviceName());
        hardware.setModel(hardwareRequestDto.getModel());
        hardware.setBrand(hardwareRequestDto.getBrand());
        return  hardwareMapper.toDto(hardwareRepository.save(hardware));
    }

    public String  deleteHardware(Long id) {
        Optional<Hardware> hardwareOptional = hardwareRepository.findById(id);
        if (hardwareOptional.isEmpty()) {
            throw new NoSuchElementException("No Hardware found with id " + id);
        }
        hardwareRepository.deleteById(id);
        return "Hardware Details has been Deleted!";
    }
}
