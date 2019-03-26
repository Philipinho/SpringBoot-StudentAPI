package com.litesoftwares.studentapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.litesoftwares.studentapi.repository")
@EntityScan("com.litesoftwares.studentapi.model")
@SpringBootApplication
public class StudentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApiApplication.class, args);
	}

}