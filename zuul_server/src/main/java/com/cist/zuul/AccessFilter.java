/**  

* <p>Title: AccessFilter.java</p>  

* <p>Description: </p>    

* @author zah  

* @date 2018年5月2日  

* @version 1.0  

*/
package com.cist.zuul;

import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cist.BaseInfo.model.BaseDataModel;
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
		
	@SuppressWarnings({ "unchecked"})
	@Override
	public Object run(){
		boolean isAllowed = false;
		RequestContext ctx = RequestContext.getCurrentContext();
		String sessionId = httpServletRequest.getSession().getId();
		String path = httpServletRequest.getRequestURI();
		if(null!=BaseDataModel.BASE_DATA_MAP.get("H001") && BaseDataModel.BASE_DATA_MAP.get("H001").containsKey(path)){
			isAllowed = true; //白名单放行直接 
		}else{
			Map<String,Object>  map = (Map<String,Object>)httpServletRequest.getSession().getAttribute("userInfo"+sessionId);	
			if(null != map && !map.isEmpty()){
				Map<String,Object> authMap = (Map<String,Object>)map.get("authorityMap");
				ArrayList<String> authList = (ArrayList<String>)authMap.get("operation");
				if(null!=authList && authList.size()>0 && authList.contains(path)){
					isAllowed = true;//请求路径有访问权限，放行
				}else{
					isAllowed = false; //没有任何权限，禁止通行
				}
				
			}else{
				
				isAllowed = false;//没有session（未登录）禁止通行
			}
		}
		if(true/**isAllowed**/){
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
