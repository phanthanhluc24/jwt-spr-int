package com.example.final_academy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.example.final_academy"})
@SpringBootApplication
public class FinalAcademyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalAcademyApplication.class, args);
	}

}
