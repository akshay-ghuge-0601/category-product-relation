package com.online_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.online_shop"})
public class FinalProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(FinalProject1Application.class, args);
	}

}
