package com.mitrahsoft.company_management.controller;

import com.mitrahsoft.company_management.dto.BranchDto.BranchReplaceReqDto;
import com.mitrahsoft.company_management.dto.BranchDto.BranchRequestDto;
import com.mitrahsoft.company_management.dto.BranchDto.BranchResponseDto;
import com.mitrahsoft.company_management.dto.BranchDto.BranchUpdateReqDto;
import com.mitrahsoft.company_management.service.BranchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {
    private final BranchService branchService;

    @Autowired
    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @PostMapping("/create-branch")
    public ResponseEntity<BranchResponseDto> createBranch(@Valid @RequestBody BranchRequestDto branchRequestDto) {
        return new ResponseEntity<>(branchService.createBranch(branchRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/branches")
    public ResponseEntity<List<BranchResponseDto>> fetchBranches() {
        return new ResponseEntity<>(branchService.fetchBranches(), HttpStatus.OK);
    }

    @PutMapping("/replace-branch/{branchId}")
    public ResponseEntity<String> replaceBranch(@Valid @RequestBody BranchReplaceReqDto branchReplaceReqDto, @PathVariable Long branchId) {
        branchService.replaceBranch(branchReplaceReqDto, branchId);
        return new ResponseEntity<>("Branch details replaced successfully", HttpStatus.OK);
    }

    @PatchMapping("/update-branch/{branchId}")
    public ResponseEntity<String> updateBranch(@Valid @RequestBody BranchUpdateReqDto branchUpdateReqDto, @PathVariable Long branchId) {
        branchService.updateBranch(branchUpdateReqDto, branchId);
        return new ResponseEntity<>("Branch details updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete-branch/{branchId}")
    public ResponseEntity<String> deleteBranch(@PathVariable Long branchId) {
        branchService.deleteBranch(branchId);
        return new ResponseEntity<>("Branch deleted successfully", HttpStatus.OK);
    }
}
