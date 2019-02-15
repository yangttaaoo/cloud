package com.cist.opsvdt.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.opsvdt.model.Jtyw_group;
import com.cist.opsvdt.model.Jtyw_group_member;
import com.cist.opsvdt.model.Tbl_corp_m;

@Service(value="OpsDvtServiceImpl")
public interface OpsDvtService {

	/**
	 * 维护组管理详情
	 * @param map
	 * @param pinfo
	 * @return
	 */
	Object queryAllpageList(Map<String, Object> map,PageInfo pinfo);
	
	/**
	 * 修改维护组管理详情
	 * @param map
	 * @return
	 */
	Integer updateVdt(Map<String, Object> map);
	
	/**
	 * 修改维护组管理详情
	 * @param map
	 * @return
	 */
	Integer updateVdts(Map<String, Object> map);
	
	/**
	 * 删除维护组管理详情
	 * @param map
	 * @return
	 */
	Integer deleteVdt(Map<String, Object> map);
	
	/**
	 * 删除维护组管理详情
	 * @param map
	 * @return
	 */
	Integer deleteVdts(Map<String, Object> map);
	
	/**
	 * 添加维护组管理详情
	 * @param map
	 * @return
	 */
	Integer insertVdt(Map<String, Object> map);
	
	/**
	 * 添加维护组管理详情
	 * @param map
	 * @return
	 */
	Integer insertVdts(Map<String, Object> map);
	
	/**
	 * 公司基本详情
	 * @param map
	 * @return
	 */
	List<Jtyw_group_member> queryCorp(Map<String, Object> map);
	
	/**
	 * 维护组基本详情
	 * @param map
	 * @return
	 */
	List<Jtyw_group> queryGroup(Map<String, Object> map);
	
	/**
	 * 批量删除
	 * @return
	 */
	Integer deleteAlls(String[] pk);
	
}
