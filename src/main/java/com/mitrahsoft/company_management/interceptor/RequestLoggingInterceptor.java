package com.mitrahsoft.company_management.interceptor;

import com.mitrahsoft.company_management.dto.kafkaDto.ApiLogDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import java.time.Instant;

@Component
@RequiredArgsConstructor
public class RequestLoggingInterceptor implements HandlerInterceptor {

    private final KafkaTemplate<String, ApiLogDto> kafkaTemplate;

    @Value("${spring.application.name:unknown-service}")
    private String currentServiceName;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // Record the start time into the request context attribute area
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        long startTime = (Long) request.getAttribute("startTime");
        long duration = System.currentTimeMillis() - startTime;

        ApiLogDto logPayload = ApiLogDto.builder()
                .serviceName(currentServiceName)
                .httpMethod(request.getMethod())
                .requestUri(request.getRequestURI())
                .httpStatus(response.getStatus())
                .executionTime(duration + "ms")
                .timestamp(Instant.now())
                .build();

        // Stream natively to your centralized topic asynchronously
        kafkaTemplate.send("api-logs", logPayload);
    }
}
