package com.cist.utils;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.cist.policeofficer.model.SysPoliceInfo;


public class BaseController {
	/***
	 * 
	 * @Title:  BaseController.java   
	 * @Package com.cist.utils   
	 * @Description:    获取登录用户
	 * @author: 王涛    
	 * @date:   2018年6月5日 下午3:15:06 
	 * @param: @param obj
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: String      
	 * @throws 
	 * @version V1.0
	 */
	@SuppressWarnings("unchecked")
	public static SysPoliceInfo getUser(HttpServletRequest request) throws Exception {
		HashMap<String,Object> modelMap=(HashMap<String, Object>) request.getSession().getAttribute("sysPoliceInfo");
		return (SysPoliceInfo) JavaBeanUtil.convertMapToBean(modelMap, SysPoliceInfo.class);
	}
  
}
