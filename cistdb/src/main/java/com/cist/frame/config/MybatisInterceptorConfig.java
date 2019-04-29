package com.cist.frame.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.apache.ibatis.plugin.Interceptor;
 

/***
 * 
 * @Title:MybatisInterceptorConfig.java
 * @Package:com.cist.frame.config
 * @Description:TODO
 * @author:YT
 * @date:2019年3月30日
 * @version V1.0
 */
@Configuration
public class MybatisInterceptorConfig {
	@Bean
	public Interceptor getInterceptor(){
		return new MybatisSqlInterceptor();
	}
}

