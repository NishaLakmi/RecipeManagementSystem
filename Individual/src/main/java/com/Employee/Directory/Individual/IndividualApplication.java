package com.Employee.Directory.Individual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = "com.Employee.Directory.Individual")
public class IndividualApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndividualApplication.class, args);
	}

}
