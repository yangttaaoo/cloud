package com.cist.dveallot.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cist.dveallot.model.C_road_item;
import com.cist.dveallot.model.Jtyw_device_allot;
import com.cist.dveallot.model.Sys_frm_code;
import com.cist.dveallot.model.Vw_dev_info;
import com.cist.frame.page.PageInfo;
import com.cist.opsflow.model.Jtyw_company;
import com.cist.opsvdt.model.Jtyw_group;

@Service(value="DveAllotServiceImpl")
public interface DveAllotService {
	
	/**
	 * 分配详情
	 * @param map
	 * @return
	 */
	List<Jtyw_device_allot> querylist(Map<String, Object> map);
	
	/**
	 * 所属道路
	 * @param map
	 * @return
	 */
	List<C_road_item> queryRoad(Map<String, Object> map);
	
	/**
	 * 设备详情
	 * @param map
	 * @return
	 */
	List<Vw_dev_info> queryInfo(Map<String, Object> map);
	Object queryInfopageList(Map<String, Object> map,PageInfo pinfo);
	
	
	/**
	 * 小组别名
	 * @param map
	 * @return
	 */
	Jtyw_group	skGroupName(Map<String, Object> map);
	
	List<Jtyw_company> queryComp(Map<String, Object> map);
	List<Jtyw_group> queryGroup(Map<String, Object> map);
	/**
	 * 提交设备
	 * @param map
	 * @return
	 */
	Integer addList(Map<String, Object> map);
	
	/**
	 * 设备类型
	 * @param fct_code
	 * @return
	 */
	List<Sys_frm_code> selectDevList(String fct_code);
}
