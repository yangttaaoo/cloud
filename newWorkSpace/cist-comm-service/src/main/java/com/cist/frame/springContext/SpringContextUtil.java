package com.cist.frame.springContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware{

	private static ApplicationContext application;
	
	@Override
	public void setApplicationContext(ApplicationContext ApplicationContext) throws BeansException {
		SpringContextUtil.application = ApplicationContext;
	}
	
	public static ApplicationContext getApplicationContext() {  
		return application;  
    } 
	
	public static <T>T getBean(Class<T> requiredType) throws Exception{
		return application.getBean(requiredType);
	}
	
	public static <T>T getBeanByName(String BeanName,Class<T> requiredType) throws Exception{
		return application.getBean(BeanName, requiredType);
	}
}
