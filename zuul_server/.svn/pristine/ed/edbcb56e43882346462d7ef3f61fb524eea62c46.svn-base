package com.cist;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import com.cist.BaseInfo.model.BaseDataInfo;
import com.cist.BaseInfo.service.BaseService;
import com.cist.zuul.CustomRouteLocator;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableTransactionManagement
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 18000, redisFlushMode = RedisFlushMode.IMMEDIATE)
public class ZullServerApplication {
	@Autowired
	ZuulProperties zuulProperties;
	
	@Autowired
	ServerProperties server;
	
	@Autowired
	private BaseService service;
   	
	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("ObjectredisTemplate")
	private RedisTemplate redisTemplate;

	@Bean
	public CustomRouteLocator routeLocator() {
		CustomRouteLocator routeLocator = new CustomRouteLocator(this.server.getServletPrefix(), this.zuulProperties);
		return routeLocator;
	}

	public static void main(String[] args) {
		SpringApplication.run(ZullServerApplication.class, args);

	}

	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true); // 允许cookies跨域 
		config.addAllowedOrigin("*");// 允许向该服务器提交请求的URI，*表示全部允许。。这里尽量限制来源域，比如http://xxxx:8080
									// ,以降低安全风险。。
		config.addAllowedHeader("*");// 允许访问的头信息,*表示全部
		config.setMaxAge(18000L);// 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
		config.addAllowedMethod("*");// 允许提交请求的方法，*表示全部允许，也可以单独设置GET、PUT等
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void getBaseDataFromRedis(){
		try {
			List<BaseDataInfo> list = this.service.queryBaseList();
			for(BaseDataInfo info : list){
				String fct_code = info.getFct_code().trim();
				String fc_code = info.getFc_code().trim();
				ValueOperations<Serializable, Object> operations1 = this.redisTemplate.opsForValue();
				operations1.set("key_"+fct_code+"_"+fc_code, info);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
