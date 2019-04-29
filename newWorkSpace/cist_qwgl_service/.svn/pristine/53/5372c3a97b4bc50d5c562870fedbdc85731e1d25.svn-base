package com.cist.khpd.resultback.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.khpd.resultback.model.ResultBack;
import com.cist.khpd.resultback.service.ResultService;
import com.cist.khpd.resultback.model.Police;

@RestController
@RequestMapping("result")
public class ResultController {
@Autowired
private ResultService  service;
/**
 * 查询所有数据
 * @param map
 * @return
 */
@RequestMapping("/all")
public PageInfo<ResultBack>  selecteAll(@RequestBody HashMap<String,Object>  map){
	try {
		PageInfo  page=new PageInfo();
		page.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<ResultBack>  info=(PageInfo<ResultBack>) service.selectDatapageList(map, page);
		     return info;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;	
}
   /**
    * 增加部门数据
    * @param map
    * @return
    */
   @RequestMapping("/addDepart")
   public Integer addDatas(@RequestBody HashMap<String,Object>  map){
	   Integer  data=service.addData(map);
	   return data;
   }
   /**
    * 增加个人数据
    * @param map
    * @return
    */
   @RequestMapping("/addPerson")
   public Integer addPerson(@RequestBody HashMap<String,Object>  map){
	   Integer  data=service.addPersonData(map);
	   return data;	
   }
   /**
    * 删除数据
    * @param map
    * @return
    */
   @RequestMapping("/delete")
   public Integer deleteDatas(@RequestBody HashMap<String,Object>  map){
	    Integer  da=service.deleteData(map);
		return da;	    
   }
   /**
    * 更新数据
    * @param map
    * @return
    */
   @RequestMapping("/update")
   public Integer updateDatas(@RequestBody HashMap<String,Object>  map){
	   Integer ds=service.updateData(map);
	return ds;
   }
   /**
    * 回复
    * 
    */
   @RequestMapping("/reply")
   public Integer replyDatas(@RequestBody HashMap<String,Object>  map){
	   Integer ds=service.replyUser(map);
	return ds;
   }
   /**
    * 查询反馈人
    * 
    */
   @RequestMapping("/person")
   public Police replyDatas(HttpServletRequest request){
	   HttpSession session = request.getSession();
	   Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
	   String sypi_code = userMap.get("sypi_code")==null?null:userMap.get("sypi_code").toString();
	   Police po = service.selectPerson(sypi_code);
	  return po;
   }
}
