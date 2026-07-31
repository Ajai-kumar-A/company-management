package com.mitrahsoft.company_management.dto.kafkaDto;

import lombok.*;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiLogDto {
    private String serviceName;
    private String httpMethod;
    private String requestUri;
    private int httpStatus;
    private String executionTime;
    private Instant timestamp;
}
