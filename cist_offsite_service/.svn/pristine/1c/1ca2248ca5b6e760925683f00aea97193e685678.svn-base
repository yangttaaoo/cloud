package com.cist.picture.service;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cist.frame.page.PageInfo;
import com.cist.picture.model.C_plate_type;
import com.cist.picture.model.Depart_info;
import com.cist.picture.model.MenuDetails;
import com.cist.picture.model.Monitorpoint;
import com.cist.picture.model.Tbl_offe_cate;
import com.cist.picture.model.Tbl_offe_evdi;


public interface PictureService {
	/***
	 * 
	 * @Title:  PictureService.java   
	 * @Package com.cist.picture.service   
	 * @Description:    分页查询图片筛选
	 * @author: 王涛    
	 * @date:   2018年5月10日 上午9:33:55 
	 * @param: @param map
	 * @param: @return      
	 * @return: List<Tbl_offe_evdi>      
	 * @throws 
	 * @version V1.0
	 */
	public List<Tbl_offe_evdi> querylistpageList(HashMap<String,Object> map); 
	/****
	 * 
	 * @Title:  PictureService.java   
	 * @Package com.cist.picture.service   
	 * @Description:    图片筛选数据作废
	 * @author: 王涛    
	 * @date:   2018年5月10日 上午9:35:02 
	 * @param: @param map      
	 * @return: void      
	 * @throws 
	 * @version V1.0
	 */
	public Integer updateTbloffeevdi(HashMap<String,Object> map); 
	//查询所有号牌种类
	public List<C_plate_type> plateTypeList();
	//查询所有违法行为
	public List<Tbl_offe_cate> tblOffeCateList();
	//查询违法行为
	public Tbl_offe_cate tblOffeCate(HashMap<String,Object> map);
	
	//上级下级部门
	public List<Depart_info> depart_infolist(Integer dept_superior);
	//部门下的设备
	public List<Depart_info> clickdepartinfo(String dept_superior);
	//卡口下的设备
	public List<Depart_info> kakou(HashMap<String,Object> map);
	//根据部门获取 违法地点
	public List<Depart_info> Monitorpoint(String tbmp_dept_code);
	//根据部门获取 采集设备
	public List<Depart_info> acquisition(String tbmp_dept_code);
	 public List<MenuDetails> queryAccountAuthorityForList(Integer police_code);
	 
	//设备的路段
	public List<Depart_info> yijicdepartinfo(HashMap<String,Object> map);
	//设备的路段下的设备
	public List<Depart_info> kakouxiabu(HashMap<String,Object> map);
	//审核数
	public Integer auditnumber(HashMap<String,Object> map);
	//基础代码表
	public Integer sycivalue(HashMap<String,Object> map);
	//今日审核总计
	public Integer getjintiri(HashMap<String,Object> map);
	//图片初筛总数
	public Integer quantity();
	
}
