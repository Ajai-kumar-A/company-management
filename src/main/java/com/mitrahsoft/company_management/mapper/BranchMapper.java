package com.mitrahsoft.company_management.mapper;

import com.mitrahsoft.company_management.dto.BranchDto.BranchReplaceReqDto;
import com.mitrahsoft.company_management.dto.BranchDto.BranchRequestDto;
import com.mitrahsoft.company_management.dto.BranchDto.BranchResponseDto;
import com.mitrahsoft.company_management.dto.BranchDto.BranchUpdateReqDto;
import com.mitrahsoft.company_management.entity.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", uses = EmployeeMapper.class, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BranchMapper {
    Branch toEntity(BranchRequestDto branchRequestDto);

    @Mapping(target = "companyId", source = "company.companyId")
    BranchResponseDto toDto(Branch branch);

    void replaceEntityFromDto(BranchReplaceReqDto branchReplaceReqDto, @MappingTarget Branch branch);

    void updateEntityFromDto(BranchUpdateReqDto branchUpdateReqDto, @MappingTarget Branch branch);

    List<BranchResponseDto> toDtoList(List<Branch> branchList);
}
