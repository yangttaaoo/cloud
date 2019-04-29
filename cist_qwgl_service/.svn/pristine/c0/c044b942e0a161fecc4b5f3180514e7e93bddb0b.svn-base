package com.cist;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableEurekaClient
@EnableRedisHttpSession(maxInactiveIntervalInSeconds= 18000)
public class QwglServiceApplication{

	public static void main(String[] args) {
	/*	Double a=(double) (4D/5D)*100;
		System.err.println(a);*/
		SpringApplication.run(QwglServiceApplication.class, args);
	}

}