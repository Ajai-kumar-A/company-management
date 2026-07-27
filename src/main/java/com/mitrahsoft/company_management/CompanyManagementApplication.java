package com.mitrahsoft.company_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableCaching
@EnableFeignClients
public class CompanyManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyManagementApplication.class, args);
	}

}
