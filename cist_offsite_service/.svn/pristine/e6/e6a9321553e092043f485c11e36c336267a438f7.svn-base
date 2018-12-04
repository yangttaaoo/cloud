package com.cist.menu.controller;
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

import com.cist.menu.model.Menu;
import com.cist.menu.service.MenuService;
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
 * @Description:    菜单
 * @author: 王涛    
 * @date:   2018年5月10日 下午4:27:35 
 * @version V1.0
 */
@RestController
@RequestMapping("menu")
public class MenuController extends BaseController{
    
	@Value("${server.port}")
	private String port;
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("getmenuinfo")
	public List<Menu> getToUsers(HttpServletRequest request) throws Exception{
		HashMap<String,Object> map=new HashMap<String, Object>();
		//父菜单  1
		map.put("symi_parent", 16);
		List<Menu> list=menuService.selectMenu(map);
		
		 return  getdigun(list);
	}
	public List<Menu> getdigun(List<Menu> list){
		HashMap<String,Object> map=new HashMap<String, Object>();
		for (Menu menu : list) {
			map.put("symi_parent", menu.getSymi_pk());
			List<Menu> listdi=menuService.selectMenu(map);
			menu.setChild(listdi);
			if(null!=list){
				getdigun(listdi);
			}
			
		}
		return list;
	}
}
