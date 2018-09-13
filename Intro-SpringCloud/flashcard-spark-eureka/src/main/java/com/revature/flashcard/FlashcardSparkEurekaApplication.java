package com.revature.flashcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class FlashcardSparkEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashcardSparkEurekaApplication.class, args);
	}
}
