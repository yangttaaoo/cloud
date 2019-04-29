package com.yt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RedisDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(RedisDemo1Application.class, args);
	}

}
