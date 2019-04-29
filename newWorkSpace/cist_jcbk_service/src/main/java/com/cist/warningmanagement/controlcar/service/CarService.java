package com.cist.warningmanagement.controlcar.service;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.warningmanagement.bayonet.model.DeptInfo;
import com.cist.warningmanagement.bayonet.model.Qylx;
import com.cist.warningmanagement.controlcar.model.Kklx;
import com.cist.warningmanagement.controlcar.model.Police;
import com.cist.warningmanagement.controlcar.model.Sys_frm_code;
import com.cist.warningmanagement.controlcar.model.Tbl_control_vehicle;

public interface CarService {
	 Object   selectAllpageList(HashMap<String,Object> map,PageInfo page);
	 
	   //号牌种类
	   public List<Sys_frm_code> selectHpzl(HashMap<String,Object> map);
	   //号牌颜色
	   public List<Sys_frm_code> selectCsys(HashMap<String,Object> map);
	   //车辆类型
	   public List<Sys_frm_code> selectCllx(HashMap<String,Object> map);
	   //删除数据
	   public  Integer deleteData(HashMap<String,Object> map);
	   //增加数据
	   public  Integer addData(HashMap<String,Object> map);
	   //更新数据
	   public  Integer updateData(HashMap<String,Object> map);

	   List<Sys_frm_code> selectClpp(HashMap<String, Object> map);
	   
	   Sys_frm_code  selectName(HashMap<String, Object> map);

	   Integer deleteAll(String[] pk);
       //卡口类型
	   List<Kklx> selectKklx(HashMap<String, Object> map);
	   
	   DeptInfo  selectDepat(HashMap<String, Object> map);

	   Tbl_control_vehicle selectHphm(HashMap<String, Object> map);
	   
	   //查询布控区域
	   Qylx selectQy (HashMap<String, Object> map);
	 //查詢警員姓名
	   Police selectPolice(HashMap<String, Object> map);
}