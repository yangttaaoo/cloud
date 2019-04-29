package com.cist;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.cist.utils.RequestLog;

@SpringBootApplication
@EnableTransactionManagement
@EnableEurekaClient
@EnableRedisHttpSession(maxInactiveIntervalInSeconds= 18000)
//@ServletComponentScan
public class OffesiteServiceApplication{

	public static void main(String[] args) throws ParseException {

			SpringApplication.run(OffesiteServiceApplication.class, args);
	}
	/* @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(new RequestLog());
	    }*/
}
