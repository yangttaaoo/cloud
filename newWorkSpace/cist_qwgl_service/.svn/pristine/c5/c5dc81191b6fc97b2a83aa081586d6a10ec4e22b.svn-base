package com.cist.qwgl.bcgl.service;

import java.util.HashMap;
import java.util.List;

import com.cist.frame.page.PageInfo;
import com.cist.qwgl.bcgl.model.DeptInfo;
import com.cist.qwgl.bcgl.model.Qw_type;
import com.cist.qwgl.bcgl.model.Qwgl_bc_info;

public interface BcglService {
	/**
	 * 分页查询班次管理基础信息
	 * @param map
	 * @param info
	 * @return
	 */
	public Object querybcpageList(HashMap<String,Object> map,PageInfo info);
	/**
	 * 查询班次管理基础信息
	 * @param map
	 * @return
	 */
	public List<Qwgl_bc_info> querybc(HashMap<String,Object> map);
	/**
	 * 查询勤务类型基础信息
	 * @param map
	 * @return
	 */
	public List<Qw_type> queryqwlx(HashMap<String,Object> map);
	/**
	 * 管理单位树
	 * @param dept_superior
	 * @return
	 */
	public List<DeptInfo> depart_infolist(Integer dept_superior);
	/**
	 * 查询最大的pk
	 * @return
	 */
	public Integer querymaxpk();
	/**
	 * 添加班次信息
	 * @param map
	 * @return
	 */
	public Integer addbcinfo(HashMap<String,Object> map);
	/**
	 * 更新班次信息
	 * @param map
	 * @return
	 */
	public Integer updatebcinfo(HashMap<String,Object> map);
	/**
	 * 删除班次信息（批量/单条）
	 * @param map
	 * @return
	 */
	public Integer deletebcinfo(HashMap<String,Object> map);
	/**
	 * 查询单位
	 * @param dept_pk
	 * @return
	 */
	public String querydept(String dept_pk);

}
