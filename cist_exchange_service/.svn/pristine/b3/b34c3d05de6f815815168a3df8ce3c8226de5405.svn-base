package com.cist.visitinterface.service;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.visitinterface.model.DeptInfo;
import com.cist.visitinterface.model.SJGX_INTERFACE_TYPE;
import com.cist.visitinterface.model.SYS_depart_info;
import com.cist.visitinterface.model.SjgxDevCompany;

public interface VisitInterfaceService {
	/**
	 * 查询访问接口信息
	 * @return
	 */
	public Object queryinterfacepageList(HashMap<String,Object> map,PageInfo info);
	/**
	 * 查询接口类型信息
	 * @param map
	 * @return
	 */
	public List<SJGX_INTERFACE_TYPE> queryinterfacetype(HashMap<String,Object> map);
	/**
	 * 根据条件查询开发单位信息
	 * @param map
	 * @return
	 */
	public List<SjgxDevCompany> querydev(HashMap<String,Object> map);
	/**
	 * 查询管理部门
	 * @param dept
	 * @return
	 */
	public List<SYS_depart_info> querydept(SYS_depart_info dept);
	/**
	 * 添加访问接口信息
	 * @param map
	 * @return
	 */
	public Integer addsjgx(HashMap<String,Object> map);
	/**
	 * 管理单位树
	 * @param dept_superior
	 * @return
	 */
	List<DeptInfo> depart_infolist(Integer dept_superior);
	/**
	 * 查询pk_id最大值
	 * @return
	 */
	public Integer queryid();
	/**
	 * 删除接口
	 * @param map
	 * @return
	 */
	public Integer delinterface(HashMap<String,Object> map);
	/**
	 * 更新访问接口信息
	 * @param map
	 * @return
	 */
	public Integer updateinterface(HashMap<String,Object> map);
}
