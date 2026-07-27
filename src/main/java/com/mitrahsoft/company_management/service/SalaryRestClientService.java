package com.mitrahsoft.company_management.service;

import com.mitrahsoft.company_management.dto.SalaryDto.SalaryDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class SalaryRestClientService {
    private final RestClient restClient;

    public SalaryRestClientService(RestClient restClient) {
        this.restClient = restClient;
    }

    public SalaryDto getSalary(Long employeeId) {
        return restClient.get()
                .uri("http://localhost:8081/salary/get/{employeeId}", employeeId)
                .retrieve()
                .body(SalaryDto.class);
    }
}
