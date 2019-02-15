package com.cist.logquery.loginsystem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.log.logAnnotation.CistLog;
import com.cist.log.logAnnotation.LogType;
import com.cist.logquery.loginsystem.model.Sys_login_log;
import com.cist.logquery.loginsystem.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginControler {
@Autowired
private LoginService service;

	 @CistLog(type=LogType.DEFAULT,content="平台统一管理日志查询系统登录日志查询")
     @RequestMapping("/selecteall")
     public  PageInfo<Sys_login_log>  selecteDate(@RequestBody  HashMap<String,Object> map){
    	 try {
    		 PageInfo page=new PageInfo();
    		 page.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
    		 page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
    		 PageInfo<Sys_login_log> pages=(PageInfo<Sys_login_log>) service.selectDatapageList(map, page);
    		  return pages; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
     }
     @RequestMapping("onedata")
     public PageInfo<Sys_login_log> selecteOne(@RequestBody  HashMap<String,Object> map){
    	 try {
    		 PageInfo page=new PageInfo();
    		 page.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
    		 page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
    		 PageInfo<Sys_login_log> pages=(PageInfo<Sys_login_log>) service.selectOnepageList(map, page);
    		  return pages; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
     }
     @RequestMapping("/deleteall")
     public Integer deleteAll(@RequestParam("pk") String[] pk){
    	 Integer in=service.deleteAll(pk);
    	 return in;
     }
}
