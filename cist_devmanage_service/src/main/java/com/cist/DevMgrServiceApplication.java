package com.cist;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@SpringBootApplication
@EnableTransactionManagement
@EnableEurekaClient
@EnableRedisHttpSession(maxInactiveIntervalInSeconds= 18000)
//@ServletComponentScan
public class DevMgrServiceApplication{

	public static void main(String[] args) {
		SpringApplication.run(DevMgrServiceApplication.class, args);
	}
	/* @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(new RequestLog());
	    }*/
}
