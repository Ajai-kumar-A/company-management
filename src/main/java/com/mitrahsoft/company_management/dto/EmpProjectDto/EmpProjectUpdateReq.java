package com.mitrahsoft.company_management.dto.EmpProjectDto;

import jakarta.validation.constraints.Null;

public record EmpProjectUpdateReq(
        String role,
        String status,
        @Null(message = "Can't change mapped project")
        Long projectId
){
}
