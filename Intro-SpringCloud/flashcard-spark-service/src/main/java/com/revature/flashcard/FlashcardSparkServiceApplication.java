package com.revature.flashcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FlashcardSparkServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashcardSparkServiceApplication.class, args);
	}
}
