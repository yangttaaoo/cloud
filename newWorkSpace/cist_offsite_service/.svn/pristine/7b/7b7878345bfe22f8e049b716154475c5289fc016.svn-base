package com.cist.user.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.user.model.PlateColor;
import com.cist.user.service.FirstService;

@RestController
@SuppressWarnings("unchecked")
public class FirstController {
    
	@Value("${server.port}")
	private String port;
	
	@Autowired
	private FirstService service;
	@RequestMapping("index")
	public String index(HttpServletRequest request){
		PageInfo  info=new PageInfo();
		PageInfo<PlateColor> pinfo = (PageInfo<PlateColor>)service.querylistpageList();
		@SuppressWarnings("unused")
		Cookie[] cookie = request.getCookies();
		String str = "s";
		System.out.println("---------------"+request.getSession().getId()+"----------------");
		if(port.equals("8762")){
			request.getSession().setAttribute("user","zah");
		}
		if(null!=request.getSession().getAttribute("user")){
			str = request.getSession().getAttribute("user").toString();
		}
		return str+port+"s";
	}
	
	
}
