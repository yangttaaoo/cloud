package com.cist;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootApplication
@EnableTransactionManagement
@EnableEurekaClient
@EnableRedisHttpSession(maxInactiveIntervalInSeconds= 18000)
//@ServletComponentScan
public class ZhddApplication{

	public static void main(String[] args) throws JsonProcessingException {
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		ObjectMapper mapper = new ObjectMapper();	
		HashMap<String, Object> modelMap = new LinkedHashMap<String, Object>();
		modelMap.put("di", 22);	modelMap.put("name", 22);
		listmap.add(modelMap);
		listmap.add(modelMap);
		String json=mapper.writeValueAsString(listmap);
		
		System.err.println(json);
		//HashMap<String,Object> modelMap =new HashMap<String, Object>();
		//modelMap.put("dept_pk", "[2_1, 11066_3, 8474_1]");
	SpringApplication.run(ZhddApplication.class, args);
/*		List<HashMap<String,Object>> listmap=new ArrayList<HashMap<String,Object>>();
		String info=modelMap.get("dept_pk").toString();
		String jie[]=info.substring(1,info.length()-1).split(",");
		for (String string : jie) {
			HashMap<String,Object> map =new HashMap<String, Object>();
			String pkleve[]=string.split("_");
			map.put("dept_pk", pkleve[0]);
			map.put("level", pkleve[1]);
			listmap.add(map);
		}
		for (HashMap<String,Object> list : listmap) {
			//System.err.println(list.get("dept_pk").toString().trim());
			System.err.println(list.get("level").toString().trim());
		}*/
		
	}
	/* @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(new RequestLog());
	    }*/
}
