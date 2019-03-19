package com.cist.warningmanagement.controlcar.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cist.configUrl.model.FileUtil;
import com.cist.frame.page.PageInfo;
import com.cist.warningmanagement.controlcar.model.Kklx;
import com.cist.warningmanagement.controlcar.model.Sys_frm_code;
import com.cist.warningmanagement.controlcar.model.Tbl_control_vehicle;
import com.cist.warningmanagement.controlcar.service.CarService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("carmanage")
public class CarControl {
@Autowired
   private CarService  service;
   @RequestMapping("/all")
   public PageInfo<Tbl_control_vehicle> selectAll(@RequestBody HashMap<String, Object> map){
	   try {
		   PageInfo page = new PageInfo();
			page.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			Object obj = service.selectAllpageList(map, page);
			PageInfo<Tbl_control_vehicle> tbl=(PageInfo<Tbl_control_vehicle>)obj;
			return  tbl;
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	return null;  
  }
   /**
    * 号牌种类
    */
   @RequestMapping("/hpzl")
   public List<Sys_frm_code> selectHpzl(@RequestBody HashMap<String, Object> map){
	   List<Sys_frm_code>   sys=service.selectHpzl(map);
	return sys;
   }
   /**
    * 车身颜色
    */
   @RequestMapping("/csys")
   public List<Sys_frm_code> selectCsys(@RequestBody HashMap<String, Object> map){
	   List<Sys_frm_code>   sys=service.selectCsys(map);
	return sys;
   }
   /**
    * 车辆类型
    */
   @RequestMapping("/cllx")
   public List<Sys_frm_code> selectCllx(@RequestBody HashMap<String, Object> map){
	   List<Sys_frm_code>   sys=service.selectCllx(map);
	return sys;
   }
   /**
    * 车辆类型
    */
   @RequestMapping("/clpp")
   public List<Sys_frm_code> selectClpp(@RequestBody HashMap<String, Object> map){
	   List<Sys_frm_code>  sys=service.selectClpp(map);
	return sys;
   }
   /**
    * 增加数据
    */
   @RequestMapping("/add")
   public Integer addData(MultipartFile file,String data){
	   String fileUploadService = FileUtil.FileUploadService(file);
	   ObjectMapper objectMapper = new ObjectMapper();
		HashMap map=new HashMap<String,Object>();
		try {
			
			map = objectMapper.readValue(data, HashMap.class); //JSON转Map
			
			//data为前台传递的参数JSON参数字符串
			
		} catch (JsonParseException e) {	
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
       map.put("tpzj", fileUploadService);
	   Integer in=service.addData(map);	 
	return in;
   }
   /**
    * 删除数据
    */
   @RequestMapping("/delete")
   public Integer deleteData(@RequestParam HashMap<String, Object> map){
	   Integer in=service.deleteData(map);
	return in;
   }
   /**
    * 批量删除
    */
   @RequestMapping("/deleteall")
   public Integer deleteAll(@RequestParam("pk")  String[] pk){
	  Integer in=service.deleteAll(pk);
	return in; 
   }
   /**
    * 更新数据
    */
   @RequestMapping("/update")
   public Integer updateData(MultipartFile file,String data){
	 
	   ObjectMapper objectMapper = new ObjectMapper();
		HashMap map=new HashMap<String,Object>();
		try {
			
			map = objectMapper.readValue(data, HashMap.class); //JSON转Map
			
			//data为前台传递的参数JSON参数字符串
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if((boolean)map.get("flag")==true){
	     String fileUploadService = FileUtil.FileUploadService(file);
	     map.put("tpzj", fileUploadService);
		}
      
	   Integer in=service.updateData(map);
	return in;
   }
	/**
	 * 查询号牌重复
	 */
   @RequestMapping("/hphm")
   public boolean selectHphm(@RequestBody HashMap<String, Object> map){
	   Tbl_control_vehicle  bore=service.selectHphm(map);
	   if(bore!=null){
		   return true;
		   	}
	return false;   
   }
   /**
    * 查询卡口类型
    */  
   @RequestMapping("/kklx")
    public List<Kklx> selectKklx(@RequestBody HashMap<String, Object> map){
 	   List<Kklx>   sys=service.selectKklx(map);
 	return sys;
    }
  
}