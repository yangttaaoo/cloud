/**  

* <p>Title: AccessFilter.java</p>  

* <p>Description: </p>    

* @author zah  

* @date 2018年5月2日  

* @version 1.0  

*/
package com.cist.zuul;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * @ClassName: AccessFilter
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2018年5月2日
 * 
 */
@Component
public class AccessFilter extends ZuulFilter{
	@Autowired
	HttpServletRequest httpServletRequest;
	@Autowired
	HttpServletResponse httpServletResponse;
		
	@Override
	public Object run(){
		boolean isAllowed = true;
		RequestContext ctx = RequestContext.getCurrentContext();
		String sessionId = httpServletRequest.getSession().getId();
		String path = httpServletRequest.getRequestURI();
		if(isAllowed){
			ctx.addZuulRequestHeader("Cookie", "SESSION=" + sessionId);
			ctx.setSendZuulResponse(true);// 对该请求进行路由
			ctx.setResponseStatusCode(200); // 返回200正确响应	
		}else{
			ctx.setSendZuulResponse(false);// 不对该请求进行路由
			ctx.setResponseStatusCode(401); // 返回401错误代码
			String respStr = "{\"message\":\"此请求无访问权限\",\"status\":\"401\",\"path\":\""+path+"\"}";
			httpServletResponse.setCharacterEncoding("utf-8");
			ctx.setResponseBody(respStr);
		}
		return null;
	}

	public boolean shouldFilter() {
		return true;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	public int filterOrder() {
		return 0;
	}
}
