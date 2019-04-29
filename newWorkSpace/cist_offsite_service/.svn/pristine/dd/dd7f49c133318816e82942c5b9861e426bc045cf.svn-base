package com.cist.filing.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cist.filing.model.C_Monitor_Point_Ex;
import com.cist.filing.model.C_road_info;
import com.cist.filing.model.Monitor;
import com.cist.filing.model.Sys_frm_code;
import com.cist.filing.model.Sys_frm_code_type;
import com.cist.filing.model.Tbl_dev_vio_config;
import com.cist.filing.model.Vw_dev_info;
import com.cist.frame.page.PageInfo;


@Service(value="FilingServiceImpl")
public interface FilingService {
	
	
	/**
	 * 数据详情
	 * @param map
	 * @param info
	 * @return
	 */
	Object queryAllpageList(Map<String, Object> map,PageInfo info);
	
	/**
	 * 摄像机信息
	 * @return
	 */
	List<Vw_dev_info> queryTwoList(Map<String, Object> map);
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	List<Monitor> queryToMonitor(Map<String, Object> map);
	
	/**
	 * 查询摄像机详情
	 * @return
	 */
	List<Tbl_dev_vio_config> queryDetails(Map<String, Object> map);
	
	/**
	 * 
	 * @return
	 */
	List<Sys_frm_code> queryListAll();
	
	/**
	 * 
	 * @return
	 */
	List<Sys_frm_code> queryFrmCode(String fct_name);
	
	/**
	 * 添加点位信息
	 */
	Integer addMonitor(Map<String, Object> map);
	
	/**
	 * 添加摄像机备案
	 * @param map
	 * @return
	 */
	Integer addVideo(Map<String, Object> map);
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	Integer deleteManage(Map<String, Object> map);
	
	/**
	 * 单个删除摄像机备案
	 * @param map
	 * @return
	 */
	Integer deleteVideo(Map<String, Object> map);
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	Integer deleteList(Map<String, Object> map);
	
	/**
	 * 删除预置点位
	 * @param map
	 * @return
	 */
	Integer deleteGssp(Map<String, Object> map);
	
	/**
	 * 点位信息
	 * @param map
	 * @return
	 */
	List<C_Monitor_Point_Ex> queryMonitor();
	
	/**
	 * 行政规划
	 * @param map
	 * @return
	 */
	List<C_road_info> queryXzgh();
	
	/**
	 * 查询摄像机信息
	 * @return
	 */
	List<Tbl_dev_vio_config> queryMv();
	
	/**
	 * 基础代码详情
	 * @return
	 */
	List<Sys_frm_code> queryFrm();
	
	/**
	 * 点位类型
	 * @return
	 */
	List<Sys_frm_code_type> queryFrmType();
	
	/**
	 * 修改摄像机详情
	 * @param map
	 * @return
	 */
	Integer update(Map<String, Object> map);
	
}
