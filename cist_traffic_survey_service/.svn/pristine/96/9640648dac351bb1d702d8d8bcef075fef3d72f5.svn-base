package com.cist.policemngment.mapper;

import java.util.List;
import java.util.Map;

import com.cist.policemngment.model.DeptInfo;
import com.cist.policemngment.model.Jcsj_P_R_Allot;
import com.cist.policemngment.model.Jcsj_P_R_Have;
import com.cist.policemngment.model.Jcsj_police_resourc;
import com.cist.policemngment.model.SysPoliceInfo;
import com.cist.policemngment.model.Sys_frm_code;

public interface PoliceMngmentMapper {

	/**
	 * 分页及条件查询
	 * @param map
	 * @return
	 */
	List<Jcsj_police_resourc> selectByResourc(Map<String, Object> map);
	
	/**
	 * 管理单位树
	 * @param dept_superior
	 * @return
	 */
	List<DeptInfo> depart_infolist(Integer dept_superior);
	
	/**
	 * 删除警务
	 * @param map
	 * @return
	 */
	Integer deletePolice(Map<String, Object> map);
	
	/**
	 * 删除具备功能
	 * @param map
	 * @return
	 */
	Integer deleteHave(Map<String, Object> map);
	
	/**
	 * 新增警务资源管理 
	 * @param map
	 * @return
	 */
	Integer insetResourc(Map<String, Object> map);
	
	
	
	/**
	 * 分配设备到警员
	 * @param map
	 * @return
	 */
	Integer allotPolice(Map<String, Object> map);
	
	/**
	 * 修改警务资源管理 
	 * @param map
	 * @return
	 */
	Integer updateResourc(Map<String, Object> map);
	/**
	 * 修改警务
	 * @param map
	 * @return
	 */
	Integer updatePolicce(Map<String, Object> map);
	/**
	 * 删除警务资源管理 
	 * @param map
	 * @return
	 */
	Integer deleteResourc(Map<String, Object> map);
	
	/**
	 * 修改警务资源设备具备功能
	 * @param map
	 * @return
	 */
	Integer updateHave(Map<String, Object> map);
	
	/**
	 * 警员查询
	 * @return
	 */
	List<SysPoliceInfo> selectPolice();
	
	/**
	 * 
	 * @return
	 */
	List<Jcsj_P_R_Have> selectHave(Map<String, Object> map);
	/**
	 * 警员默认选中
	 * @param map
	 * @return
	 */
	List<Jcsj_P_R_Allot> selectPoliceCheck(Map<String, Object> map);
	
	/**
	 * 添加警务资源设备
	 * @param map
	 * @return
	 */
	Integer insertHave(Map<String, Object> map);
	
	
	/**
	 * 车辆类型
	 * @param fct_code
	 * @return
	 */
	List<Sys_frm_code> selectSysFrmCode(String fct_code);
	
	/**
	 * 警车、GPS关联信息
	 * @return
	 */
	List<SysPoliceInfo> selectCarGPS();
}
