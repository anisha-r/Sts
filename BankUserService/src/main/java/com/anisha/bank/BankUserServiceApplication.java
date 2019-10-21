package com.anisha.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class BankUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankUserServiceApplication.class, args);
	}

}
