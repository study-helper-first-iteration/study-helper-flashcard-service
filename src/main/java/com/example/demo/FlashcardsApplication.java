package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.entities") // will allow spring to find your entities
@ComponentScan("com.example") // please scan all packages and any class labeled with component incorporate into the spring application
@EnableJpaRepositories("com.example.repositories") // Telling Spring where to find my repositories
@EnableEurekaClient
public class FlashcardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashcardsApplication.class, args);
	}

}
