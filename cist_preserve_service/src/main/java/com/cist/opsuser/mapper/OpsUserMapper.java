package com.cist.opsuser.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cist.opsflow.model.Jtyw_company;
import com.cist.opsuser.model.Jtyw_staff;
import com.cist.opsvdt.model.Jtyw_group;


public interface OpsUserMapper {

	/**
	 * 用户管理详情
	 * @param map
	 * @return
	 */
	List<Jtyw_staff> quertAll(Map<String, Object> map);
	
	/**
	 * 用户详情
	 * @param map
	 * @return
	 */
	List<Jtyw_company> queryUser(Map<String, Object> map);
	
	/**
	 * 所属维护组
	 * @param map
	 * @return
	 */
	List<Jtyw_group> queryGroup(Map<String, Object> map);
	
	/**
	 * 修改用户单位管理详情
	 * @param map
	 * @return
	 */
	Integer updateOps(Map<String, Object> map);
	
	/**
	 * 添加用户单位管理详情
	 * @param map
	 * @return
	 */
	Integer insertOps(Map<String, Object> map);
	
	/**
	 * 删除用户单位管理详情
	 * @param map
	 * @return
	 */
	Integer deleteOps(Map<String, Object> map);
	
	
	/**
	 * 批量删除
	 * @return
	 */
	Integer deleteAll(String[] pk);
	
	
	/**
	 * 维护公司别名
	 * @param map
	 * @return
	 */
	Jtyw_company skCompanyName(HashMap<String, Object> map);
	
	/**
	 * 维护组别名
	 * @param map
	 * @return
	 */
	Jtyw_group skGroupName(HashMap<String, Object> map);
}
