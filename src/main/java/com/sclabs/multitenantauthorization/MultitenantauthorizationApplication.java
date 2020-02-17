package com.sclabs.multitenantauthorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class MultitenantauthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultitenantauthorizationApplication.class, args);
	}

}
