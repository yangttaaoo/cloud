/**  

* <p>Title: AfterAccessFilter.java</p>  

* <p>Description: </p>    

* @author zah  

* @date 2018年9月12日  

* @version 1.0  

*/
package com.cist.zuul;

import java.io.Serializable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.cist.BaseInfo.model.BaseDataInfo;
import com.cist.BaseInfo.model.BaseDataModel;
import com.netflix.zuul.ZuulFilter;

/**
 * @ClassName: AfterAccessFilter
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2018年9月12日 
 * 
 */

@Component
public class AfterAccessFilter extends ZuulFilter {

	@Autowired
	HttpServletRequest httpServletRequest;
	@Autowired
	HttpServletResponse httpServletResponse;

	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netflix.zuul.IZuulFilter#shouldFilter()
	 */
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		String path = httpServletRequest.getRequestURI();
		return "/basedata/baseservice/login/userLogin".equals(path);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netflix.zuul.IZuulFilter#run()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object run() {
		// TODO Auto-generated method stub

		ValueOperations<Serializable, Object> operations = this.redisTemplate.opsForValue();
		BaseDataModel.BASE_DATA_MAP = (Map<String, Map<String, BaseDataInfo>>) operations.get("BaseInfo");
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netflix.zuul.ZuulFilter#filterType()
	 */
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "post";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netflix.zuul.ZuulFilter#filterOrder()
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
