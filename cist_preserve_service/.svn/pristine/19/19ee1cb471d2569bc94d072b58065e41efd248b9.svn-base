package com.cist.assetstatis.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.assetstatis.model.JksbzcInfo;
import com.cist.assetstatis.service.AssetStatisService;

/***
 * 
 * @Title:  DeptDutyAllController.java   
 * @Package com.cist.deptdutyall.controller
 * @Description:    交通运维-资产统计
 * @author: 田隽杭    
 * @date:   2018年8月6日 下午02:07:00 
 * @version V1.0
 */
@RestController
@RequestMapping("/assets")
public class AssetStatisController {
	@Autowired
	private AssetStatisService service;
	
	/**
	 * 设备总数查询
	 */
	@RequestMapping("devtotal")
	public  List<JksbzcInfo>  devtotal(){
		return service.devtotal();
	}
	/**
	 * 资产类型查询
	 */
	@RequestMapping("typeinfo")
	public  List<JksbzcInfo>  typeinfo(@RequestBody HashMap<String,Object> modelMap){
		List<JksbzcInfo> list = service.typeinfo(modelMap);
		for(int i=0;i<list.size();i++){
			if(list.get(i).getDevice_type().equals("1")){
				list.get(i).setDevice_type_name("电警");
			}else if(list.get(i).getDevice_type().equals("2")){
				list.get(i).setDevice_type_name("卡口");
			}else{
				list.get(i).setDevice_type_name("红外测速");
			}
		}
		return list;
	}
	/**
	 * 资产类型查询
	 * @throws ParseException 
	 */
	@RequestMapping("dateinfo")
	public  List<JksbzcInfo>  dateinfo(@RequestBody HashMap<String,Object> modelMap) throws ParseException{
		List<JksbzcInfo> list;
		int a  = (int) modelMap.get("sjlx");
		if(a==1){
			list = service.dateinfo1(modelMap);
		}else if(a==2){
			list = service.dateinfo2(modelMap);
		}else if(a==3){
			list = service.dateinfo3(modelMap);
		}else if(a==4){
			list = service.dateinfo(modelMap);
		}else{
			list = service.dateinfo4(modelMap);
		}
		
		return list;
	}
}
