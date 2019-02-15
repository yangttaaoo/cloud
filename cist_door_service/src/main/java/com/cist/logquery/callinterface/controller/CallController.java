package com.cist.logquery.callinterface.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.logquery.callinterface.model.CallType;
import com.cist.logquery.callinterface.model.Interface;
import com.cist.logquery.callinterface.service.CallService;

@RestController
@RequestMapping("call")
public class CallController {
@Autowired 
private CallService service;
     @RequestMapping("/getall")
     public PageInfo<Interface> selecteAll(@RequestBody HashMap<String,Object> map){
    	 try {
			PageInfo page=new PageInfo();
			page.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<Interface> info=(PageInfo<Interface>) service.selecteAllpageList(map, page);
			return info;
		} catch (Exception e) {
			
		}
		return null;    	 
     }
     /**
      * 删除所有数据
      * @param pk
      * @return
      */
     @RequestMapping("/deleteAll")
     public Integer deleteAll(@RequestParam("pk") String[] pk){
   	  Integer in=service.deleteAll(pk);
		return in;    	  
     }
     /**
      * 删除单条数据
      */
     @RequestMapping("/deleteOne")
     public Integer deleteAll(@RequestParam String pk){
   	 Integer te= Integer.parseInt(pk);
   	  Integer in=service.deleteOne(te);
		return in;    	  
     }
     /**
      * 查询接口名称
      */
     @RequestMapping("/type")
     public List<CallType> selectType(){
    	 return service.selecteType();
     }
}
