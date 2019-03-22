package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitMqTest01Application {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqTest01Application.class, args);
	}

}
