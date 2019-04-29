package com.cist.securityfacility.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cist.frame.page.PageInfo;
import com.cist.securityfacility.model.Jcsj_sps_facilities;
import com.cist.securityfacility.model.Sys_frm_code;

public interface SecurityFacilityService {
	/**
	 * 查询安防设施信息
	 * @param map
	 * @return
	 */
	public List<Jcsj_sps_facilities> querySecurityFacility(HashMap<String,Object> map);
	/**
	 * 查询安防设施信息（分页查询）
	 * @param map
	 * @return
	 */
	public Object querySecurityFacilitypageList(HashMap<String,Object> map,PageInfo info);
	/**
	 * 新增安防设施信息
	 * @param map
	 * @return
	 */
	public Integer insertSecurityFacility(Map<String,Object> map);
	/**
	 * 更新安防设施信息
	 * @param map
	 * @return
	 */
	public Integer updateSecurityFacility(Map<String,Object> map);
	/**
	 * 删除安防设施信息（单条/批量删除）
	 * @param map
	 * @return
	 */
	public Integer delSecurityFacility(HashMap<String,Object> map);
	
	/**
	 * 查询基础数据信息
	 * @param map
	 * @return
	 */
	public List<Sys_frm_code> querySys_frm_code(HashMap<String,Object> map);
	
}
