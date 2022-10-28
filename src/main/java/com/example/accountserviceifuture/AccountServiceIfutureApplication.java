package com.example.accountserviceifuture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class AccountServiceIfutureApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceIfutureApplication.class, args);
	}

}
