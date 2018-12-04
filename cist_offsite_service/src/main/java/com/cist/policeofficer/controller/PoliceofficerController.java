package com.cist.policeofficer.controller;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;















import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.picture.model.C_plate_type;
import com.cist.picture.model.Depart_info;
import com.cist.picture.model.MenuDetails;
import com.cist.picture.model.Tbl_offe_cate;
import com.cist.picture.model.Tbl_offe_evdi;
import com.cist.picture.service.PictureService;
import com.cist.policeofficer.model.SysPoliceInfo;
import com.cist.policeofficer.service.PoliceofficerService;
import com.cist.utils.BaseController;
import com.cist.utils.JavaBeanUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/***
 * 
 * @Title:  PictureController.java   
 * @Package com.cist.offsite.controller.firsttrial.picture   
 * @Description:    警员登录
 * @author: 王涛    
 * @date:   2018年5月10日 下午4:27:35 
 * @version V1.0
 */
@RestController
@RequestMapping("officer")
public class PoliceofficerController extends BaseController{
    
	@Value("${server.port}")
	private String port;
	
	@Autowired
	private PoliceofficerService service;
	/***
	 * 
	 * @Title:  PoliceofficerController.java   
	 * @Package com.cist.policeofficer.controller   
	 * @Description:    获取登录用户信息
	 * @author: 王涛    
	 * @date:   2018年6月5日 下午3:19:51 
	 * @param: @param modelMap
	 * @param: @param request
	 * @param: @return
	 * @param: @throws IllegalAccessException
	 * @param: @throws InvocationTargetException
	 * @param: @throws IntrospectionException      
	 * @return: SysPoliceInfo      
	 * @throws Exception 
	 * @throws 
	 * @version V1.0
	 */
	@RequestMapping("getToUsers")
	public SysPoliceInfo getToUsers(HttpServletRequest request) throws Exception{
		 return getUser(request);
	}
	
	@RequestMapping("policeLogin")
	public SysPoliceInfo policeLogin(@RequestBody HashMap<String,Object> modelMap,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException, IntrospectionException{
		SysPoliceInfo sysPoliceInfo=service.policeLogin(modelMap);
		if(null!=sysPoliceInfo){
			request.getSession().setAttribute("sysPoliceInfo", JavaBeanUtil.convertBeanToMap(sysPoliceInfo));
		}
		 return sysPoliceInfo;
	}

}
