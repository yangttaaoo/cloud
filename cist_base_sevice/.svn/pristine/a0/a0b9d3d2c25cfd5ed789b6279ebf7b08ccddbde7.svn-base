package com.cist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=18000,redisFlushMode = RedisFlushMode.IMMEDIATE)
@EnableEurekaClient
public class BaseServiceApplication{

	public static void main(String[] args) {
		SpringApplication.run(BaseServiceApplication.class, args);
	}
}
