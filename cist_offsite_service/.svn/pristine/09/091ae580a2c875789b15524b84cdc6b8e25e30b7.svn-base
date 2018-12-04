package com.cist.redinfo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.redinfo.model.Car;
import com.cist.redinfo.model.Car_Type;
import com.cist.redinfo.model.Color;
import com.cist.redinfo.model.Depart_info;
import com.cist.redinfo.model.RedInfo;
import com.cist.redinfo.model.Sys_frm_code;
import com.cist.frame.page.PageInfo;
import com.cist.redinfo.mapper.RedInfoMapper;
import com.cist.redinfo.service.RedInfoService;
@Service("redinfoserviceimpl")
public class RedInfoServiceImpl implements RedInfoService {
	@Autowired
    private RedInfoMapper mapper;
	
	public Object selectRedInfopageList(Map map, PageInfo page) {
		return mapper.selectRedInfo(map);
	}

	public RedInfo selectByfk(Integer pk) {
		return mapper.selectByfk(pk);
	}
	/**
	 * 红名单车
	 */
	public Car  selectCar(HashMap<String,Object> map){
		return mapper.selectCar(map);		
	}
	 /**
	 * 查询车身颜色
	 */
	public Sys_frm_code selectInfo(HashMap<String,Object> map){
		return mapper.selectInfo(map);
	}
	public List<Color> selectColors(){
		return mapper.selectColors();
	}
	/**
	 * 查询车身颜色
	 */
	public Depart_info selectDepart(HashMap<String,Object> map){
		return mapper.selectDepart(map);		
	}
	public 	List<Depart_info> selectDeparts(){
		return mapper.selectDeparts();		
	}

	public List<Sys_frm_code> selectCllx() {
		return mapper.selectCllx();
	}
}
