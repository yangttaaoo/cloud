/**  

* <p>Title: CustomRouteLocater.java</p>  

* <p>Description: </p>    

* @author zah  

* @date 2018年7月7日  

* @version 1.0  

*/  
package com.cist.zuul;

import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;

/**  
    * @ClassName: CustomRouteLocater  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author Administrator  
    * @date 2018年7月7日  
    *    
    */
public class CustomRouteLocator extends SimpleRouteLocator{

	/**
	 * @param servletPath 
	 * @param properties
	 */
	private ZuulProperties properties;
	public CustomRouteLocator(String servletPath, ZuulProperties properties) {
		super(servletPath, properties);
		this.properties = properties;
	}

//	@Override
//	public Route getMatchingRoute(final String path) {
//
//	   Route route = getSimpleMatchingRoute(path);
//	   return route;
//	}
	
	protected Route getRoute(ZuulRoute route, String path) {
		if (route == null) {
			return null;
		}
		
		String targetPath = path;
		String prefix = this.properties.getPrefix();
		if(route.getPath().startsWith("/*")){
			String path1 = route.getPath();
			int start = path1.indexOf("/*")+2;
			int end =path1.lastIndexOf("/*");
			path1 = path1.substring(start,end );
			targetPath = targetPath.substring(targetPath.indexOf(path1));
			prefix = path.substring(0,path.indexOf(path1));
			System.out.println(prefix);
		}else{
			if (path.startsWith(prefix) && this.properties.isStripPrefix()) {
				targetPath = path.substring(prefix.length());
			}
			if (route.isStripPrefix()) {
				int index = route.getPath().indexOf("*") - 1;
				if (index > 0) {
					String routePrefix = route.getPath().substring(0, index);
					targetPath = targetPath.replaceFirst(routePrefix, "");
					prefix = prefix + routePrefix;
				}
			}
		}
	
		Boolean retryable = this.properties.getRetryable();
		if (route.getRetryable() != null) {
			retryable = route.getRetryable();
		}
		return new Route(route.getId(), targetPath, route.getLocation(), prefix,
				retryable,
				route.isCustomSensitiveHeaders() ? route.getSensitiveHeaders() : null);
	}

}
